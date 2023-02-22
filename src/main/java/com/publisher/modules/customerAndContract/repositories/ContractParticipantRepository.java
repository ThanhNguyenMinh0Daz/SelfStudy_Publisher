package com.publisher.modules.customerAndContract.repositories;

import com.publisher.modules.customerAndContract.entities.ContractParticipant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface ContractParticipantRepository extends
        JpaRepository<ContractParticipant, Integer>,
        JpaSpecificationExecutor<ContractParticipant> {
}