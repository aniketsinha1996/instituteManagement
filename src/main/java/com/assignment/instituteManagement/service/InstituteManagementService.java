package com.assignment.instituteManagement.service;

import com.assignment.instituteManagement.dto.InstituteManagementDTO;
import com.assignment.instituteManagement.exception.InstituteManagementException;

public interface InstituteManagementService {
	public Integer registerInstitute(InstituteManagementDTO institute) throws InstituteManagementException;
	public String updateInstitute(Integer id, String instituteName, Long instituteContact,String instituteLocation) throws  InstituteManagementException;
	public InstituteManagementDTO getInstituteById(Integer id) throws InstituteManagementException;
}
