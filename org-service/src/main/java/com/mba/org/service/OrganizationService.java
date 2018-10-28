package com.mba.org.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mba.org.model.Organization;
import com.mba.org.repository.OrganizationRepository;

@Service
public class OrganizationService {

	@Autowired
	private OrganizationRepository organizationRepository;

	public List<Organization> getOrganizations() {
		return (List<Organization>) organizationRepository.findAll();
	}

	public Optional<Organization> getOrganization(String organizationId) {
		return organizationRepository.findById(organizationId);
	}

	public void updateOrganization(Organization organization) {
		organizationRepository.save(organization);
	}

	public void saveOrganization(Organization organization) {
		organization.setId(UUID.randomUUID().toString());
		organizationRepository.save(organization);
	}

	public void deleteOrganization(Organization organization) {
		organizationRepository.delete(organization);
	}
}
