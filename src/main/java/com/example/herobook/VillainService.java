package com.example.herobook;

import org.springframework.stereotype.Service;

@Service
public class VillainService {
    private final VillainRepository repository;

    VillainService(VillainRepository repository) {
        this.repository = repository;
    }

    public void create(VillainDto villainDto) {
        this.repository.save(
                new VillainEntity(villainDto.getName(), villainDto.getSpecial_power())
        );
    }
}
