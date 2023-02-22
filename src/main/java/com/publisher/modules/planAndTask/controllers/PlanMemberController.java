package com.publisher.modules.planAndTask.controllers;

import com.publisher.modules.planAndTask.dtos.planMember.PlanMemberCreateDTO;
import com.publisher.modules.planAndTask.dtos.planMember.PlanMemberReadDTO;
import com.publisher.modules.planAndTask.dtos.planMember.PlanMemberUpdateDTO;
import com.publisher.modules.planAndTask.services.planMember.PlanMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping(path = "/planMember")
public class PlanMemberController {
    @Autowired
    private PlanMemberService planMemberService;

    /* ================================================= VERSION 1 ================================================= */
    /* CREATE */
    @PostMapping(path = "/v1/create")
    public ResponseEntity<Object> createPlanMember(
            @RequestBody PlanMemberCreateDTO createDTO) {
        try {
            PlanMemberReadDTO readDTO = planMemberService.createPlanMemberByDTO(createDTO);

            return ResponseEntity.ok().body(readDTO);
        } catch (Exception e) {
            e.printStackTrace();

            return ResponseEntity.internalServerError().body(e);
        }
    }

    /* READ */
    @GetMapping(path = "/v1/get/id")
    public ResponseEntity<Object> getPlanMemberById(
            @RequestParam(required = true) int planMemberId) {
        try {
            PlanMemberReadDTO readDTO = planMemberService.getDTOById(planMemberId);

            return ResponseEntity.ok().body(readDTO);
        } catch (Exception e) {
            e.printStackTrace();

            return ResponseEntity.internalServerError().body(e);
        }
    }

    @GetMapping(path = "/v1/getAll/id")
    public ResponseEntity<Object> getAllPlanMemberByIdIn(
            @RequestParam(name = "planMemberIds", required = true) Collection<Integer> planMemberIdCollection) {
        try {
            List<PlanMemberReadDTO> readDTOList = planMemberService.getAllDTOByIdIn(planMemberIdCollection);

            return ResponseEntity.ok().body(readDTOList);
        } catch (Exception e) {
            e.printStackTrace();

            return ResponseEntity.internalServerError().body(e);
        }
    }
    
    /* UPDATE */
    @PutMapping(path = "/v1/update")
    public ResponseEntity<Object> updatePlanMember(
            @RequestBody PlanMemberUpdateDTO updateDTO) {
        try {
            PlanMemberReadDTO readDTO = planMemberService.updatePlanMemberByDTO(updateDTO);

            return ResponseEntity.ok().body(readDTO);
        } catch (Exception e) {
            e.printStackTrace();

            return ResponseEntity.internalServerError().body(e);
        }
    }


    /* DELETE */

    /* ================================================= VERSION 1 ================================================= */

}
