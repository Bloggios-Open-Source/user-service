package com.bloggios.user.constants;

import lombok.experimental.UtilityClass;

/**
 * Owner - Rohit Parihar and Bloggios
 * Author - rohit
 * Project - user-service
 * Package - com.bloggios.user.constants
 * Created_on - May 13 - 2024
 * Created_at - 16:54
 */

@UtilityClass
public class EnvironmentConstants {

    public static final String PROFILE_GET_INDEX = "#{@environment.getProperty('elasticsearch.indices.profile')}";
    public static final String ES_SETTING = "/es-setting.json";
    public static final String ES_SERVER = "elasticsearch.server";
    public static final String ES_USERNAME = "elasticsearch.username";
    public static final String ES_PASSWORD = "elasticsearch.password";
    public static final String APPLICATION_VERSION = "application.version";
}
