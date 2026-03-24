package com.gal.dto;
import com.gal.model.Training;
import lombok.Data;

import java.sql.Date;

@Data
public class TrainingDto {
    private long id;
    private Date startDate;
    private Date endDate;
    private String topic;

    public TrainingDto(Training training) {
        this.id = training.getId();
        this.endDate = training.getEndDate();
        this.startDate = training.getStartDate();
        this.topic = training.getTopic();
    }
}

