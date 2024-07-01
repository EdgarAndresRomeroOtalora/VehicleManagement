package com.unow.vehicleManagement;

import com.unow.vehicleManagement.dao.DB;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class VehicleManagementApplication {

	public static void main(String[] args) {

		DB.createTables();
		SpringApplication.run(VehicleManagementApplication.class, args);
	}

}
