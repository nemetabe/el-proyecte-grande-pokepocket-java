package com.codecool.backend.controller;

import com.codecool.backend.controller.exception.PokemonNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ExceptionHandler {
    @ResponseBody
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @org.springframework.web.bind.annotation.ExceptionHandler(PokemonNotFoundException.class)
    public String illegalRequestParameterExceptionHandler(PokemonNotFoundException exception) {
        return exception.getMessage();
    }
}
