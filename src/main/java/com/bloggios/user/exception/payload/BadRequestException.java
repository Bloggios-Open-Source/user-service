package com.bloggios.user.exception.payload;

import com.bloggios.user.exception.ExceptionProvider;
import lombok.EqualsAndHashCode;
import lombok.Getter;

/**
 * Owner - Rohit Parihar and Bloggios
 * Author - rohit
 * Project - user-service
 * Package - com.bloggios.user.exception.payload
 * Created_on - May 12 - 2024
 * Created_at - 22:03
 */

@Getter
@EqualsAndHashCode(callSuper = true)
public class BadRequestException extends ExceptionProvider {

    private String message;

    public BadRequestException(String code) {
        super(code);
    }

    public BadRequestException(String code, String message) {
        super(code);
        this.message = message;
    }
}
