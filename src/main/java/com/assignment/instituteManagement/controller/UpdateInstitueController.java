package com.assignment.instituteManagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.assignment.instituteManagement.dto.InstituteManagementDTO;
import com.assignment.instituteManagement.exception.InstituteManagementException;
import com.assignment.instituteManagement.service.InstituteManagementService;

@RestController
@RequestMapping
public class UpdateInstitueController {
	@Autowired
	InstituteManagementService institutemanagementService;
    @CrossOrigin
    @PutMapping(value = "/updateInstitute/{id}")
	public ResponseEntity<String> updateInstitute(@Validated @PathVariable Integer id, String instituteName,Long instituteContact,String instituteLocation, @RequestBody InstituteManagementDTO institute)
			throws InstituteManagementException {
    	institutemanagementService.updateInstitute(id, institute.getInstituteLocation(),institute.getInstituteContact(),institute.getInstituteLocation());
		String successMessage = "INSTITUTE GOT UPDATED SUCCESSFULLY WITH ID:- "+id;
		return new ResponseEntity<>(successMessage, HttpStatus.OK);
	}
}
