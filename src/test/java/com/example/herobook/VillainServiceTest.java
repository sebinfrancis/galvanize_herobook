package com.example.herobook;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;

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
    }
}
