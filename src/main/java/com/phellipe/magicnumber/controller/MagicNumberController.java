package com.phellipe.magicnumber.controller;

import com.phellipe.magicnumber.controller.dto.MagicNumber;
import com.phellipe.magicnumber.controller.exceptions.ApiException;
import com.phellipe.magicnumber.model.Number;
import com.phellipe.magicnumber.service.MagicNumberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import java.util.ArrayList;
import java.util.List;

@Validated
@RestController
@RequestMapping("/api/magicnumber")
public class MagicNumberController {

    final
    MagicNumberService service;

    public MagicNumberController(MagicNumberService service) {
        this.service = service;
    }

    @PostMapping
    public MagicNumber count(@RequestBody List<@Valid Number> numbers) {
        int count = service.countMagicNumber(numbers);

        return MagicNumber.builder().count(count).build();
    }


}
