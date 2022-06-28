package com.pokemon.renato.infrastructure.pokeapi.adapters;

import com.pokemon.renato.infrastructure.pokeapi.domain.PokemonListResponse;
import com.pokemon.renato.infrastructure.pokeapi.domain.PokemonResponse;
import com.pokemon.renato.infrastructure.pokeapi.gateways.PokemonGatewayInterface;
import com.pokemon.renato.infrastructure.pokeapi.gateways.PokemonGateway;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class PokemonAdapter implements PokemonGatewayInterface {
    private final PokemonGateway pokemonGateway;

    @Inject
    public PokemonAdapter(@RestClient PokemonGateway pokemonGateway) {
        this.pokemonGateway = pokemonGateway;
    }

    @Override
    public PokemonListResponse getAllPokemon(String limit) {
        return pokemonGateway.getAllPokemon(limit);
    }

    @Override
    public PokemonResponse getOnePokemon(String nameOrId) {
        return pokemonGateway.getOnePokemon(nameOrId);
    }
}
