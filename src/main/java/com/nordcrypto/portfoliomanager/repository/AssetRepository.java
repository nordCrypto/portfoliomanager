package com.nordcrypto.portfoliomanager.repository;

import com.nordcrypto.portfoliomanager.models.AssetModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AssetRepository extends JpaRepository<AssetModel, Long> {
}
