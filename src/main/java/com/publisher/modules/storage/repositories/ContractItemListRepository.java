package com.publisher.modules.storage.repositories;

import com.publisher.modules.storage.entities.ContractItemList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface ContractItemListRepository extends
        JpaRepository<ContractItemList, Integer>,
        JpaSpecificationExecutor<ContractItemList> {
}