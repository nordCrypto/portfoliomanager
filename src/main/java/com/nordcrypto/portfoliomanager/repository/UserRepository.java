package com.nordcrypto.portfoliomanager.repository;

import com.nordcrypto.portfoliomanager.model.UserModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * @author Andreas Heilig
 * Date: 17.10.2017
 */
@RepositoryRestResource(collectionResourceRel = "user", path = "users")
public interface UserRepository extends CrudRepository<UserModel,Long> {

}
