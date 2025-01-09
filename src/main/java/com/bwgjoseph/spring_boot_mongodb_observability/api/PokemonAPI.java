package com.bwgjoseph.spring_boot_mongodb_observability.api;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Slf4j
@Service
public class PokemonAPI {
    private final RestClient restClient;
    private final PokemonRepository pokemonRepository;

    public PokemonAPI(RestClient.Builder builder, PokemonRepository pokemonRepository) {
        this.restClient = builder.baseUrl("https://pokeapi.co/api/v2/pokemon/").build();
        this.pokemonRepository = pokemonRepository;
    }

    public Pokemon getPokemon(String pokemonId) {
        Pokemon pokemon = this.restClient.get().uri("/{id}", pokemonId).retrieve().toEntity(Pokemon.class).getBody();

//        log.info("{}", pokemon);

        if (pokemon != null) this.pokemonRepository.save(pokemon);

        return pokemon;
    }
}
