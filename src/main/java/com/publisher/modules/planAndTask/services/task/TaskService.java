package com.publisher.modules.planAndTask.services.task;


import com.publisher.modules.planAndTask.dtos.task.TaskCreateDTO;
import com.publisher.modules.planAndTask.dtos.task.TaskReadDTO;
import com.publisher.modules.planAndTask.dtos.task.TaskUpdateDTO;
import com.publisher.modules.planAndTask.entities.Task;

import java.util.Collection;
import java.util.List;

public interface TaskService {
    /* CREATE */
    Task createTask(Task task) throws Exception;
    TaskReadDTO createTaskByDTO(TaskCreateDTO taskDTO) throws Exception;

    /* READ */
    boolean existsById(int taskId) throws Exception;
    Task getById(int taskId) throws Exception;
    /** Using Fetch LAZY, default is EAGER */
    Task getByIdLazy(int taskId) throws Exception;
    TaskReadDTO getDTOById(int taskId) throws Exception;

    List<Task> getAllByIdIn(Collection<Integer> taskIdCollection) throws Exception;
    List<TaskReadDTO> getAllDTOByIdIn(Collection<Integer> taskIdCollection) throws Exception;

    List<Task> getAllByPlanId(int planId) throws Exception;
    List<TaskReadDTO> getAllDTOByPlanId(int planId) throws Exception;

    List<Task> getAllByPlanIdIn(Collection<Integer> planIdCollection) throws Exception;
    List<TaskReadDTO> getAllDTOByPlanIdIn(Collection<Integer> planIdCollection) throws Exception;

    /* UPDATE */
    Task updateTask(Task task) throws Exception;
    TaskReadDTO updateTaskByDTO(TaskUpdateDTO taskDTO) throws Exception;

    /* DELETE */
    boolean deleteTask(int taskId) throws Exception;

}
