package com.bloggios.user.enums;

import com.bloggios.user.constants.DataErrorCodes;
import com.bloggios.user.exception.payload.BadRequestException;

/**
 * Owner - Rohit Parihar and Bloggios
 * Author - rohit
 * Project - user-service
 * Package - com.bloggios.user.enums
 * Created_on - May 12 - 2024
 * Created_at - 21:59
 */

public enum ProfileTag {

    OTHER("Other"),
    SOFTWARE("Software Developer"),
    FREELANCER("Freelancer"),
    INFLUENCER("Influencer"),
    ARTIST("Artist"),
    ACTOR("Actor"),
    BLOG("Personal Blog"),
    COMMUNITY("Community"),
    EDUCATION("Education"),
    STUDENT("Student"),
    ENTREPRENEUR("Entrepreneur"),
    GAMER("Gamer"),
    PHOTOGRAPHER("Photographer"),
    MUSICIAN("Musician"),
    COMPANY("Company");

    private final String value;

    ProfileTag(String value) {
        this.value = value;
    }

    public static ProfileTag getByValue(String value) {
        for (ProfileTag profileTag : values()) {
            if (profileTag.value.equalsIgnoreCase(value)) {
                return profileTag;
            }
        }
        throw new BadRequestException(DataErrorCodes.INVALID_PROFILE_TAG_VALUE);
    }
}
