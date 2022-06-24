package com.pokemon.renato.application.commands;

import com.pokemon.renato.infrastructure.pokeapi.domain.PokemonListResponse;
import com.pokemon.renato.infrastructure.pokeapi.domain.PokemonResponse;
import com.pokemon.renato.infrastructure.pokeapi.gateways.PkmGateway;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class PokemonCommand {
    private final PkmGateway pkmGateway;

    @Inject
    public PokemonCommand(PkmGateway pkmGateway) {
        this.pkmGateway = pkmGateway;
    }

    public PokemonListResponse getAllPokemon() {
        final String POKEMON_LIMIT = "898";
        return pkmGateway.getAllPokemon(POKEMON_LIMIT);
    }

    public PokemonResponse getOnePokemonByIdOrByName(String nameOrId) {
        return pkmGateway.getSinglePokemon(nameOrId);
    }

}
