package com.bloggios.user.persistance;

import com.bloggios.user.dao.implementation.esabstractdao.ProfileDocumentDao;
import com.bloggios.user.document.ProfileDocument;
import com.bloggios.user.entity.ProfileEntity;
import com.bloggios.user.enums.DaoStatus;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * Owner - Rohit Parihar and Bloggios
 * Author - rohit
 * Project - user-service
 * Package - com.bloggios.user.persistance
 * Created_on - May 14 - 2024
 * Created_at - 12:49
 */

@Component
public class ProfileEntityToDocumentPersistence {

    private final ModelMapper modelMapper;
    private final ProfileDocumentDao profileDocumentDao;

    public ProfileEntityToDocumentPersistence(
            ModelMapper modelMapper,
            ProfileDocumentDao profileDocumentDao
    ) {
        this.modelMapper = modelMapper;
        this.profileDocumentDao = profileDocumentDao;
    }

    public void persist(ProfileEntity profileEntity, DaoStatus daoStatus) {
        ProfileDocument profileDocument = modelMapper.map(profileEntity, ProfileDocument.class);
        profileDocumentDao.initOperation(daoStatus, profileDocument);
    }
}
