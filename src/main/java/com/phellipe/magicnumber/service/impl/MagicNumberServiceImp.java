package com.phellipe.magicnumber.service.impl;

import com.phellipe.magicnumber.model.Number;
import com.phellipe.magicnumber.service.MagicNumberService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MagicNumberServiceImp implements MagicNumberService {
    @Override
    public int countMagicNumber(List<Number> numbers) {
        return 0;
    }
}
