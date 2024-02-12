package com.assignment.instituteManagement;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.assignment.instituteManagement.controller.InstituteRegistrationController;
import com.assignment.instituteManagement.dto.InstituteManagementDTO;
import com.assignment.instituteManagement.service.InstituteManagementService;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@WebMvcTest(InstituteRegistrationController.class)
public class RegisterInstituteControllerTest {
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
    public void testRegisterInstitute_Success() throws Exception {
        InstituteManagementDTO instituteDTO = new InstituteManagementDTO();
        // Set institute details
        instituteDTO.setId(1);
        instituteDTO.setInstituteName("abc Institute");
        instituteDTO.setInstituteContact(9895254687L);
        instituteDTO.setInstituteLocation("noida");
        when(instituteManagementService.registerInstitute(instituteDTO)).thenReturn(1); // Mock successful registration

        mockMvc.perform(post("/registerInstitute")
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(instituteDTO)))
                .andExpect(status().isCreated());
    }
}
