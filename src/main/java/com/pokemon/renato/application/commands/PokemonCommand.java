package com.pokemon.renato.application.commands;

import com.pokemon.renato.domain.entities.Pokemon;
import com.pokemon.renato.domain.entities.PokemonList;
import com.pokemon.renato.infrastructure.pokeapi.domain.PokemonListResponse;
import com.pokemon.renato.infrastructure.pokeapi.domain.PokemonResponse;
import com.pokemon.renato.infrastructure.pokeapi.gateways.PkmGateway;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class PokemonCommand {
    private final PkmGateway pkmGateway;

    @Inject
    public PokemonCommand(PkmGateway pkmGateway) {
        this.pkmGateway = pkmGateway;
    }

    public String treatData(Float data, String extension) {
        return (data / 10) + " " + extension;
    }

    public String treatData(Number data, String extension) {
        return  data + " " + extension;
    }

    public String formatName(String name) {
        return name.replaceAll("-", " ");
    }

    public List<PokemonList> createPokemonList(PokemonListResponse pokemonListResponse) {
        List<PokemonList> newPokemonList = new ArrayList<>();
        final String IMAGE_URL =  "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/0.png";
        List<PokemonListResponse.PokemonList> pokemonList = pokemonListResponse.getResults();
        for (int i = 0; i < pokemonListResponse.getResults().size(); i++) {
            String name = formatName(pokemonList.get(i).getName());
            String id = pokemonList.get(i).getUrl().split("/")[6];
            String image = IMAGE_URL.replace("0", id);
            newPokemonList.add(new PokemonList(id, name, image));
        }
        return newPokemonList;
    }

    public Pokemon createSinglePokemon(PokemonResponse pokemonResponse) {
        String weight = treatData(pokemonResponse.getWeight(), "kg");
        String height = treatData(pokemonResponse.getHeight(), "m");
        return new Pokemon(
                formatName(pokemonResponse.getName()),
                pokemonResponse.getSprites().getImage(),
                treatData(pokemonResponse.getBaseExperience(), "XP"),
                weight,
                height,
                pokemonResponse.getTypes(),
                pokemonResponse.getAbilities()
        );
    }

    public PokemonListResponse getAllPokemon() {
        final String POKEMON_LIMIT = "898";
        return pkmGateway.getAllPokemon(POKEMON_LIMIT);
    }

    public PokemonResponse getOnePokemonByIdOrByName(String nameOrId) {
        return pkmGateway.getSinglePokemon(nameOrId);
    }

}
