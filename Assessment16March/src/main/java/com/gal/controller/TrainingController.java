package com.gal.controller;


import com.gal.model.Training;
import com.gal.services.TrainingService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TrainingController {

//    slf4j -> simple logging framworkj

    private static final Logger log = LoggerFactory.getLogger("com.gal.controller");
//    private static  final  Logger log = LoggerFactory.getLogger(TrainingController.class);

    @Autowired
    TrainingService trainingService;


    @GetMapping("/trainings")
    public ResponseEntity<List<Training>> findCurrentAndUpcomingTrainings()
    {
        log.debug("request for findCurrentAndUpcomingTrainings");
        return ResponseEntity.ok(trainingService.findCurrentAndUpcomingTrainings());
    }

    @GetMapping("/training")
    public ResponseEntity<List<Training>> findCurrentAndUpcomingTrainingsWithSpecifiedTopic(@RequestParam("name") String name)
    {
        log.debug("request for findCurrentAndUpcomingTrainingsWithSpecifiedTopic");
        return ResponseEntity.ok(trainingService.findCurrentAndUpcomingTrainingsWithSpecifiedTopic(name));
    }

    @GetMapping("/trainings/upcoming")
    public ResponseEntity<List<Training>> findUpcomingTrainingsWithSpecifiedTopic(@RequestParam("name") String name)
    {
        log.debug("request for findUpcomingTrainingsWithSpecifiedTopic");
        return ResponseEntity.ok(trainingService.findUpcomingTrainingsWithSpecifiedTopic(name));
    }

    @GetMapping("/alldept")
    public ResponseEntity<List<Training>> getAllDept()
    {
        log.debug("request for getAllDept");
        return ResponseEntity.ok(trainingService.getAllDept());
    }

    @GetMapping("/test")
    public ResponseEntity<List<Training>> findByTrainerName(@RequestParam("name") String name)
    {
        List<Training> list = trainingService.findByTrainerName(name);
        log.debug(list.get(0).getVenue());
        return ResponseEntity.ok(list);
    }
}
