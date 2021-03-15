package com.example.herobook;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HeroBookController {

    @PostMapping("/heroes")
    @ResponseStatus(HttpStatus.CREATED)
    public void addHero() {

    }


}
