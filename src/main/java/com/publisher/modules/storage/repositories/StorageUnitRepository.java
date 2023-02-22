package com.publisher.modules.storage.repositories;

import com.publisher.modules.storage.entities.StorageUnit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface StorageUnitRepository extends
        JpaRepository<StorageUnit, Integer>,
        JpaSpecificationExecutor<StorageUnit> {
}