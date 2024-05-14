package com.bloggios.user.transformer.implementation.transform;

import com.bloggios.user.entity.ProfileEntity;
import com.bloggios.user.exception.payload.BadRequestException;
import com.bloggios.user.payload.request.ProfileRequest;
import com.bloggios.user.utils.ProfileRequestUtil;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.core.env.Environment;

import java.util.prefs.BackingStoreException;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Owner - Rohit Parihar and Bloggios
 * Author - rohit
 * Project - user-service
 * Package - com.bloggios.user.transformer.implementation.transform
 * Created_on - May 14 - 2024
 * Created_at - 11:55
 */

@ExtendWith(MockitoExtension.class)
class ProfileRequestToEntityTransformerTest {

    @InjectMocks
    private ProfileRequestToEntityTransformer profileRequestToEntityTransformer;

    @Mock
    private Environment environment;

    @Test
    void transform() {
        ProfileRequest profileRequest = ProfileRequestUtil.getProfileRequest();
        ProfileEntity transform = profileRequestToEntityTransformer.transform(profileRequest);
        assertEquals(transform.getName(), profileRequest.getName());
    }

    @Test
    void transformThrows() {
        ProfileRequest profileRequest = ProfileRequestUtil.getProfileRequest();
        profileRequest.setProfileTag("invalid");
        assertThrows(
                BadRequestException.class,
                ()-> profileRequestToEntityTransformer.transform(profileRequest)
        );
    }
}