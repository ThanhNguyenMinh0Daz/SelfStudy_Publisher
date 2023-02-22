package com.publisher.modules.planAndTask.controllers;

import com.publisher.modules.planAndTask.dtos.task.TaskCreateDTO;
import com.publisher.modules.planAndTask.dtos.task.TaskReadDTO;
import com.publisher.modules.planAndTask.dtos.task.TaskUpdateDTO;
import com.publisher.modules.planAndTask.services.task.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping(path = "/task")
public class TaskController {
    @Autowired
    private TaskService taskService;

    /* ================================================= VERSION 1 ================================================= */
    /* CREATE */
    @PostMapping(path = "/v1/create")
    public ResponseEntity<Object> createTask(
            @RequestBody TaskCreateDTO createDTO) {
        try {
            TaskReadDTO readDTO = taskService.createTaskByDTO(createDTO);

            return ResponseEntity.ok().body(readDTO);
        } catch (Exception e) {
            e.printStackTrace();

            return ResponseEntity.internalServerError().body(e);
        }
    }

    /* READ */
    @GetMapping(path = "/v1/get/id")
    public ResponseEntity<Object> getTaskById(
            @RequestParam(required = true) int taskId) {
        try {
            TaskReadDTO readDTO = taskService.getDTOById(taskId);

            return ResponseEntity.ok().body(readDTO);
        } catch (Exception e) {
            e.printStackTrace();

            return ResponseEntity.internalServerError().body(e);
        }
    }

    @GetMapping(path = "/v1/getAll/id")
    public ResponseEntity<Object> getAllTaskByIdIn(
            @RequestParam(name = "taskIds", required = true) Collection<Integer> taskIdCollection) {
        try {
            List<TaskReadDTO> readDTOList = taskService.getAllDTOByIdIn(taskIdCollection);

            return ResponseEntity.ok().body(readDTOList);
        } catch (Exception e) {
            e.printStackTrace();

            return ResponseEntity.internalServerError().body(e);
        }
    }
    
    /* UPDATE */
    @PutMapping(path = "/v1/update")
    public ResponseEntity<Object> updateTask(
            @RequestBody TaskUpdateDTO updateDTO) {
        try {
            TaskReadDTO readDTO = taskService.updateTaskByDTO(updateDTO);

            return ResponseEntity.ok().body(readDTO);
        } catch (Exception e) {
            e.printStackTrace();

            return ResponseEntity.internalServerError().body(e);
        }
    }


    /* DELETE */

    /* ================================================= VERSION 1 ================================================= */

}
