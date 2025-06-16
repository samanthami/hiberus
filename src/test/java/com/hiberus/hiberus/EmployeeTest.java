package com.hiberus.hiberus;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hiberus.hiberus.model.Employee;
import com.hiberus.hiberus.service.EmployeeService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;

import java.math.BigDecimal;
import java.util.Map;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class EmployeeTest {

    @Autowired
    private MockMvc mockMvc;
    @MockitoBean
    private EmployeeService employeeService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void testCreateEmployee() throws Exception {
        mockMvc.perform(null);
    }

    @Test
    void testMaxSalaryEmployee() throws Exception {
        Employee employee = Employee.builder().employeeName("Juan").employeeLastName("Perez").age(25).salary(BigDecimal.valueOf(45,9)).build();
        when(employeeService.getEmployeeMaxSalary()).thenReturn(employee);

        mockMvc.perform(get("/employee/highestSalary"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.Juan").value(10000))
                .andExpect(jsonPath("$.Maria").value(20000));
    }


    @Test
    void testLowerAgeEmployee() throws Exception {
        Employee employee = Employee.builder().employeeName("Juan").employeeLastName("Perez").age(25).salary(BigDecimal.valueOf(45,9)).build();
        when(employeeService.getEmployeeMinAge()).thenReturn(employee);

        mockMvc.perform(get("/employee/lowerAge"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.Juan").value(25))
                .andExpect(jsonPath("$.Maria").value(30));
    }

    @Test
    void testCountLastMonthEmployee() throws Exception {
        when(employeeService.numberOfEmployeeLastMonth()).thenReturn(1);
        mockMvc.perform(get("/employee/countLastMonth"))
                .andExpect(status().isOk())
                .andExpect(content().string("1"));
    }

    @Test
    void deleteEmployee() throws Exception {
        int employeeId = 1;
        doNothing().when(employeeService).dismissEmployee(employeeId);

        mockMvc.perform(post("/employee/delete/" + employeeId))
                .andExpect(status().isOk());
    }

    @Test
    void createEmployee() throws Exception{
        Employee employee = Employee.builder().employeeName("Juan").employeeLastName("Perez").age(25).salary(BigDecimal.valueOf(45,9)).build();
        int departmentId = 1;
        doNothing().when(employeeService).createEmployee(employee, departmentId);

        mockMvc.perform(post("/employee/create/{departmentId}", departmentId)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(employee)))
                .andExpect(status().isOk());

    }
}
