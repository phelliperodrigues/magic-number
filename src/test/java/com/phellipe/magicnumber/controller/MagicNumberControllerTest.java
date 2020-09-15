package com.phellipe.magicnumber.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.phellipe.magicnumber.service.MagicNumberService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = MagicNumberController.class)
@AutoConfigureMockMvc
public class MagicNumberControllerTest {

    private static final String API = "/api/magicnumber";

    @Autowired
    MockMvc mvc;

    @MockBean
    MagicNumberService service;

    ObjectMapper mapper = new ObjectMapper();

    @Test
    @DisplayName("Should return count of magic number")
    public void count() throws Exception {
        Assertions.fail();
    }

    @Test
    @DisplayName("Should return exception of magic number invalid")
    public void invalidNumbers() throws Exception {
        Assertions.fail();
    }


    @Test
    @DisplayName("Should return exception of  number A greater number B")
    public void numberAGreaterNumberB() throws Exception {
        Assertions.fail();
    }


    @Test
    @DisplayName("Should return exception of  numbers less 0")
    public void showExceptionNumbersNegative() throws Exception {
        Assertions.fail();
    }

}
