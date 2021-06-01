/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thales.thalestestrest.exceptionhandling;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * Manage errors
 * @author Yeison David Sanchez Legarda
 */
@ControllerAdvice
public class ExceptionHandlerImp {
    
    @ExceptionHandler
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    Error handleException(MangedException ex) {
        return createException(ex);
    }
    
    private Error createException(Exception ex) {
        Error error = new Error();
        error.setMessage(ex.getMessage());
        return error;
    } 
}
