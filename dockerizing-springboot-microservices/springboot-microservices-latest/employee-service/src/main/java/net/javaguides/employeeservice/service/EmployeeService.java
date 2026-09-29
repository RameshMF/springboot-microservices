package net.javaguides.employeeservice.service;

import net.javaguides.employeeservice.dto.EmployeeDepartmentResponse;
import net.javaguides.employeeservice.dto.EmployeeDto;

public interface EmployeeService {

    EmployeeDto saveEmployee(EmployeeDto employeeDto);

    EmployeeDepartmentResponse getEmployeeById(Long employeeId);
}
