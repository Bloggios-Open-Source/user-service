package com.bloggios.user.ymlparser;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Properties;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Owner - Rohit Parihar and Bloggios
 * Author - rohit
 * Project - user-service
 * Package - com.bloggios.user.ymlparser
 * Created_on - May 13 - 2024
 * Created_at - 11:35
 */

@ExtendWith(MockitoExtension.class)
class ImportErrorMessagesTest {

    @InjectMocks
    private ImportErrorMessages importErrorMessages;

    @Test
    void testErrorMessages() throws Exception {
        Properties properties = importErrorMessages.errorMessages();
        assertNotNull(properties);
    }
}