package com.assignment.instituteManagement.service;

import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assignment.instituteManagement.dto.InstituteManagementDTO;
import com.assignment.instituteManagement.entity.InstituteManagement;
import com.assignment.instituteManagement.exception.InstituteManagementException;
import com.assignment.instituteManagement.repository.InstituteManagementRepo;

import jakarta.transaction.Transactional;
@Service(value = "instituteManagementService")
@Transactional
public class InstituteManagementServiceImpl implements InstituteManagementService{
	@Autowired
	InstituteManagementRepo instituteManagementRepo;

	//Method for institute registration
	@Override
	public Integer registerInstitute(InstituteManagementDTO institute) throws InstituteManagementException {
		// TODO Auto-generated method stub
		InstituteManagement instituteEntity = new InstituteManagement();

		//setting the value of fields using InstituteManagement reference
		instituteEntity.setInstituteName(institute.getInstituteName());
		instituteEntity.setInstituteContact(institute.getInstituteContact());
		instituteEntity.setInstituteLocation(institute.getInstituteLocation());
		InstituteManagement instituteOptional=instituteManagementRepo.findByInstituteName(institute.getInstituteName());
		//validating if the institute is already present
        if(instituteOptional!=null){
            throw new InstituteManagementException("Institute already exist with given name:" +institute.getInstituteName());
        }
		InstituteManagement instituteEntity2=instituteManagementRepo.save(instituteEntity);
		return instituteEntity2.getId();		

	}

	//Method for institute Modification
	@Override
	public String updateInstitute(Integer id, String instituteName, Long instituteContact, String instituteLocation)
			throws InstituteManagementException {
		// TODO Auto-generated method stub
		Optional<InstituteManagement> institute = instituteManagementRepo.findById(id);
		//throwing exception if institute for given id is not found
		InstituteManagement i = institute.orElseThrow(() -> new InstituteManagementException("INSTITUTE_NOT_FOUND"));
		i.setInstituteContact(instituteContact);
		i.setInstituteLocation(instituteLocation);
		i.setInstituteName(instituteName);
		return "updated";
		
	}

	//Method for fetch institute based on id
	@Override
	public InstituteManagementDTO getInstituteById(Integer id) throws InstituteManagementException {
		// TODO Auto-generated method stub
		Optional<InstituteManagement> optional = instituteManagementRepo.findById(id);
		//throwing exception if institute for given id is not found
		InstituteManagement institute = optional.orElseThrow(() -> new InstituteManagementException("INSTITUTE_NOT_FOUND"));
		InstituteManagementDTO institute2 = new InstituteManagementDTO();
		//Setting the value with DTO class reference
		institute2.setId(institute.getId());
		institute2.setInstituteName(institute.getInstituteName());
		institute2.setInstituteContact(institute.getInstituteContact());
		institute2.setInstituteLocation(institute.getInstituteLocation());
		return institute2;
	}


 
}
