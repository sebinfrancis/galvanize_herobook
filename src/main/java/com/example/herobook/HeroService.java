package com.example.herobook;

import org.springframework.stereotype.Service;

@Service
public class HeroService {
    private final HeroBookRepository repository;

    HeroService(HeroBookRepository repository){
        this.repository = repository;

    }
    public void create(HeroDto heroDto){
        repository.save(
                new HeroEntity(heroDto.getName(),heroDto.getSuper_power() )
        );

    }
}
