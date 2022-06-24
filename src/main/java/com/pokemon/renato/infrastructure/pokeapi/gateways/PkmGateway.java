package com.pokemon.renato.infrastructure.pokeapi.gateways;

import com.pokemon.renato.infrastructure.pokeapi.domain.PokemonListResponse;
import com.pokemon.renato.infrastructure.pokeapi.domain.PokemonResponse;

public interface PkmGateway {
    PokemonListResponse getAllPokemon(String limit);

    PokemonResponse getSinglePokemon(String nameOrId);
}
