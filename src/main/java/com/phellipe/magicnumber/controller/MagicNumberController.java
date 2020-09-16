package com.phellipe.magicnumber.controller;

import com.phellipe.magicnumber.controller.dto.MagicNumber;
import com.phellipe.magicnumber.model.Number;
import com.phellipe.magicnumber.service.MagicNumberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/magicnumber")
public class MagicNumberController {

    final
    MagicNumberService service;

    public MagicNumberController(MagicNumberService service) {
        this.service = service;
    }

    @PostMapping
    public MagicNumber count(@RequestBody List<Number> numbers) {
        int count = service.countMagicNumber(numbers);

        return MagicNumber.builder().count(count).build();
    }
}
