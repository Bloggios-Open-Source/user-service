package com.bloggios.user.implementation;

import com.bloggios.authenticationconfig.payload.AuthenticatedUser;
import com.bloggios.user.payload.request.ProfileRequest;
import com.bloggios.user.payload.response.ApplicationResponse;
import com.bloggios.user.service.ProfileService;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

/**
 * Owner - Rohit Parihar and Bloggios
 * Author - rohit
 * Project - user-service
 * Package - com.bloggios.user.implementation
 * Created_on - May 13 - 2024
 * Created_at - 16:52
 */

@Service
public class ProfileServiceImplementation implements ProfileService {

    @Override
    public CompletableFuture<ApplicationResponse> addProfile(
            ProfileRequest profileRequest,
            AuthenticatedUser authenticatedUser
    ) {
        return null;
    }
}
