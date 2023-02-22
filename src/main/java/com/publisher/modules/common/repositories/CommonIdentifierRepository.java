package com.publisher.modules.common.repositories;

import com.publisher.modules.common.entities.CommonIdentifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface CommonIdentifierRepository extends
        JpaRepository<CommonIdentifier, Integer>,
        JpaSpecificationExecutor<CommonIdentifier> {
}