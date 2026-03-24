package com.gal.service;
import com.gal.model.Training;
import org.springframework.stereotype.Service;

import java.util.List;


public interface TrainingService {
    List<Training> findByTopic(String topic);
    Training findById(Long id);
    Training addTraining(Training training);
    Training updateTraining(Training training);
    boolean deleteTraining(Long id);

}
