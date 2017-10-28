package com.nordcrypto.portfoliomanager.repository;

import com.nordcrypto.portfoliomanager.models.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Andreas Heilig
 * Date: 17.10.2017
 */
public interface UserRepository extends JpaRepository<UserModel,Long> {
    UserModel findByUsername(String username);
}
