package com.example.BatchApp.Repo;


import com.example.BatchApp.Model.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CountryRepository extends JpaRepository<Country, Long> {

    Optional<Country > findByAlphaTwoCode(String alphaTwoCode);



}
