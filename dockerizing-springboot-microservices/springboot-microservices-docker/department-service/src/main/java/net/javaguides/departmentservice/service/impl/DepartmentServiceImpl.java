package net.javaguides.departmentservice.service.impl;

import net.javaguides.departmentservice.dto.DepartmentDto;
import net.javaguides.departmentservice.entity.Department;
import net.javaguides.departmentservice.exception.DepartmentNotFoundException;
import net.javaguides.departmentservice.repository.DepartmentRepository;
import net.javaguides.departmentservice.service.DepartmentService;
import org.springframework.stereotype.Service;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    private final DepartmentRepository departmentRepository;

    public DepartmentServiceImpl(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    @Override
    public DepartmentDto saveDepartment(DepartmentDto departmentDto) {

        Department department = new Department();
        department.setId(departmentDto.id());
        department.setDepartmentName(departmentDto.departmentName());
        department.setDepartmentDescription(departmentDto.departmentDescription());
        department.setDepartmentCode(departmentDto.departmentCode());

        Department savedDepartment = departmentRepository.save(department);

        return mapToDepartmentDto(savedDepartment);
    }

    @Override
    public DepartmentDto getDepartmentByCode(String departmentCode) {

        Department department = departmentRepository.findByDepartmentCode(departmentCode)
                .orElseThrow(() -> new DepartmentNotFoundException("Department not found with code: " + departmentCode));

        return mapToDepartmentDto(department);
    }

    private DepartmentDto mapToDepartmentDto(Department department) {
        return new DepartmentDto(
                department.getId(),
                department.getDepartmentName(),
                department.getDepartmentDescription(),
                department.getDepartmentCode()
        );
    }
}
