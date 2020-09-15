package com.phellipe.magicnumber.service;

import com.phellipe.magicnumber.model.Number;
import com.phellipe.magicnumber.service.impl.MagicNumberServiceImp;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
public class MagicNumberServiceTest {

    MagicNumberService service;

    @BeforeEach
    public void setUp() {
        this.service = new MagicNumberServiceImp();
    }

    @Test
    @DisplayName("Should return count of magic number")
    public void countMagicNumber(){
        Number number1 = Number.builder().numberA(8).numberB(27).build();
        Number number2 = Number.builder().numberA(49).numberB(49).build();

        List<Number> numbers = new ArrayList<>();

        numbers.addAll(Arrays.asList(number1, number2));

        int count = service.countMagicNumber(numbers);

        assertEquals(3, count);

    }




}
