package com.bloggios.user.transformer.implementation.transform;

import com.bloggios.user.constants.EnvironmentConstants;
import com.bloggios.user.constants.ServiceConstants;
import com.bloggios.user.entity.ProfileEntity;
import com.bloggios.user.enums.ProfileBadge;
import com.bloggios.user.enums.ProfileTag;
import com.bloggios.user.payload.request.ProfileRequest;
import com.bloggios.user.transformer.Transform;
import org.hibernate.annotations.Type;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * Owner - Rohit Parihar and Bloggios
 * Author - rohit
 * Project - user-service
 * Package - com.bloggios.user.transformer.implementation.transform
 * Created_on - May 14 - 2024
 * Created_at - 11:25
 */

@Component
public class ProfileRequestToEntityTransformer implements Transform<ProfileEntity, ProfileRequest> {

    private final Environment environment;

    public ProfileRequestToEntityTransformer(
            Environment environment
    ) {
        this.environment = environment;
    }

    @Override
    public ProfileEntity transform(ProfileRequest profileRequest) {
        return ProfileEntity
                .builder()
                .name(profileRequest.getName())
                .email(profileRequest.getAuthenticatedUser().getEmail())
                .username(profileRequest.getAuthenticatedUser().getUsername())
                .bio(profileRequest.getBio())
                .profileTag(StringUtils.hasText(profileRequest.getProfileTag()) ? ProfileTag.getByValue(profileRequest.getProfileTag()) : null)
                .userId(profileRequest.getAuthenticatedUser().getUserId())
                .createdOn(new Date())
                .version(UUID.randomUUID().toString())
                .apiVersion(environment.getProperty(EnvironmentConstants.APPLICATION_VERSION))
                .build();
    }
}
