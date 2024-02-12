package com.assignment.instituteManagement;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.assignment.instituteManagement.dto.InstituteManagementDTO;
import com.assignment.instituteManagement.entity.InstituteManagement;
import com.assignment.instituteManagement.exception.InstituteManagementException;
import com.assignment.instituteManagement.repository.InstituteManagementRepo;
import com.assignment.instituteManagement.service.InstituteManagementServiceImpl;

@ExtendWith(MockitoExtension.class)
public class ServiceTest {
    @Mock
    private InstituteManagementRepo instituteManagementRepo;

    @InjectMocks
    private InstituteManagementServiceImpl instituteService;

    @Test
    public void testRegisterInstitute_success() throws InstituteManagementException {
        // Prepare test data
        InstituteManagementDTO instituteDTO = new InstituteManagementDTO();
        instituteDTO.setInstituteName("abc Institute");
        instituteDTO.setInstituteContact(1234567890);
        instituteDTO.setInstituteLocation("noida");

        when(instituteManagementRepo.findByInstituteName("abc Institute")).thenReturn(null);
        when(instituteManagementRepo.save(any())).thenReturn(new InstituteManagement());

        Integer id = instituteService.registerInstitute(instituteDTO);

        assertNotNull(id);
        verify(instituteManagementRepo, times(1)).save(any()); // Use captured argument
    }
    @Test
    public void testRegisterInstitute_ExistingInstitute_ExceptionThrown() {
        InstituteManagementDTO instituteDTO = new InstituteManagementDTO();
        instituteDTO.setInstituteName("Existing Institute");
        instituteDTO.setInstituteContact(1234567890);
        instituteDTO.setInstituteLocation("Location");

        when(instituteManagementRepo.findByInstituteName("Existing Institute")).thenReturn(new InstituteManagement());

        assertThrows(InstituteManagementException.class, () -> {
        	instituteService.registerInstitute(instituteDTO);
        });

        verify
(instituteManagementRepo, never()).save(any());
    }
}
