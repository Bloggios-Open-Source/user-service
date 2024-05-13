package com.bloggios.user.dao.repository.pgrepository;

import com.bloggios.user.entity.ProfileEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Owner - Rohit Parihar and Bloggios
 * Author - rohit
 * Project - user-service
 * Package - com.bloggios.user.dao.repository.pgrepository
 * Created_on - May 13 - 2024
 * Created_at - 17:32
 */

public interface ProfileEntityRepository extends JpaRepository<ProfileEntity, String> {
}
