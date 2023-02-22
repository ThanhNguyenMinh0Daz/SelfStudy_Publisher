package com.publisher.modules.planAndTask.repositories;

import com.publisher.modules.planAndTask.entities.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Repository
public interface TaskRepository extends
        JpaRepository<Task, Integer>,
        JpaSpecificationExecutor<Task> {

    /* Id */
    @Query("select t from Task t where t.taskId = ?1")
    Optional<Task> findByIdLazy(int taskId);
    List<Task> findAllByTaskIdIn(Collection<Integer> taskIdCollection);

    /* planId */
    List<Task> findAllByPlanId(int planId);
    List<Task> findAllByPlanIdIn(Collection<Integer> planIdCollection);

    /* Check duplicate */
    @Query("select case when count(t) > 0 then true else false end from Task t " +
            "where (t.taskCode = ?1) or (t.taskName = ?2 and t.planId = ?3)")
    boolean isDuplicateInsert(String taskCode, String taskName, int planId);

    @Query("select case when count(t) > 0 then true else false end from Task t " +
            "where ((t.taskCode = ?1) or (t.taskName = ?2 and t.planId = ?3)) and (t.taskId <> ?4)")
    boolean isDuplicateUpdate(String taskCode, String taskName, int planId, int taskId);

}