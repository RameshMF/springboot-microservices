package net.javaguides.employeeservice.dto;

import java.time.LocalDateTime;

public record OrganizationDto(
        Long id,
        String organizationName,
        String organizationDescription,
        String organizationCode,
        LocalDateTime createdDate
) {
}
