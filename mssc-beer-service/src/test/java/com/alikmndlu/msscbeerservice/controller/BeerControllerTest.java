package com.alikmndlu.msscbeerservice.controller;

import com.alikmndlu.msscbeerservice.model.BeerDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.UUID;

@WebMvcTest(BeerController.class)
public class BeerControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void getBeerById() throws Exception {
        mockMvc.perform(
                MockMvcRequestBuilders.get("/api/v1/beers/" + UUID.randomUUID())
                        .accept(MediaType.APPLICATION_JSON)
        ).andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void saveNewBeer() throws Exception {
        BeerDto beerDto = BeerDto.builder().build();
        String beerDtoJson = objectMapper.writeValueAsString(beerDto);

        mockMvc.perform(
                MockMvcRequestBuilders.post("/api/v1/beers/")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(beerDtoJson)
        ).andExpect(MockMvcResultMatchers.status().isCreated());
    }

    @Test
    void updateBeer() throws Exception {
        BeerDto beerDto = BeerDto.builder().build();
        String beerDtoJson = objectMapper.writeValueAsString(beerDto);

        mockMvc.perform(
                MockMvcRequestBuilders.put("/api/v1/beers/" + UUID.randomUUID())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(beerDtoJson)
        ).andExpect(MockMvcResultMatchers.status().isNoContent());
    }
}