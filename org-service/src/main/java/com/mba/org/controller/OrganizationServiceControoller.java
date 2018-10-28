package com.mba.org.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mba.org.model.Organization;
import com.mba.org.service.OrganizationService;

@RestController
@RequestMapping(value = "v1/organizations")
public class OrganizationServiceControoller {

	@Autowired
	private OrganizationService organizationService;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public List<Organization> getOrganizations() {
		return organizationService.getOrganizations();
	}
	
	@RequestMapping(value = "/{organizationId}", method = RequestMethod.GET)
	public Organization getOrganization(@PathVariable("organizationId") String organizationId) {
		Optional<Organization> organization = organizationService.getOrganization(organizationId);
		return organization.isPresent() ? organization.get() : null;
	}

	@RequestMapping(value = "/{organizationId}", method = RequestMethod.PUT)
	public void updateOrganization(@PathVariable("organizationId") String organizationId,
			@RequestBody Organization organization) {
		organizationService.updateOrganization(organization);
	}

	@RequestMapping(value = "/{organizationId}", method = RequestMethod.POST)
	public void saveOrganization(@RequestBody Organization organization) {
		organizationService.saveOrganization(organization);
	}

	@RequestMapping(value = "/{organizationId}", method = RequestMethod.DELETE)
	public void deleteOrganization(@PathVariable("organizationId") String organizationId,
			@RequestBody Organization organization) {
		organizationService.deleteOrganization(organization);
	}

}
