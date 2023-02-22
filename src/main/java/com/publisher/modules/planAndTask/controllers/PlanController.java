package com.publisher.modules.planAndTask.controllers;

import com.publisher.modules.planAndTask.dtos.plan.PlanCreateDTO;
import com.publisher.modules.planAndTask.dtos.plan.PlanReadDTO;
import com.publisher.modules.planAndTask.dtos.plan.PlanUpdateDTO;
import com.publisher.modules.planAndTask.services.plan.PlanService;
import com.publisher.utils.enums.LogReason;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping(path = "/plan")
public class PlanController {
    @Autowired
    private PlanService planService;

    /* ================================================= VERSION 1 ================================================= */
    /* CREATE */
    @PostMapping(path = "/v1/create")
    public ResponseEntity<Object> createPlan(
            @RequestBody PlanCreateDTO createDTO) {
        try {
            PlanReadDTO readDTO = planService.createPlanByDTO(createDTO);

            return ResponseEntity.ok().body(readDTO);
        } catch (Exception e) {
            e.printStackTrace();

            return ResponseEntity.internalServerError().body(e);
        }
    }

    /* READ */
    @GetMapping(path = "/v1/get/id")
    public ResponseEntity<Object> getPlanById(
            @RequestParam(required = true) int planId) {
        try {
            PlanReadDTO readDTO = planService.getDTOById(planId);

            return ResponseEntity.ok().body(readDTO);
        } catch (Exception e) {
            e.printStackTrace();

            return ResponseEntity.internalServerError().body(e);
        }
    }

    @GetMapping(path = "/v1/getAll/id")
    public ResponseEntity<Object> getAllPlanByIdIn(
            @RequestParam(name = "planIds", required = true) Collection<Integer> planIdCollection) {
        try {
            List<PlanReadDTO> readDTOList = planService.getAllDTOByIdIn(planIdCollection);

            return ResponseEntity.ok().body(readDTOList);
        } catch (Exception e) {
            e.printStackTrace();

            return ResponseEntity.internalServerError().body(e);
        }
    }
    
    /* UPDATE */
    @PutMapping(path = "/v1/update")
    public ResponseEntity<Object> updatePlan(
            @RequestBody PlanUpdateDTO updateDTO) {
        try {
            PlanReadDTO readDTO = planService.updatePlanByDTO(updateDTO, LogReason.UPDATE, null);

            return ResponseEntity.ok().body(readDTO);
        } catch (Exception e) {
            e.printStackTrace();

            return ResponseEntity.internalServerError().body(e);
        }
    }


    /* DELETE */

    /* ================================================= VERSION 1 ================================================= */

}
