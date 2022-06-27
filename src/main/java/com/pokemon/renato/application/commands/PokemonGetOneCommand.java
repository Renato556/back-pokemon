package com.pokemon.renato.application.commands;

import com.pokemon.renato.application.mapper.PokemonMapper;
import com.pokemon.renato.domain.entities.Pokemon;
import com.pokemon.renato.infrastructure.pokeapi.gateways.PokemonGatewayInterface;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class PokemonGetOneCommand {
    private final PokemonGatewayInterface pokemonGatewayInterface;
    private final PokemonMapper pokemonMapper;

    @Inject
    public PokemonGetOneCommand(PokemonGatewayInterface pokemonGatewayInterface, PokemonMapper pokemonMapper) {
        this.pokemonGatewayInterface = pokemonGatewayInterface;
        this.pokemonMapper = pokemonMapper;
    }

    public Pokemon execute(String nameOrId) {
        return pokemonMapper.createOnePokemon(pokemonGatewayInterface.getSinglePokemon(nameOrId));
    }
}
