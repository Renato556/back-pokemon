package com.pokemon.renato.application.mapper;

import com.pokemon.renato.domain.entities.Pokemon;
import com.pokemon.renato.domain.entities.PokemonList;
import com.pokemon.renato.infrastructure.pokeapi.domain.PokemonListResponse;
import com.pokemon.renato.infrastructure.pokeapi.domain.PokemonResponse;

import javax.enterprise.context.ApplicationScoped;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class PokemonMapper {
    private String formatData(Float data, String extension) {
        return (data / 10) + " " + extension;
    }

    private String formatData(Number data, String extension) {
        return data + " " + extension;
    }

    private String formatData(String name) {
        return name.replaceAll("-", " ");
    }

    public List<PokemonList> createPokemonList(PokemonListResponse pokemonListResponse) {
        List<PokemonList> newPokemonList = new ArrayList<>();
        final String IMAGE_URL = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/0.png";
        List<PokemonListResponse.PokemonData> pokemonData = pokemonListResponse.getResults();
        for (int i = 0; i < pokemonData.size(); i++) {
            String name = this.formatData(pokemonData.get(i).getName());
            String id = pokemonData.get(i).getUrl().split("/")[6];
            String image = IMAGE_URL.replace("0", id);
            newPokemonList.add(new PokemonList(id, name, image));
        }
        return newPokemonList;
    }

    public Pokemon createOnePokemon(PokemonResponse pokemonResponse) {
        return new Pokemon(
                this.formatData(pokemonResponse.getName()),
                pokemonResponse.getSprites().getImage(),
                this.formatData(pokemonResponse.getBaseExperience(), "XP"),
                this.formatData(pokemonResponse.getHeight(), "m"),
                this.formatData(pokemonResponse.getWeight(), "kg"),
                pokemonResponse.getTypes(),
                pokemonResponse.getAbilities()
        );
    }
}
