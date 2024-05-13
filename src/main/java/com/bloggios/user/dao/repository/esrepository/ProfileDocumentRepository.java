package com.bloggios.user.dao.repository.esrepository;

import com.bloggios.user.document.ProfileDocument;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * Owner - Rohit Parihar and Bloggios
 * Author - rohit
 * Project - user-service
 * Package - com.bloggios.user.dao.repository.esrepository
 * Created_on - May 13 - 2024
 * Created_at - 17:31
 */

public interface ProfileDocumentRepository extends ElasticsearchRepository<ProfileDocument, String> {
}
