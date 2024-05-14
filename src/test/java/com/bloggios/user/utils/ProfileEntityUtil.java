package com.bloggios.user.utils;

import com.bloggios.user.dao.implementation.pgabstractdao.ProfileEntityDao;
import com.bloggios.user.entity.ProfileEntity;
import com.bloggios.user.enums.ProfileTag;
import lombok.experimental.UtilityClass;

import java.util.Date;

/**
 * Owner - Rohit Parihar and Bloggios
 * Author - rohit
 * Project - user-service
 * Package - com.bloggios.user.utils
 * Created_on - May 14 - 2024
 * Created_at - 15:13
 */

@UtilityClass
public class ProfileEntityUtil {

    public static ProfileEntity getProfileEntity() {
        return ProfileEntity
                .builder()
                .profileId("1234")
                .name("Rohit Parihar")
                .name("Rohit Parihar")
                .bio("Software Engineer\nSDE-2")
                .link("https://www.bloggios.com")
                .profileTag(ProfileTag.OTHER)
                .version("1")
                .createdOn(new Date())
                .build();
    }
}
