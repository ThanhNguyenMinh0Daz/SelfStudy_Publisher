package com.publisher.modules.employeeAndAccount.services.employee;

import com.publisher.modules.employeeAndAccount.dtos.employee.EmployeeCreateDTO;
import com.publisher.modules.employeeAndAccount.dtos.employee.EmployeeReadDTO;
import com.publisher.modules.employeeAndAccount.dtos.employee.EmployeeUpdateDTO;
import com.publisher.modules.employeeAndAccount.entities.Department;
import com.publisher.modules.employeeAndAccount.entities.Employee;
import com.publisher.modules.employeeAndAccount.repositories.EmployeeRepository;
import com.publisher.modules.employeeAndAccount.services.department.DepartmentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.concurrent.TimeUnit;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private ModelMapper mapper;

    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private DepartmentService departmentService;

    /** May subject to change, depend on national law */
    private static final long MIN_EMPLOYEE_AGE = 18L;


/* CREATE */
    @Override
    public Employee createEmployee(Employee employee) throws Exception {
        int departmentId = employee.getDepartmentId();

        /* Validate input */
        LocalDateTime birthDate = new Timestamp(employee.getBirthDate().getTime()).toLocalDateTime();
        LocalDateTime currentDate = LocalDateTime.now();

        if (!birthDate.isBefore(currentDate)) {
            throw new IllegalArgumentException(
                    "BirthDate cannot be equal or after today. Create Aborted.");
        } else if (ChronoUnit.YEARS.between(birthDate, currentDate) < MIN_EMPLOYEE_AGE)
            throw new IllegalArgumentException(
                    "This BirthDate indicate that this Employee is not of legal working age. Create Aborted.");

        /* TODO: Check valid nationalId */

        /* Check duplicate */
        if (employeeRepository.isDuplicateInsert(employee.getNationalId()))
            throw new IllegalArgumentException(
                    "Duplication found when creating Employee. Create Aborted.");

        /* Check FK */
        Department department = departmentService.getById(departmentId);
        if (department == null)
            throw new IllegalArgumentException(
                    "No Department found with Id: " + departmentId + ". Create Aborted.");

        employee.setDepartment(department);

        return employeeRepository.saveAndFlush(employee);
    }
    @Override
    public EmployeeReadDTO createEmployeeByDTO(EmployeeCreateDTO employeeDTO) throws Exception {
        Employee employee = mapper.map(employeeDTO, Employee.class);

        employee = createEmployee(employee);

        return dtoWrapperSingle(employee);
    }

    /* READ */
    @Override
    public boolean existsById(int employeeId) throws Exception {
        return employeeRepository.existsById(employeeId);
    }
    @Override
    public Employee getById(int employeeId) throws Exception {
        Optional<Employee> employeeOptional = employeeRepository.findById(employeeId);

        return employeeOptional.orElse(null);
    }
    @Override
    public Employee getByIdLazy(int employeeId) throws Exception {
        Optional<Employee> employeeOptional = employeeRepository.findByIdLazy(employeeId);

        return employeeOptional.orElse(null);
    }
    @Override
    public EmployeeReadDTO getDTOById(int employeeId) throws Exception {
        Employee employee = getById(employeeId);

        if (employee == null)
            return null;

        return dtoWrapperSingle(employee);
    }

    @Override
    public List<Employee> getAllByIdIn(Collection<Integer> employeeIdCollection) throws Exception {
        List<Employee> employeeList =
                employeeRepository.findAllByEmployeeIdIn(employeeIdCollection);

        if (employeeList.isEmpty())
            return null;

        return employeeList;
    }
    @Override
    public List<EmployeeReadDTO> getAllDTOByIdIn(Collection<Integer> employeeIdCollection) throws Exception {
        List<Employee> employeeList =
                getAllByIdIn(employeeIdCollection);

        if (employeeList == null)
            return null;

        return dtoWrapperBulk(employeeList);
    }

    /* departmentId */
    @Override
    public List<Employee> getAllByDepartmentId(int departmentId) throws Exception {
        return null;
    }
    @Override
    public List<EmployeeReadDTO> getAllDTOByDepartmentId(int departmentId) throws Exception {
        return null;
    }

    @Override
    public List<Employee> getAllByDepartmentIdIn(Collection<Integer> departmentIdCollection) throws Exception {
        return null;
    }
    @Override
    public List<EmployeeReadDTO> getAllDTOByDepartmentIdIn(Collection<Integer> departmentIdCollection) throws Exception {
        return null;
    }

    /* UPDATE */
    @Override
    public Employee updateEmployee(Employee employee) throws Exception {
        return null;
    }
    @Override
    public EmployeeReadDTO updateEmployeeByDTO(EmployeeUpdateDTO employeeDTO) throws Exception {
        return null;
    }

/* DELETE */
    @Override
    public boolean deleteEmployee(int employeeId) throws Exception {
        /*TODO: NOT YET*/
        return false;
    }

/* UTIL */
    /** Wrapper class for all getDTO... in @Service. Unifying return */
    private EmployeeReadDTO dtoWrapperSingle(Employee employee) throws Exception {
        /* Map to DTO */
        EmployeeReadDTO dto = mapper.map(employee, EmployeeReadDTO.class);

        /* Mapping FK */

        return dto;
    }

    /** Wrapper class for all getAllDTO... in @Service. Unifying return */
    private List<EmployeeReadDTO> dtoWrapperBulk(Collection<Employee> employeeCollection) throws Exception {
        List<EmployeeReadDTO> employeeDTOList = new ArrayList<>();

        EmployeeReadDTO dto;
        for (Employee employee : employeeCollection) {
            /* Map to DTO */
            dto = mapper.map(employee, EmployeeReadDTO.class);

            /* Mapping FK */

            employeeDTOList.add(dto);
        }

        return employeeDTOList;
    }

}
