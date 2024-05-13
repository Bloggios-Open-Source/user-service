package com.bloggios.user.service;

import com.bloggios.user.payload.request.ProfileRequest;
import com.bloggios.user.payload.response.ApplicationResponse;

import java.util.concurrent.CompletableFuture;

/**
 * Owner - Rohit Parihar and Bloggios
 * Author - rohit
 * Project - user-service
 * Package - com.bloggios.user.service
 * Created_on - May 13 - 2024
 * Created_at - 12:30
 */

public interface ProfileService {

    CompletableFuture<ApplicationResponse> addProfile(
            ProfileRequest profileRequest
    );
}
