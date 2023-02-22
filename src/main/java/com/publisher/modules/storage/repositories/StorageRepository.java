package com.publisher.modules.storage.repositories;

import com.publisher.modules.storage.entities.Storage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface StorageRepository extends
        JpaRepository<Storage, Integer>,
        JpaSpecificationExecutor<Storage> {
}