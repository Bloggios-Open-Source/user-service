package com.bloggios.user.utils;

import com.bloggios.user.payload.request.ProfileRequest;
import lombok.experimental.UtilityClass;

/**
 * Owner - Rohit Parihar and Bloggios
 * Author - rohit
 * Project - user-service
 * Package - com.bloggios.user.utils
 * Created_on - May 14 - 2024
 * Created_at - 11:56
 */

@UtilityClass
public class ProfileRequestUtil {

    public static ProfileRequest getProfileRequest() {
        return ProfileRequest
                .builder()
                .name("Rohit Parihar")
                .bio("Software Engineer\nSDE-2")
                .link("https://www.bloggios.com")
                .profileTag("Other")
                .authenticatedUser(AuthenticatedUserUtil.getAuthenticatedUser())
                .build();
    }
}
