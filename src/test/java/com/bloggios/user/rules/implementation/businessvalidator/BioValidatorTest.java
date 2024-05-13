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
 * Created_at - 18:05
 */

@ExtendWith(MockitoExtension.class)
class BioValidatorTest {

    @InjectMocks
    private BioValidator bioValidator;

    @Test
    void validate() {
        String bio = "Rohit Parihar\nSoftware Engineer";
        assertDoesNotThrow(()-> bioValidator.validate(bio));
    }

    @Test
    void validateExcessWords() {
        String longBio = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.";
        assertThrows(BadRequestException.class, ()-> bioValidator.validate(longBio));
        String bioWithExcessiveWords = "This is a bio with more than 25 words. This is a bio with more than 25 words. This is a bio with more than 25 words. This is a bio with more than 25 words.";
        assertThrows(BadRequestException.class, ()-> bioValidator.validate(bioWithExcessiveWords));
        String moreThan4Lines = "Line One\nLine Two\nLine Three\nLine Four";
        assertThrows(BadRequestException.class, ()-> bioValidator.validate(moreThan4Lines));
    }
}