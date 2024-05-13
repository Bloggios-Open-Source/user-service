package com.bloggios.user.rules.implementation.exhibitor;

import com.bloggios.user.constants.DataErrorCodes;
import com.bloggios.user.exception.payload.BadRequestException;
import com.bloggios.user.payload.request.ProfileRequest;
import com.bloggios.user.rules.implementation.businessvalidator.BioValidator;
import com.bloggios.user.rules.implementation.businessvalidator.LinkValidator;
import com.bloggios.user.rules.implementation.businessvalidator.NameValidator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doThrow;

/**
 * Owner - Rohit Parihar and Bloggios
 * Author - rohit
 * Project - user-service
 * Package - com.bloggios.user.rules.implementation.exhibitor
 * Created_on - May 13 - 2024
 * Created_at - 22:08
 */

@ExtendWith(MockitoExtension.class)
class ProfileRequestExhibitorTest {

    @InjectMocks
    private ProfileRequestExhibitor exhibitor;

    @Mock
    private NameValidator nameValidator;

    @Mock
    private BioValidator bioValidator;

    @Mock
    private LinkValidator linkValidator;


    @Test
    void exhibit() {
        ProfileRequest profileRequest = ProfileRequest
                .builder()
                .name("Rohit Parihar")
                .bio("Software Engineer")
                .link("https://bloggios.com")
                .build();
        assertDoesNotThrow(()-> exhibitor.exhibit(profileRequest));
        Mockito.verify(nameValidator).validate("Rohit Parihar");
        Mockito.verify(bioValidator).validate("Software Engineer");
        Mockito.verify(linkValidator).validate("https://bloggios.com");
    }

    @Test
    void exhibitThrow() {
        ProfileRequest profileRequest = ProfileRequest
                .builder()
                .name(null)
                .bio("Software Engineer")
                .link("https://bloggios.com")
                .build();
        doThrow(new BadRequestException(DataErrorCodes.NAME_MANDATORY))
                .when(nameValidator).validate(null);
        assertThrows(BadRequestException.class, ()-> exhibitor.exhibit(profileRequest));
    }
}