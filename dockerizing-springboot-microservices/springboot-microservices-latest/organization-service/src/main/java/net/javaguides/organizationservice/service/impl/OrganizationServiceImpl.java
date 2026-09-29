package net.javaguides.organizationservice.service.impl;

import net.javaguides.organizationservice.dto.OrganizationDto;
import net.javaguides.organizationservice.entity.Organization;
import net.javaguides.organizationservice.exception.OrganizationNotFoundException;
import net.javaguides.organizationservice.repository.OrganizationRepository;
import net.javaguides.organizationservice.service.OrganizationService;
import org.springframework.stereotype.Service;

@Service
public class OrganizationServiceImpl implements OrganizationService {

    private final OrganizationRepository organizationRepository;

    public OrganizationServiceImpl(OrganizationRepository organizationRepository) {
        this.organizationRepository = organizationRepository;
    }

    @Override
    public OrganizationDto saveOrganization(OrganizationDto organizationDto) {

        Organization organization = new Organization();
        organization.setId(organizationDto.id());
        organization.setOrganizationName(organizationDto.organizationName());
        organization.setOrganizationDescription(organizationDto.organizationDescription());
        organization.setOrganizationCode(organizationDto.organizationCode());
        organization.setCreatedDate(organizationDto.createdDate());

        Organization savedOrganization = organizationRepository.save(organization);

        return mapToOrganizationDto(savedOrganization);
    }

    @Override
    public OrganizationDto getOrganizationByCode(String organizationCode) {

        Organization organization = organizationRepository.findByOrganizationCode(organizationCode)
                .orElseThrow(() -> new OrganizationNotFoundException("Organization not found with code: " + organizationCode));

        return mapToOrganizationDto(organization);
    }

    private OrganizationDto mapToOrganizationDto(Organization organization) {
        return new OrganizationDto(
                organization.getId(),
                organization.getOrganizationName(),
                organization.getOrganizationDescription(),
                organization.getOrganizationCode(),
                organization.getCreatedDate()
        );
    }
}
