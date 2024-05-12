package com.bloggios.user.enums;

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
 * Package - com.bloggios.user.enums
 * Created_on - May 12 - 2024
 * Created_at - 22:09
 */

@ExtendWith(MockitoExtension.class)
class ProfileTagTest {

    @Test
    void getByValue() {
        ProfileTag other = ProfileTag.getByValue("other");
        assertEquals(ProfileTag.OTHER, other);
    }

    @Test
    void getByValueThrowException() {
        assertThrows(BadRequestException.class, ()-> ProfileTag.getByValue("invalid"));
    }
}