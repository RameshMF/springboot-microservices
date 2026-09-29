package net.javaguides.employeeservice.service.impl;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import net.javaguides.employeeservice.client.OrganizationClient;
import net.javaguides.employeeservice.client.DepartmentClient;
import net.javaguides.employeeservice.dto.OrganizationDto;
import net.javaguides.employeeservice.dto.DepartmentDto;
import net.javaguides.employeeservice.dto.EmployeeDepartmentResponse;
import net.javaguides.employeeservice.dto.EmployeeDto;
import net.javaguides.employeeservice.entity.Employee;
import net.javaguides.employeeservice.exception.EmployeeNotFoundException;
import net.javaguides.employeeservice.repository.EmployeeRepository;
import net.javaguides.employeeservice.service.EmployeeService;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final DepartmentClient departmentClient;
    private final OrganizationClient organizationClient;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository,
                              DepartmentClient departmentClient,
                              OrganizationClient organizationClient){
        this.employeeRepository = employeeRepository;
        this.departmentClient = departmentClient;
        this.organizationClient = organizationClient;
    }

    @Override
    public EmployeeDto saveEmployee(EmployeeDto employeeDto) {

        Employee employee = new Employee();
        employee.setId(employeeDto.id());
        employee.setFirstName(employeeDto.firstName());
        employee.setLastName(employeeDto.lastName());
        employee.setEmail(employeeDto.email());
        employee.setDepartmentCode(employeeDto.departmentCode());
        employee.setOrganizationCode(employeeDto.organizationCode());

        Employee savedEmployee = employeeRepository.save(employee);

        return mapToEmployeeDto(savedEmployee);
    }

    @Override
    @Retry(name = "EMPLOYEE-SERVICE")
    @CircuitBreaker(name = "EMPLOYEE-SERVICE", fallbackMethod = "getEmployeeWithDefaultDepartment")
    public EmployeeDepartmentResponse getEmployeeById(Long employeeId) {
        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new EmployeeNotFoundException("Employee not found with id: " + employeeId));

        System.out.println("Calling Department Service for department code:" + employee.getDepartmentCode());
        DepartmentDto departmentDto = departmentClient.getDepartmentByCode(employee.getDepartmentCode());

        OrganizationDto organizationDto = organizationClient.getOrganizationByCode(employee.getOrganizationCode());

        return new EmployeeDepartmentResponse(
                mapToEmployeeDto(employee),
                departmentDto,
                organizationDto
        );
    }

    public EmployeeDepartmentResponse getEmployeeWithDefaultDepartment(Long employeeId, Throwable exception) {
        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new EmployeeNotFoundException("Employee not found with id: " + employeeId));

        DepartmentDto departmentDto = new DepartmentDto(
                null,
                "Department details are currently unavailable",
                "Not available",
                employee.getDepartmentCode()
        );

        OrganizationDto organizationDto = new OrganizationDto(
                null,
                "Organization details are currently unavailable",
                "Not available",
                employee.getOrganizationCode(),
                null
        );

        return new EmployeeDepartmentResponse(
                mapToEmployeeDto(employee),
                departmentDto,
                organizationDto
        );
    }

    private EmployeeDto mapToEmployeeDto(Employee employee) {
        return new EmployeeDto(
                employee.getId(),
                employee.getFirstName(),
                employee.getLastName(),
                employee.getEmail(),
                employee.getDepartmentCode(),
                employee.getOrganizationCode()
        );
    }
}
