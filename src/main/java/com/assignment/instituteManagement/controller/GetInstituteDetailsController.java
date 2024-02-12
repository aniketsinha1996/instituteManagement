package com.assignment.instituteManagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.assignment.instituteManagement.dto.InstituteManagementDTO;
import com.assignment.instituteManagement.exception.InstituteManagementException;
import com.assignment.instituteManagement.service.InstituteManagementService;


@RestController
@RequestMapping
public class GetInstituteDetailsController {
	@Autowired
	InstituteManagementService institutemanagementService;
	@GetMapping(value = "/getInstituteDetails/{id}")
	public ResponseEntity<InstituteManagementDTO> getInstituteDetails(@PathVariable Integer id) throws InstituteManagementException {
		InstituteManagementDTO institute = institutemanagementService.getInstituteById(id);
		return new ResponseEntity<>(institute, HttpStatus.OK);
	}
}
