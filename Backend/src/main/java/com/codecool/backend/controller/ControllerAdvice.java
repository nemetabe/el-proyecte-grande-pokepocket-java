package com.codecool.backend.controller;

import com.codecool.backend.controller.exception.PokemonNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@org.springframework.web.bind.annotation.ControllerAdvice
public class ControllerAdvice {
    @ResponseBody
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @ExceptionHandler(PokemonNotFoundException.class)
    public String illegalRequestParameterExceptionHandler(PokemonNotFoundException exception) {
        return exception.getMessage();
    }
}
