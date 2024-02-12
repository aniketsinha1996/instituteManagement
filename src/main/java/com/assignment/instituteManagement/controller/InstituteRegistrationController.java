package com.assignment.instituteManagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.assignment.instituteManagement.dto.InstituteManagementDTO;
import com.assignment.instituteManagement.exception.InstituteManagementException;
import com.assignment.instituteManagement.service.InstituteManagementService;

@RestController
@RequestMapping
public class InstituteRegistrationController {
	@Autowired
	InstituteManagementService institutemanagementService;
	@Autowired
	Environment environment;
    @PostMapping(value = "/registerInstitute")
	public ResponseEntity<String> registerInstitute(@Validated @RequestBody InstituteManagementDTO institute) throws InstituteManagementException {
        // handle request
        HttpHeaders headers = new HttpHeaders();
        headers.add("Access-Control-Allow-Origin", "*");
        headers.add("Content-Type", "application/json");
    	Integer instituteId = institutemanagementService.registerInstitute(institute);
		String successMessage = "Institute registration Successfull with id:- "+ instituteId;
		return new ResponseEntity<>(successMessage, HttpStatus.CREATED);
	}
}
