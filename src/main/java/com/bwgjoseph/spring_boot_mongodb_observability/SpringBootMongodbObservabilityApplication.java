package com.bwgjoseph.spring_boot_mongodb_observability;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootMongodbObservabilityApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootMongodbObservabilityApplication.class, args);
	}

//	@Bean
//	ApplicationRunner run(PokemonAPI pokemonAPI) {
//		return arg -> {
//			pokemonAPI.getPokemon("2");
//		};
//	}
}
