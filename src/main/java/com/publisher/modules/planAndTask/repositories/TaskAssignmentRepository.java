package com.publisher.modules.planAndTask.repositories;

import com.publisher.modules.planAndTask.entities.TaskAssignment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskAssignmentRepository extends
        JpaRepository<TaskAssignment, Integer>,
        JpaSpecificationExecutor<TaskAssignment> {
}