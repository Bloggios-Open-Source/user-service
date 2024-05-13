package com.bloggios.user.document;

import com.bloggios.user.enums.ProfileBadge;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

/**
 * Owner - Rohit Parihar and Bloggios
 * Author - rohit
 * Project - user-service
 * Package - com.bloggios.user.document
 * Created_on - May 13 - 2024
 * Created_at - 17:25
 */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class ProfileBadgeDocument {

    private ProfileBadge profileBadge;
    private String badgeDescription;
    private String approverDescription;
}
