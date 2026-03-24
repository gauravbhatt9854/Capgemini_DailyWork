package com.gal.api;
import com.gal.controller.DepartmentController;
import com.gal.model.Department;
import com.gal.service.DepartmentService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import java.sql.Date;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(DepartmentController.class)
public class DepartmentControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private DepartmentService departmentService;

    @Test
    void testGetDepartment() throws Exception {
        Department department = new Department(
                1L, "HR" , Date.valueOf("2027-01-04")
        );

        when(departmentService.getDeptById(1)).thenReturn(department);
        when(departmentService.getDeptById(2)).thenThrow(new DepartmentNotFoundException("id not found"));



        mockMvc.perform(get("/department?id=1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo((x)-> System.out.println(x.getResponse().getContentAsString()))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("HR"));

//        mockMvc.perform(get("/department?id=2")
//                        .contentType(MediaType.APPLICATION_JSON))
//                .andExpect(status().isNotFound())
//                .andExpect(jsonPath("$.message").exists());

    }
}