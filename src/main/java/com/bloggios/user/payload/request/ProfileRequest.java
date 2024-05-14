package com.bloggios.user.payload.request;

import com.bloggios.authenticationconfig.payload.AuthenticatedUser;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import net.bytebuddy.asm.Advice;

/**
 * Owner - Rohit Parihar and Bloggios
 * Author - rohit
 * Project - user-service
 * Package - com.bloggios.user.payload.request
 * Created_on - May 13 - 2024
 * Created_at - 12:30
 */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class ProfileRequest {

    private String name;
    private String bio;
    private String link;
    private String profileTag;

    @JsonIgnore
    private AuthenticatedUser authenticatedUser;

}
