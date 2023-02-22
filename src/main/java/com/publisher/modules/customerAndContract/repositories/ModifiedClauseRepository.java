package com.publisher.modules.customerAndContract.repositories;

import com.publisher.modules.customerAndContract.entities.ModifiedClause;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface ModifiedClauseRepository extends
        JpaRepository<ModifiedClause, Integer>,
        JpaSpecificationExecutor<ModifiedClause> {
}