package com.example.herobook;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HeroBookRepository extends JpaRepository<HeroEntity, Long> {


}
