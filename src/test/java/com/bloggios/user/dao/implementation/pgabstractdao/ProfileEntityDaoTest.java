package com.bloggios.user.dao.implementation.pgabstractdao;

import com.bloggios.user.dao.repository.pgrepository.ProfileEntityRepository;
import com.bloggios.user.entity.ProfileEntity;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;

/**
 * Owner - Rohit Parihar and Bloggios
 * Author - rohit
 * Project - user-service
 * Package - com.bloggios.user.dao.implementation.pgabstractdao
 * Created_on - May 14 - 2024
 * Created_at - 11:20
 */

@ExtendWith(MockitoExtension.class)
class ProfileEntityDaoTest {

    @InjectMocks
    private ProfileEntityDao profileEntityDao;

    @Mock
    private ProfileEntityRepository profileEntityRepository;

    @Test
    void findByUserId() {
        Mockito.when(profileEntityRepository.findByUserId(anyString()))
                .thenReturn(Optional.of(new ProfileEntity()));
        Optional<ProfileEntity> optional = profileEntityDao.findByUserId("1");
        assertInstanceOf(Optional.class, optional);
    }
}