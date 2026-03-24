package com.gal.controller;

import com.gal.dto.TrainingDto;
import com.gal.model.Training;
import com.gal.service.TrainingService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import static org.mockito.Mockito.when;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import java.sql.Date;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

//@SpringBootTest  // this will run the project and you can use httpClient library

@WebMvcTest(TrainingController.class) // if anything autowired add mocking


class TrainingControllerTest {

    @MockitoBean
    TrainingService trainingService;

    @Autowired
    MockMvc mockMvc;

    @Test
    void findById() throws Exception{
        Training training = new Training(
                101L,
                Date.valueOf("2025-10-1"),
                Date.valueOf("2026-1-1"),
                "Mockito" ,
                "Dinesh Kumar");

        when(trainingService.findById(101L)).thenReturn(training);

        mockMvc.perform(get("/training/101")
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(result -> System.out.println(result.getResponse().getContentAsString()))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value("101"));
    }
}