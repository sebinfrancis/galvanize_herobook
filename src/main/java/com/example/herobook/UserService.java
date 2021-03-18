package com.example.herobook;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {
    private final UserRepository repository;

    @Autowired
    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public void create(UserDto userDto) {
        this.repository.save(
                new UserEntity(userDto.getName() , userDto.getRole())
        );
    }

    public List<UserDto> fetchAll() {
        return repository.findAll()
                .stream()
                .map(userEntity -> {
                    return new UserDto(userEntity.getName(), userEntity.getRole());
                })
                .collect(Collectors.toList());
    }
}
