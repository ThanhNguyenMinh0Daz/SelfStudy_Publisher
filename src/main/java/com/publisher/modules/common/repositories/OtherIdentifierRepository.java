package com.publisher.modules.common.repositories;

import com.publisher.modules.common.entities.OtherIdentifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface OtherIdentifierRepository extends
        JpaRepository<OtherIdentifier, Integer>,
        JpaSpecificationExecutor<OtherIdentifier> {
}