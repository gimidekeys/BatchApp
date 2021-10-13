package com.example.BatchApp.Service;


import com.example.BatchApp.Model.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Optional;


@Component
public class BatchLoaderService {

    private CountryService countryService;

    @Autowired
    public BatchLoaderService(CountryService countryService) {
        this.countryService = countryService;
    }

    //method parsing csv file into list of string arrays (every string array contains values of a fields in line)
    public ArrayList<String[]> lineBylineFromCsv(String directory) throws IOException {

        ArrayList<String[]> lineBylineData = new ArrayList<>();
        String row;
        String[] data;

        BufferedReader csvReader = new BufferedReader(new FileReader(directory));
        while ((row = csvReader.readLine()) != null) {
         data  = row.split(",");
         lineBylineData.add(data);
        }
        csvReader.close();


        return lineBylineData;
    }

    //method parsing String Array (csv line) into Country object
    public Country parseStringArrayIntoCountryObject (String[] dataLine){

        Country country = new Country(dataLine[0],dataLine[1], dataLine[2], dataLine[3]);

        return  country;
    }

    //method parsing ArrayList of String arrays into List of Country objects
    public ArrayList<Country> parseCsvToListOfCountries(String directory ) throws IOException {
        ArrayList<String[]>lineBylineData= lineBylineFromCsv(directory);

        Country country;
        ArrayList<Country> countries = new ArrayList<>();

        for (String [] dataArray: lineBylineData) {

            country  = parseStringArrayIntoCountryObject(dataArray);
            countries.add(country);
        }

        return countries;
    }

    public  void  batchLoad(String directory) throws IOException {

        ArrayList<Country> countries = parseCsvToListOfCountries(directory);
       Optional<Country> referenceCountry;


        for (Country country: countries) {

            countryService.save(country);

        }

    }



}
