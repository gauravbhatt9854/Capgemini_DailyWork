package com.gal.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.sql.Date;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Data
@Setter
public class Department {
    @SequenceGenerator(name = "department_seq", allocationSize = 1, initialValue = 1)
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "department_seq")
    private long id;
    private String name;

    @Future(message = "it is future date")
    @NotNull(message = "date cannot be null")
    private Date establishDate;
}
