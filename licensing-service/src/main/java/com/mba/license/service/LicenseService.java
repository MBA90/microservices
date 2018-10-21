package com.mba.license.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mba.license.model.License;
import com.mba.license.repository.LicenseRepository;

@Service
public class LicenseService {

	@Autowired
	private LicenseRepository licenseRepository;

	public License getLicene(String organizationId, String licenseId) {
		return licenseRepository.findByOrganizationIdAndLicenseId(organizationId, licenseId);
	}
	
	public List<License> getLicenseByOrg(String organizationId){
		return licenseRepository.findByOrganizationId(organizationId);
	}
}
