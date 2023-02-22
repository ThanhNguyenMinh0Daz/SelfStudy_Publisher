package com.publisher.modules.report.repositories;

import com.publisher.modules.report.entities.ReportItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface ReportItemRepository extends
        JpaRepository<ReportItem, Integer>,
        JpaSpecificationExecutor<ReportItem> {
}