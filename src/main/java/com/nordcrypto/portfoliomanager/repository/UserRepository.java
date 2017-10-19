package com.nordcrypto.portfoliomanager.repository;

import com.nordcrypto.portfoliomanager.model.UserModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;

/**
 * @author Andreas Heilig
 * Date: 17.10.2017
 */
@RepositoryRestResource(collectionResourceRel = "user", path = "user")
public interface UserRepository extends CrudRepository<UserModel,Long> {
    @RestResource(path = "name", rel = "name")
    List<UserModel> findAll();
}
