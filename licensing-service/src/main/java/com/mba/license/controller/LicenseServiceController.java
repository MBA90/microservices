package com.mba.license.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.mba.license.model.License;
import com.mba.license.model.Organization;
import com.mba.license.service.LicenseService;
import com.mba.license.service.client.OrganizationRestTemplateClient;

@RestController
@RequestMapping(value = "v1/organizations/{organizationId}/licenses")
public class LicenseServiceController {

	@Autowired
	private LicenseService licenseService;

	@Autowired
	private OrganizationRestTemplateClient organizationRestTemplateClient;

	@RequestMapping(value = "/")
	public List<License> getLicense(@PathVariable String organizationId) {
		return licenseService.getLicenseByOrg(organizationId);
	}

	@RequestMapping(value = "/{licenseId}", method = RequestMethod.GET)
	public License getLicense(@PathVariable String organizationId, @PathVariable String licenseId) {

		Organization organization = organizationRestTemplateClient.getOrganization(organizationId);
		License license = licenseService.getLicene(organizationId, licenseId);
		return license.withOrgnization(organization);
	}

	@RequestMapping(value = "{licenseId}", method = RequestMethod.PUT)
	public String updateLicenses(@PathVariable("licenseId") String licenseId) {
		return String.format("This is the put");
	}

	@RequestMapping(value = "{licenseId}", method = RequestMethod.POST)
	public String saveLicenses(@PathVariable("licenseId") String licenseId) {
		return String.format("This is the post");
	}

	@RequestMapping(value = "{licenseId}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public String deleteLicenses(@PathVariable("licenseId") String licenseId) {
		return String.format("This is the Delete");
	}
}
