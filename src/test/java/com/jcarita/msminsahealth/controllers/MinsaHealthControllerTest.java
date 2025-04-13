package com.jcarita.msminsahealth.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jcarita.msminsahealth.services.IHealthFacilitiesService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Collections;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(MinsaHealthController.class)
public class MinsaHealthControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private IHealthFacilitiesService facilitiesService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void shouldReturnOkWhenGetAll() throws Exception {
        when(facilitiesService.getAll()).thenReturn(Collections.emptyList());

        mockMvc.perform(get("/v1/minsa-health"))
                .andExpect(status().isOk());
    }
}
