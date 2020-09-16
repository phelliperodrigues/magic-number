package com.phellipe.magicnumber.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.MethodArgumentNotValidException;

import javax.validation.ConstraintViolationException;
import javax.validation.Valid;
import javax.validation.ValidationException;
import javax.validation.constraints.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Number {

    @NotNull
    @Positive
    private Integer numberA;

    @NotNull
    @Positive
    private Integer numberB;


   public void validation(){

       if (this.numberA > this.numberB){
            throw new ValidationException("Number A cannot be less than Number B");
       }
   }
}
