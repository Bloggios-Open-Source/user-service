package com.bloggios.user.rules.implementation.businessvalidator;

import com.bloggios.user.exception.payload.BadRequestException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.commons.util.StringUtils;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Owner - Rohit Parihar and Bloggios
 * Author - rohit
 * Project - user-service
 * Package - com.bloggios.user.rules.implementation.businessvalidator
 * Created_on - May 13 - 2024
 * Created_at - 21:36
 */

@ExtendWith(MockitoExtension.class)
class LinkValidatorTest {

    @InjectMocks
    private LinkValidator linkValidator;

    @Test
    void validate() {
        assertDoesNotThrow(()-> linkValidator.validate("https://bloggios.com"));
        assertDoesNotThrow(()-> linkValidator.validate(null));
    }

    @Test
    void validateThrows() {
        assertThrows(
                BadRequestException.class,
                ()-> linkValidator.validate("http://www.bloggios.com")
        );
        assertThrows(
                BadRequestException.class,
                ()-> linkValidator.validate("www.bloggios.com")
        );
    }
}