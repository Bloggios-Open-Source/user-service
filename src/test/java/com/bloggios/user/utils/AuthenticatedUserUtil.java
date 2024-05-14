package com.bloggios.user.utils;

import com.bloggios.authenticationconfig.payload.AuthenticatedUser;
import lombok.experimental.UtilityClass;

/**
 * Owner - Rohit Parihar and Bloggios
 * Author - rohit
 * Project - user-service
 * Package - com.bloggios.user.utils
 * Created_on - May 14 - 2024
 * Created_at - 12:04
 */

@UtilityClass
public class AuthenticatedUserUtil {

    public static AuthenticatedUser getAuthenticatedUser() {
        AuthenticatedUser au = new AuthenticatedUser();
        au.setUserId("12345");
        au.setEmail("rohit@bloggios.com");
        au.setUsername("rohitparihar");
        return au;
    }
}
