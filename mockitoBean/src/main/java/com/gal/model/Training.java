package com.gal.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class Training {
    @SequenceGenerator(name = "training_seq", allocationSize = 1, initialValue = 1)
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "training_seq")
    private long id;

    private Date startDate;
    private Date endDate;
    private String topic;
    private String trainerName;

    public Training(Long id ,Date endDate, Date startDate, String topic, String trainerName) {
        this.id = id;
        this.endDate = endDate;
        this.startDate = startDate;
        this.topic = topic;
        this.trainerName = trainerName;
    }
}
