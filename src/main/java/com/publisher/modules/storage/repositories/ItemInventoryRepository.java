package com.publisher.modules.storage.repositories;

import com.publisher.modules.storage.entities.ItemInventory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemInventoryRepository extends
        JpaRepository<ItemInventory, Integer>,
        JpaSpecificationExecutor<ItemInventory> {
}