package com.bloggios.user.exception;

import com.bloggios.user.constants.InternalErrorCodes;
import com.bloggios.user.constants.ServiceConstants;
import com.bloggios.user.exception.payload.BadRequestException;
import com.bloggios.user.payload.response.ExceptionResponse;
import com.bloggios.user.properties.FetchErrorProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.Instant;
import java.util.Date;
import java.util.Objects;

/**
 * Owner - Rohit Parihar and Bloggios
 * Author - rohit
 * Project - user-service
 * Package - com.bloggios.user.exception
 * Created_on - May 13 - 2024
 * Created_at - 12:23
 */

@RestControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    private final FetchErrorProperties fetchErrorProperties;

    public GlobalExceptionHandler(
            FetchErrorProperties fetchErrorProperties
    ) {
        this.fetchErrorProperties = fetchErrorProperties;
    }

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<ExceptionResponse> handleBadRequestException(BadRequestException badRequestException) {
        ExceptionResponse exceptionResponse = fetchErrorProperties.exceptionResponse(HttpStatus.BAD_REQUEST, badRequestException.getCode());
        if (Objects.nonNull(badRequestException.getMessage())) {
            exceptionResponse = fetchErrorProperties.generateExceptionResponse(HttpStatus.BAD_REQUEST, badRequestException.getMessage(), badRequestException.getCode());
        }
        logger.error("""
                BadRequestException Occurred : {}
                Message : {}
                Field : {}
                Code : {}
                Type : {}
                """,
                MDC.get(ServiceConstants.BREADCRUMB_ID),
                exceptionResponse.getMessage(),
                exceptionResponse.getField(),
                exceptionResponse.getCode(),
                exceptionResponse.getType());
        return new ResponseEntity<>(exceptionResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ExceptionResponse> handleException(Exception exception){
        ExceptionResponse build = getUncaughtExceptionResponse(exception);
        logger.error("{} : {}", build.getMessage(), build.getCode(), exception.getCause());
        return new ResponseEntity<>(build, HttpStatus.valueOf(build.getStatus()));
    }

    private static ExceptionResponse getUncaughtExceptionResponse(Exception exception) {
        logger.error("""
                Uncaught Exception Occurred at {}
                Cause : {}
                Message : {}
                Stack Trace : {}
                Class : {}
                """, Date.from(Instant.now()), exception.getCause(), exception.getMessage(), exception.getStackTrace(), exception.getClass());
        return ExceptionResponse
                .builder()
                .message(exception.getMessage())
                .code(InternalErrorCodes.INTERNAL_ERROR)
                .type(ServiceConstants.INTERNAL_ERROR)
                .status(HttpStatus.INTERNAL_SERVER_ERROR.name())
                .build();
    }
}
