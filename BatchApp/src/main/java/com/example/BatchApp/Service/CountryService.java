package com.example.BatchApp.Service;

import com.example.BatchApp.Model.Country;
import com.example.BatchApp.Repo.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CountryService {
    private final CountryRepository countryRepository;

    @Autowired
    public CountryService(CountryRepository countryRepository) {

        this.countryRepository = countryRepository;

    }

    //method saving country object
    public void save(Country country){
        countryRepository.save(country);
    }

    //method returning object Country po alphaTwoCode
    public Optional<Country> findByAlphaTwoCode(String alphaTwoCode){

        return countryRepository.findByAlphaTwoCode(alphaTwoCode);
    }




    }
