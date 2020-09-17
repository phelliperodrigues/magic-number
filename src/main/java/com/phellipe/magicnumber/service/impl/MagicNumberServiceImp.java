package com.phellipe.magicnumber.service.impl;

import com.phellipe.magicnumber.controller.exceptions.ValidationException;
import com.phellipe.magicnumber.model.Number;
import com.phellipe.magicnumber.service.MagicNumberService;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

@Service
public class MagicNumberServiceImp implements MagicNumberService {

    @Override
    public int countMagicNumber(List<Number> numbers){
        AtomicInteger count = new AtomicInteger();
        
        numbers.forEach(number -> {
            number.validation();
            for (int i = number.getNumberA(); i <= number.getNumberB() ; i++) {
                if (isMagicNumber(i))
                    count.getAndIncrement();
            }
        });

        return count.get();
    }

    private boolean isMagicNumber(int number) {
        return isSquareRoot(number) && isPrime((int) Math.sqrt(number));
    }

    private boolean isPrime(int number) {
        return IntStream.rangeClosed(2, number/2).noneMatch(i -> number%i == 0);
    }

    private boolean isSquareRoot(int number){
        double squareRoot = Math.sqrt(number);
        return ((squareRoot - Math.floor(squareRoot)) == 0);
    }

}
