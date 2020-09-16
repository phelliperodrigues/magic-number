package com.phellipe.magicnumber.model;

import com.phellipe.magicnumber.controller.exceptions.ValidationException;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Number {

    @NotNull
    @Min(0)
    private Integer numberA;

    @NotNull
    @Min(0)
    private Integer numberB;


   public void validation(){
       if(this.numberA > this.numberB){
           throw new ValidationException("Number A cannot be less than Number B") ;
       };
   }
}
