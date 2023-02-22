package com.publisher.modules.common.repositories;

import com.publisher.modules.common.entities.CommonLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface CommonLogRepository extends
        JpaRepository<CommonLog, Integer>,
        JpaSpecificationExecutor<CommonLog> {
}