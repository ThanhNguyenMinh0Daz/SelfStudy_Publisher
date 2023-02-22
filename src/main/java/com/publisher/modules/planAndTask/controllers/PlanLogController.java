package com.publisher.modules.planAndTask.controllers;

import com.publisher.modules.planAndTask.dtos.planLog.PlanLogCreateDTO;
import com.publisher.modules.planAndTask.dtos.planLog.PlanLogReadDTO;
import com.publisher.modules.planAndTask.dtos.planLog.PlanLogUpdateDTO;
import com.publisher.modules.planAndTask.services.planLog.PlanLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping(path = "/planLog")
public class PlanLogController {
    @Autowired
    private PlanLogService planLogService;

/* ==================================================== VERSION 1 ==================================================== */
/* CREATE */
    @PostMapping(path = "/v1/create")
    public ResponseEntity<Object> createPlanLog(
            @RequestBody PlanLogCreateDTO createDTO) {
        try {
            PlanLogReadDTO readDTO = planLogService.createPlanLogByDTO(createDTO);

            return ResponseEntity.ok().body(readDTO);
        } catch (Exception e) {
            e.printStackTrace();

            return ResponseEntity.internalServerError().body(e);
        }
    }

/* READ */
@GetMapping(path = "/v1/get/id")
public ResponseEntity<Object> getPlanLogById(
        @RequestParam(required = true) int planLogId) {
    try {
        PlanLogReadDTO readDTO = planLogService.getDTOById(planLogId);

        return ResponseEntity.ok().body(readDTO);
    } catch (Exception e) {
        e.printStackTrace();

        return ResponseEntity.internalServerError().body(e);
    }
}
    @GetMapping(path = "/v1/getAll/id")
    public ResponseEntity<Object> getAllPlanLogByIdIn(
            @RequestParam(name = "planLogIds", required = true) Collection<Integer> planLogIdCollection) {
        try {
            List<PlanLogReadDTO> readDTOList = planLogService.getAllDTOByIdIn(planLogIdCollection);

            return ResponseEntity.ok().body(readDTOList);
        } catch (Exception e) {
            e.printStackTrace();

            return ResponseEntity.internalServerError().body(e);
        }
    }

    /* planId */
    @GetMapping(path = "/v1/getAll/planId")
    public ResponseEntity<Object> getAllPlanLogByPlanId(
            @RequestParam(required = true) int planId) {
        try {
            List<PlanLogReadDTO> readDTOList = planLogService.getAllDTOByPlanId(planId);

            return ResponseEntity.ok().body(readDTOList);
        } catch (Exception e) {
            e.printStackTrace();

            return ResponseEntity.internalServerError().body(e);
        }
    }
    
/* UPDATE */
    @PutMapping(path = "/v1/update")
    public ResponseEntity<Object> updatePlanLog(
            @RequestBody PlanLogUpdateDTO updateDTO) {
        try {
            PlanLogReadDTO readDTO = planLogService.updatePlanLogByDTO(updateDTO);

            return ResponseEntity.ok().body(readDTO);
        } catch (Exception e) {
            e.printStackTrace();

            return ResponseEntity.internalServerError().body(e);
        }
    }


/* DELETE */

/* ==================================================== VERSION 1 ==================================================== */

}
