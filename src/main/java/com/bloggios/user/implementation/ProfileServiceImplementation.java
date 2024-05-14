package com.bloggios.user.implementation;

import com.bloggios.authenticationconfig.payload.AuthenticatedUser;
import com.bloggios.user.constants.DataErrorCodes;
import com.bloggios.user.constants.ResponseMessageConstants;
import com.bloggios.user.dao.implementation.pgabstractdao.ProfileEntityDao;
import com.bloggios.user.entity.ProfileEntity;
import com.bloggios.user.enums.DaoStatus;
import com.bloggios.user.exception.payload.BadRequestException;
import com.bloggios.user.payload.request.ProfileRequest;
import com.bloggios.user.payload.response.ApplicationResponse;
import com.bloggios.user.persistance.ProfileEntityToDocumentPersistence;
import com.bloggios.user.rules.implementation.exhibitor.ProfileRequestExhibitor;
import com.bloggios.user.service.ProfileService;
import com.bloggios.user.transformer.implementation.transform.ProfileRequestToEntityTransformer;
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
    private final ProfileRequestToEntityTransformer profileRequestToEntityTransformer;
    private final ProfileEntityToDocumentPersistence profileEntityToDocumentPersistence;

    public ProfileServiceImplementation(
            ProfileRequestExhibitor profileRequestExhibitor,
            ProfileEntityDao profileEntityDao,
            ProfileRequestToEntityTransformer profileRequestToEntityTransformer,
            ProfileEntityToDocumentPersistence profileEntityToDocumentPersistence) {
        this.profileRequestExhibitor = profileRequestExhibitor;
        this.profileEntityDao = profileEntityDao;
        this.profileRequestToEntityTransformer = profileRequestToEntityTransformer;
        this.profileEntityToDocumentPersistence = profileEntityToDocumentPersistence;
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
        profileRequest.setAuthenticatedUser(authenticatedUser);
        ProfileEntity profileEntity = profileRequestToEntityTransformer.transform(profileRequest);
        ProfileEntity profileEntityResponse = profileEntityDao.initOperation(DaoStatus.CREATE, profileEntity);
        CompletableFuture.runAsync(()-> profileEntityToDocumentPersistence.persist(profileEntityResponse, DaoStatus.CREATE));
        return CompletableFuture.completedFuture(
                ApplicationResponse
                        .builder()
                        .message(ResponseMessageConstants.PROFILE_CREATED)
                        .userId(authenticatedUser.getUserId())
                        .id(profileEntityResponse.getProfileId())
                        .build()
        );
    }
}
