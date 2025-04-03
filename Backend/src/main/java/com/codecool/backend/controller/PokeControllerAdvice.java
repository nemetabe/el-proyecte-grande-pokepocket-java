package com.codecool.backend.controller;

import com.codecool.backend.controller.exception.MemberNotFoundException;

import com.codecool.backend.controller.exception.TransactionNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


@RestControllerAdvice
public class PokeControllerAdvice {
    @ResponseBody
    @ExceptionHandler(MemberNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String memberNotFoundExceptionHandler(MemberNotFoundException ex) {
        return ex.getMessage();
    }

    @ResponseBody
    @ExceptionHandler(TransactionNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String transactionNotFoundExceptionHandler(TransactionNotFoundException ex) {
        return ex.getMessage();
    }
}
