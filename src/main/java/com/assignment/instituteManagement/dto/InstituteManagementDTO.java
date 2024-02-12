package com.assignment.instituteManagement.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class InstituteManagementDTO {

	int id;
	@NotEmpty
	String instituteName;
	@NotNull
	long instituteContact;
	@NotEmpty
	String instituteLocation;
}
