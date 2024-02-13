package com.assignment.instituteManagement.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
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
@Entity
@Table
public class InstituteManagement {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	@Column(nullable=false)
	String instituteName;
	@Column(nullable=false)
	long instituteContact;
	@Column(nullable=false)
	String instituteLocation;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getInstituteName() {
		return instituteName;
	}
	public void setInstituteName(String instituteName) {
		this.instituteName = instituteName;
	}
	public long getInstituteContact() {
		return instituteContact;
	}
	public void setInstituteContact(long instituteContact) {
		this.instituteContact = instituteContact;
	}
	public String getInstituteLocation() {
		return instituteLocation;
	}
	public void setInstituteLocation(String instituteLocation) {
		this.instituteLocation = instituteLocation;
	}
	@Override
	public String toString() {
		return "InstituteManagement [id=" + id + ", instituteName=" + instituteName + ", instituteContact="
				+ instituteContact + ", instituteLocation=" + instituteLocation + "]";
	}

}
