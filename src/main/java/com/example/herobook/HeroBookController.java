package com.example.herobook;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    @GetMapping("/heroes/{name}")
    public ResponseEntity<HeroDto> getHeroStats(@PathVariable("name") String name)
    {
        if (name==null)
        {return new ResponseEntity(HttpStatus.BAD_REQUEST); }
        else {
            List<HeroDto> heroDtos = heroService.fetchAll();
            for (int i = 0; i < heroDtos.size(); i++) {
                if (heroDtos.get(i).getName().equals(name)) {
                    return new ResponseEntity<>(heroDtos.get(i), HttpStatus.OK);
                }
            }
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }}
}
