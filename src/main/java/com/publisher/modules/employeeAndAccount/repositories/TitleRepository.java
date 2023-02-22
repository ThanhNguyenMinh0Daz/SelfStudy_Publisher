package com.publisher.modules.employeeAndAccount.repositories;

import com.publisher.modules.employeeAndAccount.entities.Title;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface TitleRepository extends
        JpaRepository<Title, Integer>,
        JpaSpecificationExecutor<Title> {
}