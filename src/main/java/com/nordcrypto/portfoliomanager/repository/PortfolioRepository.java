package com.nordcrypto.portfoliomanager.repository;

import com.nordcrypto.portfoliomanager.models.PortfolioModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * @author Andreas Heilig
 * Date: 19.10.2017
 */
@RepositoryRestResource(collectionResourceRel = "portfolio", path = "portfolio")
public interface PortfolioRepository extends CrudRepository<PortfolioModel, Long> {
}
