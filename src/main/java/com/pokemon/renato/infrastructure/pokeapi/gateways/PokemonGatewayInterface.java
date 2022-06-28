package com.pokemon.renato.infrastructure.pokeapi.gateways;

import com.pokemon.renato.infrastructure.pokeapi.domain.PokemonListResponse;
import com.pokemon.renato.infrastructure.pokeapi.domain.PokemonResponse;

public interface PokemonGatewayInterface {
    PokemonListResponse getAllPokemon(String limit);

    PokemonResponse getOnePokemon(String nameOrId);
}
