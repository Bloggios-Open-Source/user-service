package com.bloggios.user.rules.implementation.exhibitor;

import com.bloggios.user.payload.request.ProfileRequest;
import com.bloggios.user.rules.Exhibitor;
import com.bloggios.user.rules.implementation.businessvalidator.BioValidator;
import com.bloggios.user.rules.implementation.businessvalidator.LinkValidator;
import com.bloggios.user.rules.implementation.businessvalidator.NameValidator;
import com.bloggios.user.utils.AsyncUtils;
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
    private final BioValidator bioValidator;
    private final LinkValidator linkValidator;

    public ProfileRequestExhibitor(
            NameValidator nameValidator,
            BioValidator bioValidator,
            LinkValidator linkValidator
    ) {
        this.nameValidator = nameValidator;
        this.bioValidator = bioValidator;
        this.linkValidator = linkValidator;
    }

    @Override
    public void exhibit(ProfileRequest profileRequest) {
        CompletableFuture<Void> nameValidator = CompletableFuture.runAsync(() -> this.nameValidator.validate(profileRequest.getName()));
        CompletableFuture<Void> bioValidator = CompletableFuture.runAsync(() -> this.bioValidator.validate(profileRequest.getBio()));
        CompletableFuture<Void> linkValidator = CompletableFuture.runAsync(() -> this.linkValidator.validate(profileRequest.getLink()));
        AsyncUtils.getAsyncResult(CompletableFuture.allOf(
                nameValidator,
                bioValidator,
                linkValidator
        ));
    }
}
