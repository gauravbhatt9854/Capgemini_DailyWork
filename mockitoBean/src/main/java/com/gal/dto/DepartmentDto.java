package com.gal.dto;

import com.gal.model.Department;
import lombok.Data;

@Data
public class DepartmentDto {
    private long id;
    private String name;

    public DepartmentDto(Department department1) {
        this.id = department1.getId();
        this.name = department1.getName();
    }
}
