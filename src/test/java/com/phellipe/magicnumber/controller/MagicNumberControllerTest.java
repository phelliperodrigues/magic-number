package com.phellipe.magicnumber.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.phellipe.magicnumber.controller.dto.MagicNumber;
import com.phellipe.magicnumber.controller.exceptions.ValidationException;
import com.phellipe.magicnumber.model.Number;
import com.phellipe.magicnumber.service.MagicNumberService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.BDDMockito.given;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

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
        List<Number> numbers = createNumbersValid();
        MagicNumber magicNumber = MagicNumber.builder().count(3).build();
        given(service.countMagicNumber(Mockito.any(List.class))).willReturn(magicNumber.getCount());

        String json = mapper.writeValueAsString(numbers);

        MockHttpServletRequestBuilder request =
                post(API)
                        .contentType(APPLICATION_JSON)
                        .accept(APPLICATION_JSON)
                        .content(json);

        mvc
                .perform(request)
                .andExpect( status().isOk() )
                .andExpect( jsonPath("count").value(3) );
    }



    @Test
    @DisplayName("Should return exception of magic number invalid")
    public void invalidNumbers() throws Exception {
        String json = mapper.writeValueAsString(Arrays.asList(new Number()));

        MockHttpServletRequestBuilder request = post(API)
                .contentType(APPLICATION_JSON)
                .accept(APPLICATION_JSON)
                .content(json);

        mvc.perform(request)
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("errors", hasSize(2)));
    }


    @Test
    @DisplayName("Should return exception of  number A greater number B")
    public void numberAGreaterNumberB() throws Exception {
        Number number = Number.builder().numberA(15).numberB(8).build();
        var mensagemErro = "Number A cannot be less than Number B";
        String json = mapper.writeValueAsString(Arrays.asList(number));
        given(service.countMagicNumber(Mockito.any(List.class)))
                .willThrow(new ValidationException(mensagemErro));

        MockHttpServletRequestBuilder request = post(API)
                .contentType(APPLICATION_JSON)
                .accept(APPLICATION_JSON)
                .content(json);

        mvc.perform(request)
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("errors", hasSize(1)))
                .andExpect(jsonPath("errors[0]").value(mensagemErro));

    }


    @Test
    @DisplayName("Should return exception of  numbers less 0")
    public void showExceptionNumbersNegative() throws Exception {
        String json = mapper.writeValueAsString(Arrays.asList(Number.builder().numberA(-5).numberB(10).build()));

        MockHttpServletRequestBuilder request = post(API)
                .contentType(APPLICATION_JSON)
                .accept(APPLICATION_JSON)
                .content(json);

        mvc.perform(request)
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("errors", hasSize(1)));
    }

    private List<Number> createNumbersValid() {

        Number number1 = Number.builder().numberA(8).numberB(27).build();
        Number number2 = Number.builder().numberA(49).numberB(49).build();

        List<Number> numbers = new ArrayList<>();

        numbers.addAll(Arrays.asList(number1, number2));

        return numbers;
    }

}
