package com.example.BatchApp;

import com.example.BatchApp.Service.BatchLoaderService;
import org.hibernate.engine.jdbc.batch.spi.Batch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class BatchAppApplication implements CommandLineRunner {


	@Autowired
	BatchLoaderService batchLoaderService;

	public static void main(String[] args) {
		SpringApplication.run(BatchAppApplication.class, args);


	}

	@Override
	public void run(String... args) throws Exception {
		batchLoaderService.batchLoad("C:\\Users\\wokamins\\Desktop\\countries.csv");
	}

}
