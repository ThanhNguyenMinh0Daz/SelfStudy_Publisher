package com.publisher.modules.employeeAndAccount.controllers;

import com.publisher.modules.employeeAndAccount.dtos.department.DepartmentCreateDTO;
import com.publisher.modules.employeeAndAccount.dtos.department.DepartmentReadDTO;
import com.publisher.modules.employeeAndAccount.dtos.department.DepartmentUpdateDTO;
import com.publisher.modules.employeeAndAccount.services.department.DepartmentService;
import com.publisher.utils.enums.LogReason;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping(path = "/department")
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;

    /* ================================================= VERSION 1 ================================================= */
    /* CREATE */
    @PostMapping(path = "/v1/create")
    public ResponseEntity<Object> createDepartment(
            @RequestBody DepartmentCreateDTO createDTO) {
        try {
            DepartmentReadDTO readDTO = departmentService.createDepartmentByDTO(createDTO);

            return ResponseEntity.ok().body(readDTO);
        } catch (Exception e) {
            e.printStackTrace();

            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }

    /* READ */
    @GetMapping(path = "/v1/get/id")
    public ResponseEntity<Object> getDepartmentById(
            @RequestParam(required = true) int departmentId) {
        try {
            DepartmentReadDTO readDTO = departmentService.getDTOById(departmentId);

            return ResponseEntity.ok().body(readDTO);
        } catch (Exception e) {
            e.printStackTrace();

            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }

    @GetMapping(path = "/v1/getAll/id")
    public ResponseEntity<Object> getAllDepartmentByIdIn(
            @RequestParam(name = "departmentIds", required = true) Collection<Integer> departmentIdCollection) {
        try {
            List<DepartmentReadDTO> readDTOList = departmentService.getAllDTOByIdIn(departmentIdCollection);

            return ResponseEntity.ok().body(readDTOList);
        } catch (Exception e) {
            e.printStackTrace();

            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }
    
    /* UPDATE */
    @PutMapping(path = "/v1/update")
    public ResponseEntity<Object> updateDepartment(
            @RequestBody DepartmentUpdateDTO updateDTO) {
        try {
            DepartmentReadDTO readDTO = departmentService.updateDepartmentByDTO(updateDTO);

            return ResponseEntity.ok().body(readDTO);
        } catch (Exception e) {
            e.printStackTrace();

            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }


    /* DELETE */

    /* ================================================= VERSION 1 ================================================= */

}
