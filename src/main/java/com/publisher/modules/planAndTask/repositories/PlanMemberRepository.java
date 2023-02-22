package com.publisher.modules.planAndTask.repositories;

import com.publisher.modules.planAndTask.entities.PlanMember;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public interface PlanMemberRepository extends
        JpaRepository<PlanMember, Integer>,
        JpaSpecificationExecutor<PlanMember> {

    /* Id */
    List<PlanMember> findAllByMemberIdIn(Collection<Integer> memberIdCollection);

    /* planId */
    List<PlanMember> findAllByPlanId(int planId);
    List<PlanMember> findAllByPlanIdIn(Collection<Integer> planIdCollection);

    /* employeeId */
    List<PlanMember> findAllByEmployeeId(int employeeId);
    List<PlanMember> findAllByEmployeeIdIn(Collection<Integer> employeeIdCollection);

    /* Check duplicate */
    @Query("select case when count(pM) > 0 then true else false end from PlanMember pM " +
            "where pM.planId = ?1 and pM.employeeId = ?2")
    boolean isDuplicateInsert(int planId, int employeeId);

    @Query("select case when count(pM) > 0 then true else false end from PlanMember pM " +
            "where pM.planId = ?1 and pM.employeeId = ?2 and pM.memberId <> ?3")
    boolean isDuplicateUpdate(int planId, int employeeId, int memberId);


}