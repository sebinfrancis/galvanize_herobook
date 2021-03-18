package com.example.herobook;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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

    public List<VillainDto> fetchAll() {
        return this.repository.findAll()
                .stream()
                .map(villainEntity -> {
                    return new VillainDto(villainEntity.getName(), villainEntity.getSpecial_power());
                })
                .collect(Collectors.toList());
    }
}
