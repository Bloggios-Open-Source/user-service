package com.bloggios.user.entity;

import com.bloggios.user.constants.ServiceConstants;
import com.bloggios.user.enums.ProfileBadge;
import com.bloggios.user.enums.ProfileTag;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.vladmihalcea.hibernate.type.json.JsonBinaryType;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

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
@TypeDef(name = ServiceConstants.JSON_B, typeClass = JsonBinaryType.class)
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

    @Column(length = 1000)
    private String link;

    @Enumerated(EnumType.STRING)
    private ProfileTag profileTag;

    //User ID to be taken from auth token
    @Column(unique = true, nullable = false)
    private String userId;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createdOn;

    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedOn;

    //Version of the persistence for postgres and elasticsearch
    //Both databases must have same version
    @Column(nullable = false)
    private String version;

    //Version of the Application in which profile is created
    @Column(nullable = false)
    private String apiVersion;

    // Link of the profile Image
    @Column(length = 1000)
    private String profileImage;

    //Profile Badge like Blue Badge, Golden Badge, Bloggios Official Badge
    //Bloggios Official badge is for contributors only
    //Golden badge is for special persons
    //Blue badge can be requested by user on subscription or other requested basis
    //Golden Bloggios badge is for Owners and Admins
    @Type(type = ServiceConstants.JSON_B)
    @Column(columnDefinition = ServiceConstants.JSON_B)
    private List<ProfileBadge> profileBadge;
}
