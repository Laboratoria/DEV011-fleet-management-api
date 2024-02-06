package com.fleetmanagementapi.api;

import com.fleetmanagementapi.api.model.repository.TaxiRepositoryJPA;
import com.fleetmanagementapi.api.model.repository.TrajectoryRepository;
import com.fleetmanagementapi.api.services.impl.TaxiImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.platform.engine.TestExecutionResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class Dev011FleetManagementApiApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private TaxiRepositoryJPA taxiRepositoryJPA;

	@Test
	@DisplayName("Test Endpoint Taxi")
	void contextLoads() throws Exception {
		mockMvc.perform(get("/api/v1/taxis?size=6418&nroPage=0")).andExpect(status().isOk()).andExpect(jsonPath("$.content").isArray());
	}

	@Autowired
	private TrajectoryRepository trajectoryRepository;

	@Test
	@DisplayName("Test Endpoint Trajectory")
	void contentLoads() throws  Exception{
		mockMvc.perform(get("/api/v1/trajectories?taxiId=6418&date=2008-02-02&page=0&size=2")).andExpect((status().isOk())).andExpect(jsonPath("$.content").isArray());
	}


	//investigar por que da error al usar .isArray
	@Test
	@DisplayName("Test Endpoint LastTrajectory")
	void contentLoads2() throws  Exception{
		mockMvc.perform(get("/api/v1/lasttrajectory?taxiId=6418&page=0&size=2")).andExpect((status().isOk()));
	}





}
