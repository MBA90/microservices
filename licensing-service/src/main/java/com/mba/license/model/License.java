package com.mba.license.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author MBA
 *
 */
@Entity
@Table(name = "license")
public class License {

	@Id
	@Column(name = "license_id", nullable = false)
	private String licenseId;

	@Column(name = "organization_id", nullable = false)
	private String organizationId;

	@Column(name = "product_name", nullable = false)
	private String productName;

	@Column(name = "license_type", nullable = false)
	private String licenseType;

	public String getLicenseId() {
		return licenseId;
	}

	public void setLicenseId(String licenseId) {
		this.licenseId = licenseId;
	}

	public String getOrganizationId() {
		return organizationId;
	}

	public void setOrganizationId(String organizationId) {
		this.organizationId = organizationId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getLicenseType() {
		return licenseType;
	}

	public void setLicenseType(String licenseType) {
		this.licenseType = licenseType;
	}

	public License withId(String id) {
		this.setLicenseId(id);
		return this;
	}

	public License withOrganizationId(String organizationId) {
		this.setOrganizationId(organizationId);
		return this;
	}

	public License withProductName(String productName) {
		this.setProductName(productName);
		return this;
	}

	public License withLicenseType(String licenseType) {
		this.setLicenseType(licenseType);
		return this;
	}
}
