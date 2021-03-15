package com.example.herobook;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class HeroBookController {
    ArrayList<HeroDto> heroDtos;

    HeroBookController() {
        heroDtos = new ArrayList<>();
    }
    @PostMapping("/heroes")
    @ResponseStatus(HttpStatus.CREATED)
    public void addHero(@RequestBody HeroDto heroDto) {
        heroDtos.add(heroDto);
    }

    @GetMapping("/heroes")
    public ArrayList<HeroDto> getHeroes()
    {
        return heroDtos;
    }


}
