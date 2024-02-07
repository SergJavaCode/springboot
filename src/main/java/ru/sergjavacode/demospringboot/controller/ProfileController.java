package ru.sergjavacode.demospringboot.controller;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.sergjavacode.demospringboot.SystemProfile;
import ru.sergjavacode.demospringboot.domain.Person;

import java.io.IOException;

@RestController
@RequestMapping("/")
public class ProfileController {
    private SystemProfile profile;

    public ProfileController(SystemProfile profile) {
        this.profile = profile;
    }

//    @GetMapping("/error")
//    private String error() {
//        System.out.println("Logic");
//        throw new ResponseStatusException(HttpStatus.I_AM_A_TEAPOT, "ResponseStatusException");
//    }

    @PostMapping("/hello")
    private String helloPost(@RequestBody @Validated Person quest) {
        return String.format("Hello from name = %s", quest.toString());
    }

    @GetMapping("/hello")
    private String helloGet(@RequestParam("name") String name) {
        return String.format("Hello from name = %s", name);
    }

    @GetMapping("/helloobj")
    private String helloGetObj(Person quest) {
        return String.format("Hello from name = %s", quest.toString());
    }

    @GetMapping("/profile")
    public String getProfile() throws IOException {
        return profile.getProfile();
    }
}