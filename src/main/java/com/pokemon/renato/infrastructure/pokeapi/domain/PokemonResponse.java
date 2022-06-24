package com.pokemon.renato.infrastructure.pokeapi.domain;

import javax.json.bind.annotation.JsonbProperty;
import java.util.List;

public class PokemonResponse {
    @JsonbProperty("abilities")
    private List<Abilities> abilities;
    @JsonbProperty("base_experience")
    private Number base_experience;
    @JsonbProperty("height")
    private Number height;
    @JsonbProperty("name")
    private String name;
    @JsonbProperty("sprites.front_default")
    private String image;
    @JsonbProperty("types")
    private List<Types> types;
    @JsonbProperty("weight")
    private Number weight;

    public PokemonResponse(List<Abilities> abilities, Number base_experience, Number height, String name, String image, List<Types> types, Number weight) {
        this.abilities = abilities;
        this.base_experience = base_experience;
        this.height = height;
        this.name = name;
        this.image = image;
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

    public Number getBase_experience() {
        return base_experience;
    }

    public void setBase_experience(Number base_experience) {
        this.base_experience = base_experience;
    }

    public Number getHeight() {
        return height;
    }

    public void setHeight(Number height) {
        this.height = height;
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

    public List<Types> getTypes() {
        return types;
    }

    public void setTypes(List<Types> types) {
        this.types = types;
    }

    public Number getWeight() {
        return weight;
    }

    public void setWeight(Number weight) {
        this.weight = weight;
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
