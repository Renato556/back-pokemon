package com.pokemon.renato.application.commands;

import com.pokemon.renato.application.mapper.PokemonMapper;
import com.pokemon.renato.domain.entities.PokemonList;
import com.pokemon.renato.infrastructure.pokeapi.gateways.PokemonGatewayInterface;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;

@ApplicationScoped
public class PokemonGetAllCommand {
    private final PokemonGatewayInterface pokemonGatewayInterface;
    private final PokemonMapper pokemonMapper;
    private static final String POKEMON_LIMIT = "898";

    @Inject
    public PokemonGetAllCommand(PokemonGatewayInterface pokemonGatewayInterface, PokemonMapper pokemonMapper) {
        this.pokemonGatewayInterface = pokemonGatewayInterface;
        this.pokemonMapper = pokemonMapper;
    }

    public List<PokemonList> execute() {
        return pokemonMapper.createPokemonList(pokemonGatewayInterface.getAllPokemon(POKEMON_LIMIT));
    }
}
