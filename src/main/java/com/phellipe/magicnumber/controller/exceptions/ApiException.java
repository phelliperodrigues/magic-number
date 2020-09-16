package com.phellipe.magicnumber.controller.exceptions;

import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Getter
public class ApiException {

    private HttpStatus status;
    private String message;
    private List<String> errors;

    public ApiException(HttpStatus status, String message, List<String> errors) {
        super();
        this.status = status;
        this.message = message;
        this.errors = errors;
    }

    public ApiException(HttpStatus status, String message, String error) {
        super();
        this.status = status;
        this.message = message;
        errors = Arrays.asList(error);
    }

    public ApiException(ValidationException ex) {
        this.errors = Arrays.asList(ex.getMessage());
    }
}
