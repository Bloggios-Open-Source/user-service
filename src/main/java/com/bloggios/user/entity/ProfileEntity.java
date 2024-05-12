package com.bloggios.user.entity;

import com.bloggios.user.constants.ServiceConstants;
import com.bloggios.user.enums.ProfileTag;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * Owner - Rohit Parihar and Bloggios
 * Author - rohit
 * Project - user-service
 * Package - com.bloggios.user.entity
 * Created_on - May 12 - 2024
 * Created_at - 21:54
 */

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
@Table(name = "profile")
public class ProfileEntity {

    @Id
    @GeneratedValue(generator = ServiceConstants.RANDOM_UUID)
    @GenericGenerator(name = ServiceConstants.RANDOM_UUID, strategy = "org.hibernate.id.UUIDGenerator")
    private String profileId;

    private String name;

    //Email and username to be get from auth-server

    @Column(unique = true, nullable = false)
    private String email;

    @Column(unique = true, nullable = false)
    private String username;

    @Column(length = 5000)
    private String bio;

    private ProfileTag profileTag;
}
