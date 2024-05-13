package com.bloggios.user.dao.implementation.esabstractdao;

import com.bloggios.user.dao.EsAbstractDao;
import com.bloggios.user.dao.repository.esrepository.ProfileDocumentRepository;
import com.bloggios.user.document.ProfileDocument;
import org.springframework.stereotype.Component;

/**
 * Owner - Rohit Parihar and Bloggios
 * Author - rohit
 * Project - user-service
 * Package - com.bloggios.user.dao.implementation.esabstractdao
 * Created_on - May 13 - 2024
 * Created_at - 17:35
 */

@Component
public class ProfileDocumentDao extends EsAbstractDao<ProfileDocument, ProfileDocumentRepository> {

    protected ProfileDocumentDao(ProfileDocumentRepository repository) {
        super(repository);
    }
}
