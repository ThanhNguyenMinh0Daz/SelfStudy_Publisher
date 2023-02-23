package com.publisher.modules.employeeAndAccount.controllers;

import com.publisher.modules.employeeAndAccount.dtos.employee.EmployeeCreateDTO;
import com.publisher.modules.employeeAndAccount.dtos.employee.EmployeeReadDTO;
import com.publisher.modules.employeeAndAccount.dtos.employee.EmployeeUpdateDTO;
import com.publisher.modules.employeeAndAccount.services.employee.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping(path = "/employee")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    /* ================================================= VERSION 1 ================================================= */
    /* CREATE */
    @PostMapping(path = "/v1/create")
    public ResponseEntity<Object> createEmployee(
            @RequestBody EmployeeCreateDTO createDTO) {
        try {
            EmployeeReadDTO readDTO = employeeService.createEmployeeByDTO(createDTO);

            return ResponseEntity.ok().body(readDTO);
        } catch (Exception e) {
            e.printStackTrace();

            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }

    /* READ */
    @GetMapping(path = "/v1/get/id")
    public ResponseEntity<Object> getEmployeeById(
            @RequestParam(required = true) int employeeId) {
        try {
            EmployeeReadDTO readDTO = employeeService.getDTOById(employeeId);

            return ResponseEntity.ok().body(readDTO);
        } catch (Exception e) {
            e.printStackTrace();

            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }

    @GetMapping(path = "/v1/getAll/id")
    public ResponseEntity<Object> getAllEmployeeByIdIn(
            @RequestParam(name = "employeeIds", required = true) Collection<Integer> employeeIdCollection) {
        try {
            List<EmployeeReadDTO> readDTOList = employeeService.getAllDTOByIdIn(employeeIdCollection);

            return ResponseEntity.ok().body(readDTOList);
        } catch (Exception e) {
            e.printStackTrace();

            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }
    
    /* UPDATE */
    @PutMapping(path = "/v1/update")
    public ResponseEntity<Object> updateEmployee(
            @RequestBody EmployeeUpdateDTO updateDTO) {
        try {
            EmployeeReadDTO readDTO = employeeService.updateEmployeeByDTO(updateDTO);

            return ResponseEntity.ok().body(readDTO);
        } catch (Exception e) {
            e.printStackTrace();

            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }


    /* DELETE */

    /* ================================================= VERSION 1 ================================================= */

}
