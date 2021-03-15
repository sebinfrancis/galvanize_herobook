package com.example.herobook;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class HeroDto {
    String name;
    String super_power;
}
