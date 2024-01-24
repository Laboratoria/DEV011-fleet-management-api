package com.fleetmanagementapi.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"com.fleetmanagementapi.api.services", "com.fleetmanagementapi.api.services.impl", "com.fleetmanagementapi.api.controllers"})
public class Dev011FleetManagementApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(Dev011FleetManagementApiApplication.class, args);
	}

}
