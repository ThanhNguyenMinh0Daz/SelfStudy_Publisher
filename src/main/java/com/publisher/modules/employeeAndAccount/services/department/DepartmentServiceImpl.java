package com.publisher.modules.employeeAndAccount.services.department;

import com.publisher.modules.employeeAndAccount.dtos.department.DepartmentCreateDTO;
import com.publisher.modules.employeeAndAccount.dtos.department.DepartmentReadDTO;
import com.publisher.modules.employeeAndAccount.dtos.department.DepartmentUpdateDTO;
import com.publisher.modules.employeeAndAccount.entities.Department;
import com.publisher.modules.employeeAndAccount.entities.Department;
import com.publisher.modules.employeeAndAccount.repositories.DepartmentRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    @Autowired
    private ModelMapper mapper;

    @Autowired
    private DepartmentRepository departmentRepository;


/* CREATE */
    @Override
    public Department createDepartment(Department department) throws Exception {
        /* Validate input */

        /* Check duplicate */
        if (departmentRepository.isDuplicateInsert(department.getDepartmentName())) {
            throw new IllegalArgumentException(
                    "Duplication found when creating Department. Create Aborted."); }

        /* Check FK */

        return departmentRepository.saveAndFlush(department);
    }
    @Override
    public DepartmentReadDTO createDepartmentByDTO(DepartmentCreateDTO departmentDTO) throws Exception {
        Department department = mapper.map(departmentDTO, Department.class);

        department = createDepartment(department);

        return dtoWrapperSingle(department);
    }

    /* READ */
    @Override
    public boolean existsById(int departmentId) throws Exception {
        return departmentRepository.existsById(departmentId);
    }
    @Override
    public Department getById(int departmentId) throws Exception {
        Optional<Department> departmentOptional = departmentRepository.findById(departmentId);

        return departmentOptional.orElse(null);
    }
    @Override
    public DepartmentReadDTO getDTOById(int departmentId) throws Exception {
        Department department = getById(departmentId);

        if (department == null) {
            return null; }

        return dtoWrapperSingle(department);
    }

    @Override
    public List<Department> getAllByIdIn(Collection<Integer> departmentIdCollection) throws Exception {
        List<Department> departmentList =
                departmentRepository.findAllByDepartmentIdIn(departmentIdCollection);

        if (departmentList.isEmpty()) {
            return null; }

        return departmentList;
    }
    @Override
    public List<DepartmentReadDTO> getAllDTOByIdIn(Collection<Integer> departmentIdCollection) throws Exception {
        List<Department> departmentList =
                getAllByIdIn(departmentIdCollection);

        if (departmentList == null) {
            return null; }

        return dtoWrapperBulk(departmentList);
    }

    /* UPDATE */
    @Override
    public Department updateDepartment(Department department) throws Exception {
        return null;
    }
    @Override
    public DepartmentReadDTO updateDepartmentByDTO(DepartmentUpdateDTO departmentDTO) throws Exception {
        return null;
    }

/* DELETE */
    @Override
    public boolean deleteDepartment(int departmentId) throws Exception {
        /*TODO: NOT YET*/
        return false;
    }

/* UTIL */
    /** Wrapper class for all getDTO... in @Service. Unifying return */
    private DepartmentReadDTO dtoWrapperSingle(Department department) throws Exception {
        /* Map to DTO */
        DepartmentReadDTO dto = mapper.map(department, DepartmentReadDTO.class);

        /* Mapping FK */

        return dto;
    }

    /** Wrapper class for all getAllDTO... in @Service. Unifying return */
    private List<DepartmentReadDTO> dtoWrapperBulk(Collection<Department> departmentCollection) throws Exception {
        List<DepartmentReadDTO> departmentDTOList = new ArrayList<>();

        DepartmentReadDTO dto;
        for (Department department : departmentCollection) {
            /* Map to DTO */
            dto = mapper.map(department, DepartmentReadDTO.class);

            /* Mapping FK */

            departmentDTOList.add(dto);
        }

        return departmentDTOList;
    }

}
