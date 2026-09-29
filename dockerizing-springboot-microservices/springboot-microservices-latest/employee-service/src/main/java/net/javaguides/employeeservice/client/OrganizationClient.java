package net.javaguides.employeeservice.client;

import net.javaguides.employeeservice.dto.OrganizationDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "organization-service")
public interface OrganizationClient {
    @GetMapping("/api/organizations/code/{organizationCode}")
    OrganizationDto getOrganizationByCode(@PathVariable("organizationCode") String organizationCode);
}
