package com.mba.org.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mba.org.model.Organization;

@Repository
public interface OrganizationRepository extends CrudRepository<Organization, String> {
	
	public Optional<Organization> findById(String organizationId);
}
