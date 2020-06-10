package com.codeclan.example.WhiskyTracker.controllers;

import com.codeclan.example.WhiskyTracker.models.Distillery;
import com.codeclan.example.WhiskyTracker.models.Whisky;
import com.codeclan.example.WhiskyTracker.repositories.WhiskyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
//@RequestMapping(value = "/whiskies")
public class WhiskyController {

    @Autowired private WhiskyRepository whiskyRepository;

    @GetMapping(value ="/whiskies")
    public ResponseEntity<List<Whisky>> GetWhiskyAllAndByYear(
            @RequestParam(name="year", required = false) Integer year,
            @RequestParam(name="distillery_id", required = false) Long distillery_id,
            @RequestParam(name="age",required = false) Integer age,
            @RequestParam(name="region", required = false) String region
    ) {
        if (year != null){
            return new ResponseEntity<>(whiskyRepository.findByYear(year),HttpStatus.OK);
        }
        if (distillery_id != null && age != null){
            return new ResponseEntity<>(whiskyRepository.findWhiskyByDistilleryIdAndAge(distillery_id,age),HttpStatus.OK);
        }
        if (distillery_id != null){
            return new ResponseEntity<>(whiskyRepository.findWhiskyByDistilleryId(distillery_id), HttpStatus.OK);
        }
        if (region != null){
            return new ResponseEntity<>(whiskyRepository.findWhiskyByDistilleryRegionIgnoreCase(region),HttpStatus.OK);
        }

        return new ResponseEntity<>(whiskyRepository.findAll(), HttpStatus.OK);
    }



}
