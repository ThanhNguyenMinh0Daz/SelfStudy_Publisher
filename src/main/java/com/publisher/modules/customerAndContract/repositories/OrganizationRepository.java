package com.publisher.modules.customerAndContract.repositories;

import com.publisher.modules.customerAndContract.entities.Organization;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface OrganizationRepository extends
        JpaRepository<Organization, Integer>,
        JpaSpecificationExecutor<Organization> {
}