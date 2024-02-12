package com.assignment.instituteManagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.assignment.instituteManagement.dto.InstituteManagementDTO;
import com.assignment.instituteManagement.entity.InstituteManagement;

public interface InstituteManagementRepo extends JpaRepository<InstituteManagement,Integer>{

	InstituteManagement findByInstituteName(String instituteName);

}
