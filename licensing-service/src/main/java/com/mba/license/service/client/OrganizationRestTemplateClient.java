package com.mba.license.service.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.mba.license.model.Organization;

/**
 * Organization RestTemplate Client
 * 
 * This class build to play a role of client that will consume org service Using
 * Ribbon-aware Spring RestTemplate for Invoking services.
 * 
 * @author MBA
 *
 */
@Component
public class OrganizationRestTemplateClient {

	@Autowired
	private RestTemplate restTemplate;

	public Organization getOrganization(String organizationId) {
		ResponseEntity<Organization> resExchange = restTemplate.exchange(
				"http://orgservice/v1/organizations/{organizationId}", HttpMethod.GET, null, Organization.class,
				organizationId); 

		return resExchange.getBody();
	}
}
