package com.nordcrypto.portfoliomanager.repository;

import com.nordcrypto.portfoliomanager.models.PortfolioModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * @author Andreas Heilig
 * Date: 19.10.2017
 */
public interface PortfolioRepository extends JpaRepository<PortfolioModel, Long> {
}
