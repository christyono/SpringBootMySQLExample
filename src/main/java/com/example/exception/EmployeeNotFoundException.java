package com.example.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class EmployeeNotFoundException extends RuntimeException {
    private String id;
    private Object value;

    public EmployeeNotFoundException( String id, Object value) {
        super(String.format("Employee not found with %s : '%s'", id, value));
        this.id = id;
        this.value = value;
    }

    public String getId() {
        return id;
    }

    public Object getValue() {
        return value;
    }
}