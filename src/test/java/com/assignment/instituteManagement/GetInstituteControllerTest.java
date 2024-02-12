package com.assignment.instituteManagement;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import com.assignment.instituteManagement.controller.GetInstituteDetailsController;
import com.assignment.instituteManagement.dto.InstituteManagementDTO;
import com.assignment.instituteManagement.service.InstituteManagementService;

@RunWith(SpringRunner.class)
@WebMvcTest(GetInstituteDetailsController.class)
public class GetInstituteControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private InstituteManagementService instituteManagementService;
    @Test
    public void testGetInstituteDetails_Success() throws Exception {
        Integer instituteId = 1;
        InstituteManagementDTO expectedInstitute = new InstituteManagementDTO(); // Set expected details

        when(instituteManagementService.getInstituteById(instituteId)).thenReturn(expectedInstitute);

        MvcResult result = mockMvc.perform(get("/getInstituteDetails/{id}", instituteId)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();
        // Assert response content if needed
    }
}
