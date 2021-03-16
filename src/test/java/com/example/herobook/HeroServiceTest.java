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

    @Test
    void fetchAllTest() {
        when(mockRepository.findAll()).thenReturn(
                List.of(
                        new HeroEntity("Superman", "Flying"),
                        new HeroEntity("Batman", "Jumping")
        ));

        List<HeroDto> heroDtos =subject.fetchAll();

        assertThat(heroDtos).isEqualTo(
                List.of(
                        new HeroDto("Superman", "Flying"),
                        new HeroDto("Batman", "Jumping")
                )
        );
    }
}
