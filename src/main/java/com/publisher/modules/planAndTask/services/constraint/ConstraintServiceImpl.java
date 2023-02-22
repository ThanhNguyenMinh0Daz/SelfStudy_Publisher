package com.publisher.modules.planAndTask.services.constraint;

import com.publisher.modules.planAndTask.dtos.constraint.ConstraintCreateDTO;
import com.publisher.modules.planAndTask.dtos.constraint.ConstraintReadDTO;
import com.publisher.modules.planAndTask.dtos.constraint.ConstraintUpdateDTO;
import com.publisher.modules.planAndTask.entities.Constraint;
import com.publisher.modules.planAndTask.repositories.ConstraintRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
public class ConstraintServiceImpl implements ConstraintService {
    @Autowired
    private ModelMapper mapper;

    @Autowired
    private ConstraintRepository constraintRepository;



/* CREATE */
    @Override
    public Constraint createConstraint(Constraint constraint) throws Exception {
        return constraintRepository.saveAndFlush(constraint);
    }
    @Override
    public ConstraintReadDTO createConstraintByDTO(ConstraintCreateDTO constraintDTO) throws Exception {
        Constraint constraint = mapper.map(constraintDTO, Constraint.class);

        constraint = createConstraint(constraint);

        return dtoWrapperSingle(constraint);
    }

/* READ */
    @Override
    public boolean existsById(int constraintId) throws Exception {
        return constraintRepository.existsById(constraintId);
    }
    @Override
    public Constraint getById(int constraintId) throws Exception {
        Optional<Constraint> constraintOptional = constraintRepository.findById(constraintId);

        return constraintOptional.orElse(null);
    }
    @Override
    public ConstraintReadDTO getDTOById(int constraintId) throws Exception {
        Constraint constraint = getById(constraintId);

        if (constraint == null)
            return null;

        return dtoWrapperSingle(constraint);
    }

    @Override
    public List<Constraint> getAllByIdIn(Collection<Integer> constraintIdCollection) throws Exception {
        List<Constraint> constraintList =
                constraintRepository.findAllByConstraintIdIn(constraintIdCollection);

        if (constraintList.isEmpty())
            return null;

        return constraintList;
    }
    @Override
    public List<ConstraintReadDTO> getAllDTOByIdIn(Collection<Integer> constraintIdCollection) throws Exception {
        List<Constraint> constraintList =
                getAllByIdIn(constraintIdCollection);

        if (constraintList == null)
            return null;

        return dtoWrapperBulk(constraintList);
    }

    /* planId */
    @Override
    public List<Constraint> getAllByConstraintPlanId(int planId) throws Exception {
        List<Constraint> constraintList =
                constraintRepository.findAllByConstraintPlanId(planId);

        if (constraintList.isEmpty())
            return null;

        return constraintList;
    }
    @Override
    public List<ConstraintReadDTO> getAllDTOByConstraintPlanId(int planId) throws Exception {
        List<Constraint> constraintList =
                getAllByConstraintPlanId(planId);

        if (constraintList == null)
            return null;

        return dtoWrapperBulk(constraintList);
    }

    @Override
    public List<Constraint> getAllByConstraintPlanIdIn(Collection<Integer> planIdCollection) throws Exception {
        List<Constraint> constraintList =
                constraintRepository.findAllByConstraintPlanIdIn(planIdCollection);

        if (constraintList.isEmpty())
            return null;

        return constraintList;
    }
    @Override
    public List<ConstraintReadDTO> getAllDTOByConstraintPlanIdIn(Collection<Integer> planIdCollection) throws Exception {
        List<Constraint> constraintList =
                getAllByConstraintPlanIdIn(planIdCollection);

        if (constraintList == null)
            return null;

        return dtoWrapperBulk(constraintList);
    }

    @Override
    public List<Constraint> getAllByAffectedPlanId(int planId) throws Exception {
        List<Constraint> constraintList =
                constraintRepository.findAllByAffectedPlanId(planId);

        if (constraintList.isEmpty())
            return null;

        return constraintList;
    }
    @Override
    public List<ConstraintReadDTO> getAllDTOByAffectedPlanId(int planId) throws Exception {
        List<Constraint> constraintList =
                getAllByAffectedPlanId(planId);

        if (constraintList == null)
            return null;

        return dtoWrapperBulk(constraintList);
    }

    @Override
    public List<Constraint> getAllByAffectedPlanIdIn(Collection<Integer> planIdCollection) throws Exception {
        List<Constraint> constraintList =
                constraintRepository.findAllByAffectedPlanIdIn(planIdCollection);

        if (constraintList.isEmpty())
            return null;

        return constraintList;
    }
    @Override
    public List<ConstraintReadDTO> getAllDTOByAffectedPlanIdIn(Collection<Integer> planIdCollection) throws Exception {
        List<Constraint> constraintList =
                getAllByAffectedPlanIdIn(planIdCollection);

        if (constraintList == null)
            return null;

        return dtoWrapperBulk(constraintList);
    }

    /* taskId */
    @Override
    public List<Constraint> getAllByConstraintTaskId(int taskId) throws Exception {
        List<Constraint> constraintList =
                constraintRepository.findAllByConstraintTaskId(taskId);

        if (constraintList.isEmpty())
            return null;

        return constraintList;
    }
    @Override
    public List<ConstraintReadDTO> getAllDTOByConstraintTaskId(int taskId) throws Exception {
        List<Constraint> constraintList =
                getAllByConstraintTaskId(taskId);

        if (constraintList == null)
            return null;

        return dtoWrapperBulk(constraintList);
    }

    @Override
    public List<Constraint> getAllByConstraintTaskIdIn(Collection<Integer> taskIdCollection) throws Exception {
        List<Constraint> constraintList =
                constraintRepository.findAllByConstraintTaskIdIn(taskIdCollection);

        if (constraintList.isEmpty())
            return null;

        return constraintList;
    }
    @Override
    public List<ConstraintReadDTO> getAllDTOByConstraintTaskIdIn(Collection<Integer> taskIdCollection) throws Exception {
        List<Constraint> constraintList =
                getAllByConstraintTaskIdIn(taskIdCollection);

        if (constraintList == null)
            return null;

        return dtoWrapperBulk(constraintList);
    }

    @Override
    public List<Constraint> getAllByAffectedTaskId(int taskId) throws Exception {
        List<Constraint> constraintList =
                constraintRepository.findAllByAffectedTaskId(taskId);

        if (constraintList.isEmpty())
            return null;

        return constraintList;
    }
    @Override
    public List<ConstraintReadDTO> getAllDTOByAffectedTaskId(int taskId) throws Exception {
        List<Constraint> constraintList =
                getAllByAffectedTaskId(taskId);

        if (constraintList == null)
            return null;

        return dtoWrapperBulk(constraintList);
    }

    @Override
    public List<Constraint> getAllByAffectedTaskIdIn(Collection<Integer> taskIdCollection) throws Exception {
        List<Constraint> constraintList =
                constraintRepository.findAllByAffectedTaskIdIn(taskIdCollection);

        if (constraintList.isEmpty())
            return null;

        return constraintList;
    }
    @Override
    public List<ConstraintReadDTO> getAllDTOByAffectedTaskIdIn(Collection<Integer> taskIdCollection) throws Exception {
        List<Constraint> constraintList =
                getAllByAffectedTaskIdIn(taskIdCollection);

        if (constraintList == null)
            return null;

        return dtoWrapperBulk(constraintList);
    }

/* UPDATE */
    @Override
    public Constraint updateConstraint(Constraint constraint) throws Exception {
        return null;
    }
    @Override
    public ConstraintReadDTO updateConstraintByDTO(ConstraintUpdateDTO constraintDTO) throws Exception {
        return null;
    }

/* DELETE */
    @Override
    public boolean deleteConstraint(int constraintId) throws Exception {
        /*TODO: NOT YET*/
        return false;
    }

/* UTIL */
    /** Wrapper class for all getDTO... in @Service. Unifying return */
    private ConstraintReadDTO dtoWrapperSingle(Constraint constraint) throws Exception {
        /* Map to DTO */
        ConstraintReadDTO dto = mapper.map(constraint, ConstraintReadDTO.class);

        /* Mapping FK */

        return dto;
    }

    /** Wrapper class for all getAllDTO... in @Service. Unifying return */
    private List<ConstraintReadDTO> dtoWrapperBulk(Collection<Constraint> constraintCollection) throws Exception {
        List<ConstraintReadDTO> constraintDTOList = new ArrayList<>();

        ConstraintReadDTO dto;
        for (Constraint constraint : constraintCollection) {
            /* Map to DTO */
            dto = mapper.map(constraint, ConstraintReadDTO.class);

            /* Mapping FK */

            constraintDTOList.add(dto);
        }

        return constraintDTOList;
    }

}
