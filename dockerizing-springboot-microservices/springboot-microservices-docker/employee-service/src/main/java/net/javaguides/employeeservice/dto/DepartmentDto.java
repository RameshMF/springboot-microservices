package net.javaguides.employeeservice.dto;

public record DepartmentDto(
        Long id,
        String departmentName,
        String departmentDescription,
        String departmentCode
) {
}
