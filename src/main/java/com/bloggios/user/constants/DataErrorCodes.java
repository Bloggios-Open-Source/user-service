package com.bloggios.user.constants;

import lombok.experimental.UtilityClass;

/**
 * Owner - Rohit Parihar and Bloggios
 * Author - rohit
 * Project - user-service
 * Package - com.bloggios.user.constants
 * Created_on - May 12 - 2024
 * Created_at - 22:06
 */

@UtilityClass
public class DataErrorCodes {

    public static final String INVALID_PROFILE_TAG_VALUE = "DE__USER-2001";
    public static final String NAME_MANDATORY = "DE__USER-2002";
    public static final String NAME_NOT_VALID = "DE__USER-2003";
    public static final String BIO_LENGTH_EXCEED = "DE__USER-2004";
    public static final String BIO_WORD_LIMIT_EXCEED = "DE__USER-2005";
    public static final String BIO_LINES_EXCEED = "DE__USER-2006";
    public static final String UNSECURED_PROTOCOL = "DE__USER-2007";
    public static final String LINK_PROTOCOL_NOT_PRESENT = "DE__USER-2008";
    public static final String PROFILE_ALREADY_ADDED = "DE__USER-2009";
}
