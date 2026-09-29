package net.javaguides.employeeservice.dto;

public record EmployeeDepartmentResponse(
        EmployeeDto employee,
        DepartmentDto department,
        OrganizationDto organization
) {
}
