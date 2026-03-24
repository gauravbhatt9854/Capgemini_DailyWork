package com.gal.api;

import lombok.Data;

@Data
public class DepartmentNotFoundException extends RuntimeException{
    private String message;

    public DepartmentNotFoundException(String message)
    {
        super(message);
        this.message = message;
    }

}
