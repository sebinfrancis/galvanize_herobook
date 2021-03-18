package com.example.herobook;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class VillainServiceTest {
    @Mock
    VillainRepository mockRepository;

    @InjectMocks
    VillainService subject;

    @Test
    void create() {
        VillainDto dto = new VillainDto("Thanos", "cosmic power");
        subject.create(dto);
        verify(mockRepository).save(
                new VillainEntity("Thanos", "cosmic power")
        );
    }

    @Test
    void fetchAllTest() {
        when(mockRepository.findAll()).thenReturn(
                List.of(
                        new VillainEntity("Thanos", "cosmic power"),
                        new VillainEntity("Loki", "teleportation")
                )
        );

        List<VillainDto> villainDtos = subject.fetchAll();
        assertThat(villainDtos).isEqualTo(
                List.of(
                        new VillainDto("Thanos", "cosmic power"),
                        new VillainDto("Loki", "teleportation")
                )
        );

    }
}
