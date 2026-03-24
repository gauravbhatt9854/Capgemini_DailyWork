package com.gal.controller;

import com.gal.dto.TrainingDto;
import com.gal.model.Training;
import com.gal.service.TrainingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/training")
public class TrainingController {

    @Autowired
    private TrainingService trainingService;

    @GetMapping("/{id}")
    public ResponseEntity<TrainingDto> findById(@PathVariable Long id){
        return ResponseEntity.ok(new TrainingDto(trainingService.findById(id)));
    }

}
