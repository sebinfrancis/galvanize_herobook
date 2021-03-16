package com.example.herobook;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class HeroBookController {
    HeroService heroService;

    HeroBookController(HeroService heroService) {
        this.heroService = heroService;
    }
    @PostMapping("/heroes")
    @ResponseStatus(HttpStatus.CREATED)
    public void addHero(@RequestBody HeroDto heroDto) {
       heroService.create(heroDto);
    }

    @GetMapping("/heroes")
    public List<HeroDto> getHeroes()
    {
        return heroService.fetchAll();
    }


}
