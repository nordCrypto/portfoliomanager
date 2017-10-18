package com.nordcrypto.portfoliomanager.repositories;

import com.nordcrypto.portfoliomanager.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Andreas Heilig
 * Date: 17.10.2017
 */
public interface UserRepository extends JpaRepository<User,Long> {
}
