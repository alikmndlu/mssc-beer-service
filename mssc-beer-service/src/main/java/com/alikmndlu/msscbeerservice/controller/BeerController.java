package com.alikmndlu.msscbeerservice.controller;

import com.alikmndlu.msscbeerservice.model.BeerDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/beers")
public class BeerController {

    @GetMapping("/{beer-id}")
    public ResponseEntity<BeerDto> getBeerById(@PathVariable("beer-id") UUID id){
        //todo impl
        return ResponseEntity.ok().body(BeerDto.builder().build());
    }

    @PostMapping("/")
    public ResponseEntity<BeerDto> saveNewBeer(@RequestBody BeerDto beerDto){
        //todo impl
        beerDto.setId(UUID.randomUUID());
        return ResponseEntity.ok().body(beerDto);
    }

    @PutMapping("/{beer-id}")
    public ResponseEntity<?> updateBeer(@PathVariable("beer-id") UUID id, @RequestBody BeerDto beerDto){

        //todo impl
        return ResponseEntity.noContent().build();
    }
}
