package com.example.BatchApp;

import com.example.BatchApp.Model.Country;
import com.example.BatchApp.Service.BatchLoaderService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

@SpringBootTest
class BatchAppApplicationTests {

	private BatchLoaderService batchLoaderService;




	//Test checking the method parsing csv into ArrayList of String arrays.
	@Test
	void contextLoads() throws IOException {

		ArrayList<String[]> lineByLineData = batchLoaderService.lineBylineFromCsv("C:/Users/wokamins/Desktop/countries.csv");

		for (String[] dataLine: lineByLineData ) {

			System.out.println(Arrays.toString(dataLine));

		}

	}

	@Test
	void dataLineIntoCountryObject() throws IOException {

		ArrayList<Country> countries = batchLoaderService.parseCsvToListOfCountries("C:/Users/wokamins/Desktop/countries.csv");

		for (Country country: countries) {

			System.out.println(country.toString());

		}



	}

}
