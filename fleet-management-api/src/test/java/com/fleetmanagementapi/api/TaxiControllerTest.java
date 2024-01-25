package com.fleetmanagementapi.api;

import com.fleetmanagementapi.api.model.entities.Taxi;
import com.fleetmanagementapi.api.model.repository.TaxiRepositoryJPA;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class TaxiControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private TaxiRepositoryJPA taxiRepositoryJPA;

    @Test
    @DisplayName("Test DB")
    void contextLoads() throws Exception {
        List<Taxi> list = new ArrayList<>();
        list.add(new Taxi());
        Page<Taxi> page = new PageImpl<Taxi>(list, PageRequest.of(1,1),1);
        when(taxiRepositoryJPA.findAll(PageRequest.of(1,1))).thenReturn(page);
        mockMvc.perform(get("/api/v1/taxis?size=1&nroPage=1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.content").isArray());
    }
}
