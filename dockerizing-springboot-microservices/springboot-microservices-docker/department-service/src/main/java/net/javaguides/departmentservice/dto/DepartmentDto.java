package net.javaguides.departmentservice.dto;

public record DepartmentDto(
        Long id,
        String departmentName,
        String departmentDescription,
        String departmentCode
) {
}
