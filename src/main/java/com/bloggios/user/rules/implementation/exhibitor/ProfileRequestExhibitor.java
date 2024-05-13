package com.bloggios.user.rules.implementation.exhibitor;

import com.bloggios.user.payload.request.ProfileRequest;
import com.bloggios.user.rules.Exhibitor;
import com.bloggios.user.rules.implementation.businessvalidator.NameValidator;
import org.springframework.stereotype.Component;

import java.util.concurrent.CompletableFuture;

/**
 * Owner - Rohit Parihar and Bloggios
 * Author - rohit
 * Project - user-service
 * Package - com.bloggios.user.rules.implementation.exhibitor
 * Created_on - May 13 - 2024
 * Created_at - 17:38
 */

@Component
public class ProfileRequestExhibitor implements Exhibitor<ProfileRequest> {

    private final NameValidator nameValidator;

    public ProfileRequestExhibitor(
            NameValidator nameValidator
    ) {
        this.nameValidator = nameValidator;
    }

    @Override
    public void exhibit(ProfileRequest profileRequest) {
        CompletableFuture.runAsync(()-> nameValidator.validate(profileRequest.getName()));

    }
}
