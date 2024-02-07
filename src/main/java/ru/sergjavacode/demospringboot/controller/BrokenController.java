package ru.sergjavacode.demospringboot.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import ru.sergjavacode.demospringboot.domain.Person;

@RestController
@RequestMapping("/error")
public class BrokenController {
    @GetMapping("/{id}")
    private Person getPersonById(@PathVariable("id") long id) {
        try {
            throw new IllegalArgumentException("IllegalArgumentException");
        } catch (RuntimeException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "ResponseStatusException", e);
        }
    }

    @GetMapping("/iae")
    private Person throwException() {
        throw new IllegalArgumentException("IllegalArgumentException");

    }


}
