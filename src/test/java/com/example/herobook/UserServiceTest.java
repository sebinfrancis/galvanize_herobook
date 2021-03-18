package com.example.herobook;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    @Mock
    UserRepository mockRepository;

    @InjectMocks
    UserService subject;

    @Test
    void create(){
        UserDto userDto = new UserDto("Steve", "visitor");
        subject.create(userDto);
        verify(mockRepository).save(
                new UserEntity("Steve", "visitor")
        );
    }

    @Test
    void fetchAllTest() {
        when(mockRepository.findAll()).thenReturn(
                List.of(
                        new UserEntity("Steve", "visitor"),
                        new UserEntity("Mike", "fan")
                ));

        List<UserDto> userDtos = subject.fetchAll();

        assertThat(userDtos).isEqualTo(
                List.of(
                        new UserDto("Steve", "visitor"),
                        new UserDto("Mike", "fan")
                )
        );
    }

    }
