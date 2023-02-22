package com.publisher.modules.report.repositories;

import com.publisher.modules.report.entities.Report;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface ReportRepository extends
        JpaRepository<Report, Integer>,
        JpaSpecificationExecutor<Report> {
}