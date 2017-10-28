package com.nordcrypto.portfoliomanager.repository;

import com.nordcrypto.portfoliomanager.models.PortfolioModel;
import com.nordcrypto.portfoliomanager.models.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

/**
 * @author Andreas Heilig
 * Date: 19.10.2017
 */
public interface PortfolioRepository extends JpaRepository<PortfolioModel, Long> {
    List<PortfolioModel> findAllByUserModel(UserModel userModel);
}
