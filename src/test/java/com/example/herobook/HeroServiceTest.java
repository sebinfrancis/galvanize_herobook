package com.example.herobook;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class HeroServiceTest {

    @Mock
    HeroBookRepository mockRepository;

    @InjectMocks
    HeroService subject;

    @Test
    void create(){
    HeroDto heroDto = new HeroDto("Superman", "Flying");
    subject.create(heroDto);
    verify(mockRepository).save(
            new HeroEntity("Superman", "Flying")
    );

}
}
