package com.publisher.modules.planAndTask.services.task;

import com.publisher.modules.planAndTask.dtos.task.TaskCreateDTO;
import com.publisher.modules.planAndTask.dtos.task.TaskReadDTO;
import com.publisher.modules.planAndTask.dtos.task.TaskUpdateDTO;
import com.publisher.modules.planAndTask.entities.Plan;
import com.publisher.modules.planAndTask.entities.Task;
import com.publisher.modules.planAndTask.repositories.TaskRepository;
import com.publisher.modules.planAndTask.services.plan.PlanService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TaskServiceImpl implements TaskService {
    @Autowired
    private ModelMapper mapper;

    @Autowired
    private TaskRepository taskRepository;
    @Lazy /* Avoid circular injection */
    @Autowired
    private PlanService planService;



    /* CREATE */
    @Override
    public Task createTask(Task task) throws Exception {
        int planId = task.getPlanId();

        /* Validate input */
        if (task.getTaskStart().after(task.getTaskEnd())) {/* Check date */
            throw new IllegalArgumentException(
                    "StartDate cannot be after EndDate. Create Aborted."); }

        /* Check duplicate */
        if (taskRepository.isDuplicateInsert(
                task.getTaskCode(), task.getTaskName(), planId)) {
            throw new IllegalArgumentException(
                    "Duplication found when creating Plan. Create Aborted."); }

        /* Check FK */
        Plan plan = planService.getByIdLazy(planId);
        if (plan == null) {
            throw new IllegalArgumentException(
                    "No Plan found with Id: " + planId + ". Create Aborted."); }

        Integer parentTaskId = task.getParentTaskId();
        if (parentTaskId != null) {
            Task parentTask = getByIdLazy(parentTaskId);

            if (parentTask == null) {
                throw new IllegalArgumentException(
                        "No Parent Task found with Id: " + parentTaskId + ". Create Aborted."); }

            task.setParentTask(parentTask);
        }

        task.setPlan(plan);
        
        return taskRepository.saveAndFlush(task);
    }
    @Override
    public TaskReadDTO createTaskByDTO(TaskCreateDTO taskDTO) throws Exception {
        Task task = mapper.map(taskDTO, Task.class);

        task = createTask(task);

        return dtoWrapperSingle(task);
    }

    /* READ */
    @Override
    public boolean existsById(int taskId) throws Exception {
        return taskRepository.existsById(taskId);
    }
    @Override
    public Task getById(int taskId) throws Exception {
        Optional<Task> taskOptional = taskRepository.findById(taskId);

        return taskOptional.orElse(null);
    }
    @Override
    public Task getByIdLazy(int taskId) throws Exception {
        Optional<Task> taskOptional = taskRepository.findByIdLazy(taskId);

        return taskOptional.orElse(null);
    }
    @Override
    public TaskReadDTO getDTOById(int taskId) throws Exception {
        Task task = getById(taskId);

        if (task == null) {
            return null; }

        return dtoWrapperSingle(task);
    }

    @Override
    public List<Task> getAllByIdIn(Collection<Integer> taskIdCollection) throws Exception {
        List<Task> taskList =
                taskRepository.findAllByTaskIdIn(taskIdCollection);

        if (taskList.isEmpty()) {
            return null; }

        return taskList;
    }
    @Override
    public List<TaskReadDTO> getAllDTOByIdIn(Collection<Integer> taskIdCollection) throws Exception {
        List<Task> taskList =
                getAllByIdIn(taskIdCollection);

        if (taskList == null) {
            return null; }

        return dtoWrapperBulk(taskList);
    }

    @Override
    public List<Task> getAllByPlanId(int planId) throws Exception {
        List<Task> taskList =
                taskRepository.findAllByPlanId(planId);

        if (taskList.isEmpty()) {
            return null; }

        return taskList;
    }
    @Override
    public List<TaskReadDTO> getAllDTOByPlanId(int planId) throws Exception {
        List<Task> taskList =
                getAllByPlanId(planId);

        if (taskList == null) {
            return null; }

        return taskList.stream()
                .map(task -> {
                    return mapper.map(task, TaskReadDTO.class);})
                .collect(Collectors.toList());
    }

    @Override
    public List<Task> getAllByPlanIdIn(Collection<Integer> planIdCollection) throws Exception {
        List<Task> taskList = 
                taskRepository.findAllByPlanIdIn(planIdCollection);
        
        if (taskList.isEmpty()) 
            return null;
        
        return taskList;
    }
    @Override
    public List<TaskReadDTO> getAllDTOByPlanIdIn(Collection<Integer> planIdCollection) throws Exception {
        List<Task> taskList =
                getAllByPlanIdIn(planIdCollection);

        if (taskList == null) {
            return null; }

        return dtoWrapperBulk(taskList);
    }

    /* UPDATE */
    @Override
    public Task updateTask(Task task) throws Exception {
        return null;
    }
    @Override
    public TaskReadDTO updateTaskByDTO(TaskUpdateDTO taskDTO) throws Exception {
        return null;
    }

    /* DELETE */
    @Override
    public boolean deleteTask(int taskId) throws Exception {
        /*TODO: NOT YET*/
        return false;
    }

    /* UTIL */
    /* TODO: parentId validation, check for circular dependency (A child of B child of C child of A) */
    /** Wrapper class for all getDTO... in @Service. Unifying return */
    private TaskReadDTO dtoWrapperSingle(Task task) throws Exception {
        /* Map to DTO */
        TaskReadDTO dto = mapper.map(task, TaskReadDTO.class);

        /* Mapping FK */
        List<Task> childTaskList = task.getChildTaskList();
        if (childTaskList != null && !childTaskList.isEmpty()) {
            dto.setChildTaskList(dtoWrapperBulk(childTaskList));
        }

        return dto;
    }

    /** Wrapper class for all getAllDTO... in @Service. Unifying return */
    private List<TaskReadDTO> dtoWrapperBulk(Collection<Task> taskCollection) throws Exception {
        List<TaskReadDTO> taskDTOList = new ArrayList<>();

        List<Task> tmpList;
        TaskReadDTO dto;
        for (Task task : taskCollection) {
            /* Map to DTO */
            dto = mapper.map(task, TaskReadDTO.class);

            /* Mapping FK */
            tmpList = task.getChildTaskList();
            if (tmpList != null && !tmpList.isEmpty()) {
                dto.setChildTaskList(dtoWrapperBulk(tmpList));
            }

            taskDTOList.add(dto);
        }

        return taskDTOList;
    }

}
