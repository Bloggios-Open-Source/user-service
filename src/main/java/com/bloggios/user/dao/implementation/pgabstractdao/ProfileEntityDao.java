package com.bloggios.user.dao.implementation.pgabstractdao;

import com.bloggios.user.dao.PgAbstractDao;
import com.bloggios.user.dao.repository.pgrepository.ProfileEntityRepository;
import com.bloggios.user.entity.ProfileEntity;
import org.springframework.stereotype.Component;

/**
 * Owner - Rohit Parihar and Bloggios
 * Author - rohit
 * Project - user-service
 * Package - com.bloggios.user.dao.implementation.pgabstractdao
 * Created_on - May 13 - 2024
 * Created_at - 17:33
 */

@Component
public class ProfileEntityDao extends PgAbstractDao<ProfileEntity, ProfileEntityRepository> {

    protected ProfileEntityDao(ProfileEntityRepository repository) {
        super(repository);
    }
}
