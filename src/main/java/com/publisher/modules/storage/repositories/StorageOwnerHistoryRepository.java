package com.publisher.modules.storage.repositories;

import com.publisher.modules.storage.entities.StorageOwnerHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface StorageOwnerHistoryRepository extends
        JpaRepository<StorageOwnerHistory, Integer>,
        JpaSpecificationExecutor<StorageOwnerHistory> {
}