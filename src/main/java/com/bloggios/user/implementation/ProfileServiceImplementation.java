package com.bloggios.user.implementation;

import com.bloggios.authenticationconfig.payload.AuthenticatedUser;
import com.bloggios.user.constants.DataErrorCodes;
import com.bloggios.user.dao.implementation.pgabstractdao.ProfileEntityDao;
import com.bloggios.user.entity.ProfileEntity;
import com.bloggios.user.exception.payload.BadRequestException;
import com.bloggios.user.payload.request.ProfileRequest;
import com.bloggios.user.payload.response.ApplicationResponse;
import com.bloggios.user.rules.implementation.exhibitor.ProfileRequestExhibitor;
import com.bloggios.user.service.ProfileService;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.concurrent.CompletableFuture;

/**
 * Owner - Rohit Parihar and Bloggios
 * Author - rohit
 * Project - user-service
 * Package - com.bloggios.user.implementation
 * Created_on - May 13 - 2024
 * Created_at - 16:52
 */

@Service
public class ProfileServiceImplementation implements ProfileService {

    private final ProfileRequestExhibitor profileRequestExhibitor;
    private final ProfileEntityDao profileEntityDao;

    public ProfileServiceImplementation(
            ProfileRequestExhibitor profileRequestExhibitor,
            ProfileEntityDao profileEntityDao
    ) {
        this.profileRequestExhibitor = profileRequestExhibitor;
        this.profileEntityDao = profileEntityDao;
    }

    @Override
    public CompletableFuture<ApplicationResponse> addProfile(
            ProfileRequest profileRequest,
            AuthenticatedUser authenticatedUser
    ) {
        profileRequestExhibitor.exhibit(profileRequest);
        Optional<ProfileEntity> optionalProfileEntity = profileEntityDao.findByUserId(authenticatedUser.getUserId());
        if (optionalProfileEntity.isPresent())
            throw new BadRequestException(DataErrorCodes.PROFILE_ALREADY_ADDED);

        return null;
    }
}
