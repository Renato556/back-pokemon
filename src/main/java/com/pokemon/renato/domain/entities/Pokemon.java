package com.pokemon.renato.domain.entities;

import com.pokemon.renato.infrastructure.pokeapi.domain.PokemonResponse;

import java.util.List;

public class Pokemon {
    private String name;
    private String image;
    private String baseExperience;
    private String height;
    private String weight;
    private List<PokemonResponse.Types> types;
    private List<PokemonResponse.Abilities> abilities;

    public Pokemon(String name, String image, String baseExperience, String height, String weight, List<PokemonResponse.Types> types, List<PokemonResponse.Abilities> abilities) {
        this.name = name;
        this.image = image;
        this.baseExperience = baseExperience;
        this.height = height;
        this.weight = weight;
        this.types = types;
        this.abilities = abilities;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getBaseExperience() {
        return baseExperience;
    }

    public void setBaseExperience(String baseExperience) {
        this.baseExperience = baseExperience;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public List<PokemonResponse.Types> getTypes() {
        return types;
    }

    public void setTypes(List<PokemonResponse.Types> types) {
        this.types = types;
    }

    public List<PokemonResponse.Abilities> getAbilities() {
        return abilities;
    }

    public void setAbilities(List<PokemonResponse.Abilities> abilities) {
        this.abilities = abilities;
    }
}
