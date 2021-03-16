package com.example.herobook;

import org.springframework.data.jpa.repository.JpaRepository;

public interface HeroBookRepository extends JpaRepository<HeroEntity, Long> {


}
