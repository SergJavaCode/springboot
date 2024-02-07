package ru.sergjavacode.demospringboot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/another")
public class AnotherBrokenController {

    @GetMapping("/iae")
    private String throwException() {
        throw new IllegalArgumentException("IllegalArgumentException");

    }
}
