package com.publisher.modules.customerAndContract.repositories;

import com.publisher.modules.customerAndContract.entities.Individual;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface IndividualRepository extends
        JpaRepository<Individual, Integer>,
        JpaSpecificationExecutor<Individual> {
}