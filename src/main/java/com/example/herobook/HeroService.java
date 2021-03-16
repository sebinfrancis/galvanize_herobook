package com.example.herobook;

import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

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

    public List<HeroDto> fetchAll() {
        return repository.findAll()
                .stream()
                .map(heroEntity -> {
                    return new HeroDto(heroEntity.getName(), heroEntity.getSuper_power());
                })
                .collect(Collectors.toList());
    }
}
