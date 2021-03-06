package com.example.herobook;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
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

    @Test
    public void addMultipleHeroTest() throws Exception {

        HeroDto hero1 = new HeroDto("superman", "flying");
        HeroDto hero2 = new HeroDto("batman", "jumping");

        mockMvc.perform(post("/heroes")
                .content(objectMapper.writeValueAsString(hero1)).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated()
                );

        mockMvc.perform(post("/heroes")
                .content(objectMapper.writeValueAsString(hero2)).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated()
                );

        mockMvc.perform(get("/heroes"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("length()").value(2))
                .andExpect(jsonPath("[0].name").value("superman"))
                .andExpect(jsonPath("[1].name").value("batman"))
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
                .andExpect(jsonPath("$.name").value("batman"))
                .andExpect(jsonPath("$.super_power").value("jumping"));

    }

    @Test
    public void createMultipleAndGetHeroDetails() throws Exception {
        HeroDto hero1 = new HeroDto("batman", "jumping");
        HeroDto hero2 = new HeroDto("hulk", "greenboy");

        mockMvc.perform(post("/heroes")
                .content(objectMapper.writeValueAsString(hero2)).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated()
                );
        mockMvc.perform(post("/heroes")
                .content(objectMapper.writeValueAsString(hero1)).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated()
                );

        mockMvc.perform(get("/heroes/batman"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("batman"))
                .andExpect(jsonPath("$.super_power").value("jumping"));
    }


    @Test
    public void getHeroDetailsForNonexistentUser() throws Exception {

        mockMvc.perform(get("/heroes/captainamerica"))
                .andExpect(status().isNotFound());
    }

    /* As a visitor, I can view all the villains.
    When I view all the villains
    Then I can see names of all villains */
    @Test
    public void addVillainTest() throws Exception {

        VillainDto villain = new VillainDto("thanos", "cosmicpower");

        mockMvc.perform(post("/villains")
                .content(objectMapper.writeValueAsString(villain)).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated()
                );

        mockMvc.perform(get("/villains"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("length()").value(1))
                .andExpect(jsonPath("[0].name").value("thanos"))
                .andExpect(jsonPath("[0].special_power").value("cosmicpower"));

    }

    @Test
    public void addMultipleVillainTest() throws Exception {

        VillainDto villain1 = new VillainDto("thanos", "cosmicpower");
        VillainDto villain2 = new VillainDto("loki", "teleportation");

        mockMvc.perform(post("/villains")
                .content(objectMapper.writeValueAsString(villain1)).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated()
                );
        mockMvc.perform(post("/villains")
                .content(objectMapper.writeValueAsString(villain2)).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated()
                );

        mockMvc.perform(get("/villains"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("length()").value(2))
                .andExpect(jsonPath("[0].name").value("thanos"))
                .andExpect(jsonPath("[1].name").value("loki"))
                .andExpect(jsonPath("[0].special_power").value("cosmicpower"));

    }
    // As a visitor, I can see information about any individual villain so that I can see their stats.
    @Test
    public void getVillainDetails() throws Exception {
        VillainDto villain1 = new VillainDto("thanos", "cosmicpower");

        mockMvc.perform(post("/villains")
                .content(objectMapper.writeValueAsString(villain1)).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated()
                );

        mockMvc.perform(get("/villains/thanos"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("thanos"))
                .andExpect(jsonPath("$.special_power").value("cosmicpower"));

    }

    @Test
    public void createMultipleAndGetVillainDetails() throws Exception {
        VillainDto villain1 = new VillainDto("thanos", "cosmicpower");
        VillainDto villain2 = new VillainDto("loki", "teleportation");

        mockMvc.perform(post("/villains")
                .content(objectMapper.writeValueAsString(villain1)).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated()
                );
        mockMvc.perform(post("/villains")
                .content(objectMapper.writeValueAsString(villain2)).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated()
                );

        mockMvc.perform(get("/villains/loki"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("loki"))
                .andExpect(jsonPath("$.special_power").value("teleportation"));
    }

    @Test
    public void addUserTest() throws Exception {

        UserDto user1 = new UserDto("Steve", "visitor");
        UserDto user2 = new UserDto("John", "fan");
        UserDto user3 = new UserDto("Nicole", "manager");

        mockMvc.perform(post("/users")
                .content(objectMapper.writeValueAsString(user1)).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated()
                );
        mockMvc.perform(post("/users")
                .content(objectMapper.writeValueAsString(user2)).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated()
                );
        mockMvc.perform(post("/users")
                .content(objectMapper.writeValueAsString(user3)).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated()
                );

        mockMvc.perform(get("/users"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("length()").value(3))
                .andExpect(jsonPath("[0].name").value("Steve"))
                .andExpect(jsonPath("[0].role").value("visitor"))
                .andExpect(jsonPath("[1].role").value("fan"))
                .andExpect(jsonPath("[2].role").value("manager"));

    }



}
