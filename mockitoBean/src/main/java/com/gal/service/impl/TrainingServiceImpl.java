package com.gal.service.impl;
import com.gal.model.Training;
import com.gal.service.TrainingService;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@NoArgsConstructor
@Data
public class TrainingServiceImpl implements TrainingService {
    @Override
    public List<Training> findByTopic(String topic) {
        return List.of();
    }

    @Override
    public Training findById(Long id) {
        return null;
    }

    @Override
    public Training addTraining(Training training) {
        return null;
    }

    @Override
    public Training updateTraining(Training training) {
        return null;
    }

    @Override
    public boolean deleteTraining(Long id) {
        return false;
    }
}
