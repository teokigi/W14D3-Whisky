package com.codeclan.example.WhiskyTracker.controllers;

import com.codeclan.example.WhiskyTracker.models.Whisky;
import com.codeclan.example.WhiskyTracker.repositories.WhiskyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
//@RequestMapping(value = "/whiskies")
public class WhiskyController {

    @Autowired private WhiskyRepository whiskyRepository;

    @GetMapping(value ="/whiskies")
    public ResponseEntity<List<Whisky>> GetWhiskyAllAndByYear(
            @RequestParam(name="year", required = false) String year
    ) {
        if (year != null){
            return new ResponseEntity<>(whiskyRepository.findByYearIgnoreCase(year),HttpStatus.OK);
        }

        return new ResponseEntity<>(whiskyRepository.findAll(), HttpStatus.OK);
    }


}
