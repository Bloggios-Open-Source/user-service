package com.bloggios.user.rules.implementation.businessvalidator;

import com.bloggios.user.exception.payload.BadRequestException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Owner - Rohit Parihar and Bloggios
 * Author - rohit
 * Project - user-service
 * Package - com.bloggios.user.rules.implementation.businessvalidator
 * Created_on - May 13 - 2024
 * Created_at - 17:44
 */

@ExtendWith(MockitoExtension.class)
class NameValidatorTest {

    @InjectMocks
    private NameValidator nameValidator;

    @Test
    void validate() {
        String validaName = "Rohit Parihar";
        assertDoesNotThrow(()-> nameValidator.validate(validaName));
    }

    @Test
    void nullName() {
        assertThrows(
                BadRequestException.class,
                ()-> nameValidator.validate(null)
        );
    }

    @Test
    void invalidName() {
        assertThrows(
                BadRequestException.class,
                ()-> nameValidator.validate("Rohit7 Parihar")
        );
    }
}