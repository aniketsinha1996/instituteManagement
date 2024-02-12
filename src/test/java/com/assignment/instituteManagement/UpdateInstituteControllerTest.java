package com.assignment.instituteManagement;

import static org.hamcrest.CoreMatchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.assignment.instituteManagement.controller.UpdateInstitueController;
import com.assignment.instituteManagement.dto.InstituteManagementDTO;
import com.assignment.instituteManagement.service.InstituteManagementService;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@WebMvcTest(UpdateInstitueController.class)
public class UpdateInstituteControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private InstituteManagementService instituteManagementService;
    private static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    @Test
    public void testUpdateInstitute_Success() throws Exception {
        // Prepare request data
        Integer instituteId = 1;
        InstituteManagementDTO instituteDTO = new InstituteManagementDTO();
        instituteDTO.setInstituteName("New Name");
        instituteDTO.setInstituteContact(9876543210L);
        instituteDTO.setInstituteLocation("New Location");

        // Mock service behavior
        when(instituteManagementService.updateInstitute(instituteId, instituteDTO.getInstituteLocation(),
                instituteDTO.getInstituteContact(), instituteDTO.getInstituteLocation())).thenReturn("updated");

        // Perform PUT request
        mockMvc.perform(put("/updateInstitute/{id}", instituteId)
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(instituteDTO)))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("INSTITUTE GOT UPDATED SUCCESSFULLY WITH ID:- " + instituteId)));
    }
}
