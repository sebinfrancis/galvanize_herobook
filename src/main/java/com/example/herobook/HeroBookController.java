package com.example.herobook;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class HeroBookController {
    HeroService heroService;
    VillainService villainService;

    HeroBookController(HeroService heroService,VillainService villainService ) {
        this.heroService = heroService;
        this.villainService = villainService;
        //villainDtos = new ArrayList<>();
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
        if (name != null) {
            List<HeroDto> heroDtos = heroService.fetchAll();
            for (int i = 0; i < heroDtos.size(); i++) {
                if (heroDtos.get(i).getName().equals(name)) {
                    return new ResponseEntity<>(heroDtos.get(i), HttpStatus.OK);
                }
            }

        }
        return new ResponseEntity(HttpStatus.NOT_FOUND);
    }


    @PostMapping("/villains")
    @ResponseStatus(HttpStatus.CREATED)
    public void addVillain(@RequestBody VillainDto villainDto) {
        //this.villainDtos.add(villainDto);
        this.villainService.create(villainDto);
    }

    @GetMapping("/villains")
    public List<VillainDto> getVillains()
    {
        //return this.villainDtos;
        return villainService.fetchAll();
    }
}
