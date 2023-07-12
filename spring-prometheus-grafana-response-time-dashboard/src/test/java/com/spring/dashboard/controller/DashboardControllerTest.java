package com.spring.dashboard.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
public class DashboardControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testNormalService() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/v1/dashboard/normal-service"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("normal-service-ok"))
                .andDo(print());
    }

    @Test
    public void testSlowService() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/v1/dashboard/slow-service"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("slow-service-ok"))
                .andDo(print());
    }

    @Test
    public void testVerySlowService() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/v1/dashboard/too-slow-service"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("too-slow-service-ok"))
                .andDo(print());
    }
}
