package com.bwgjoseph.spring_boot_mongodb_observability.api;

import io.micrometer.tracing.annotation.NewSpan;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Slf4j
@Service
public class PokemonAPI {
    private final RestClient restClient;
    private final PokemonRepository pokemonRepository;
    private final Fake fake;

    public PokemonAPI(RestClient.Builder builder, PokemonRepository pokemonRepository, Fake fake) {
        this.restClient = builder.baseUrl("https://pokeapi.co/api/v2/pokemon/").build();
        this.pokemonRepository = pokemonRepository;
        this.fake = fake;
    }

    public Pokemon getPokemon(String pokemonId) {
        Pokemon pokemon = this.restClient.get().uri("/{id}", pokemonId).retrieve().toEntity(Pokemon.class).getBody();

        this.currentClassSpan();
        this.fake.newClassSpan("pass-arg");
        log.info("{}", pokemon);

        if (pokemon != null) this.pokemonRepository.save(pokemon);

        return pokemon;
    }

    @NewSpan(name = "current class span")
    public void currentClassSpan() {
        log.info("this does not work because of how AOP in Spring works");
    }
}
