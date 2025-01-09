package com.bwgjoseph.spring_boot_mongodb_observability.api;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class PokemonController {
    private final PokemonAPI pokemonAPI;

    public PokemonController(PokemonAPI pokemonAPI) {
        this.pokemonAPI = pokemonAPI;
    }

    @GetMapping("/trace")
    public String trace() {
        return "trace";
    }

    @GetMapping("/pokemon")
    public Pokemon get() {
        Pokemon ditto = this.pokemonAPI.getPokemon("ditto");
        Pokemon clefairy = this.pokemonAPI.getPokemon("clefairy");

        return new Pokemon(ditto.id(), ditto.name(), ditto.baseExperience());
    }
}
