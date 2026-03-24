package com.gal.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
public class Employee {
    @SequenceGenerator(name = "employee_sequence" , initialValue = 1 , allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE , generator = "employee_sequence")
    @Id
    private Long id;

    private String name;
    private String email;
    private Date birthDate;


    @JsonIgnore(value = true)
    @OneToMany(mappedBy = "employee" , cascade = CascadeType.ALL)
    List<Issue> issues = new ArrayList<>();

}
