package com.pokemon.renato.infrastructure.pokeapi.domain;

import javax.json.bind.annotation.JsonbProperty;
import java.util.List;

public class PokemonResponse {
    @JsonbProperty("abilities")
    private List<Abilities> abilities;
    @JsonbProperty("base_experience")
    private Number baseExperience;
    @JsonbProperty("height")
    private Float height;
    @JsonbProperty("name")
    private String name;
    @JsonbProperty("sprites")
    private Sprites sprites;
    @JsonbProperty("types")
    private List<Types> types;
    @JsonbProperty("weight")
    private Float weight;

    public PokemonResponse(List<Abilities> abilities, Number baseExperience, Float height, String name, Sprites sprites, List<Types> types, Float weight) {
        this.abilities = abilities;
        this.baseExperience = baseExperience;
        this.height = height;
        this.name = name;
        this.sprites = sprites;
        this.types = types;
        this.weight = weight;
    }

    public PokemonResponse() {}

    public List<Abilities> getAbilities() {
        return abilities;
    }

    public void setAbilities(List<Abilities> abilities) {
        this.abilities = abilities;
    }

    public Number getBaseExperience() {
        return baseExperience;
    }

    public void setBaseExperience(Number baseExperience) {
        this.baseExperience = baseExperience;
    }

    public Float getHeight() {
        return height;
    }

    public void setHeight(Float height) {
        this.height = height;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Sprites getSprites() {
        return sprites;
    }

    public void setSprites(Sprites sprites) {
        this.sprites = sprites;
    }

    public List<Types> getTypes() {
        return types;
    }

    public void setTypes(List<Types> types) {
        this.types = types;
    }

    public Float getWeight() {
        return weight;
    }

    public void setWeight(Float weight) {
        this.weight = weight;
    }

    public static class Sprites {
        @JsonbProperty("front_default")
        private String image;

        public Sprites(String image) {
            this.image = image;
        }

        public Sprites() {}

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }
    }

    public static class Abilities {
        @JsonbProperty("ability")
        private Ability name;

        public Abilities(Ability name) {
            this.name = name;
        }

        public Abilities() {}

        public Ability getName() {
            return name;
        }

        public void setName(Ability name) {
            this.name = name;
        }
    }

    public static class Ability {
        @JsonbProperty("name")
        private String name;

        public Ability(String name) {
            this.name = name;
        }

        public Ability() {}

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    public static class Types {
        @JsonbProperty("type")
        private Type name;

        public Types(Type name) {
            this.name = name;
        }

        public Types() {}

        public Type getName() {
            return name;
        }

        public void setName(Type name) {
            this.name = name;
        }
    }

    public static class Type {
        @JsonbProperty("name")
        private String name;

        public Type(String name) {
            this.name = name;
        }

        public Type() {}

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

}
