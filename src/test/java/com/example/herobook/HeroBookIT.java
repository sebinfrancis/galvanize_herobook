package com.example.herobook;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class HeroBookIT {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    /*As a visitor, I can view all the heroes.
    When I view all the heros
    Then I can see names of all heros*/

    @Test
    public void addHeroTest() throws Exception {

        HeroDto hero = new HeroDto("superman", "flying");

        mockMvc.perform(post("/heroes")
                .content(objectMapper.writeValueAsString(hero)).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated()
        );

        mockMvc.perform(get("/heroes"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("length()").value(1))
                .andExpect(jsonPath("[0].name").value("superman"))
                .andExpect(jsonPath("[0].super_power").value("flying"));

    }

    //As a visitor, I can see information about any individual hero so that I can see their stats.

    @Test
    public void getHeroDetails() throws Exception {
        HeroDto hero = new HeroDto("batman", "jumping");

        mockMvc.perform(post("/heroes")
                .content(objectMapper.writeValueAsString(hero)).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated()
                );

        mockMvc.perform(get("/heroes/batman"))
                .andExpect(status().isOk())
               // .andExpect(jsonPath("length()").value(1))
                .andExpect(jsonPath("$.name").value("batman"))
                .andExpect(jsonPath("$.super_power").value("jumping"));

    }

}
