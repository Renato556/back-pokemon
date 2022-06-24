package com.pokemon.renato.infrastructure.pokeapi.domain;

import javax.json.bind.annotation.JsonbProperty;
import java.util.List;

public class PokemonListResponse {
    @JsonbProperty("results")
    private List<PokemonList> results;

    public PokemonListResponse(List<PokemonList> results) {
        this.results = results;
    }

    public PokemonListResponse() {}

    public List<PokemonList> getResults() {
        return results;
    }

    public void setResults(List<PokemonList> results) {
        this.results = results;
    }

    public static class PokemonList {
        @JsonbProperty("name")
        private String name;
        @JsonbProperty("url")
        private String url;

        public PokemonList(String name, String url) {
            this.name = name;
            this.url = url;
        }

        public PokemonList() {}

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }
    }
}
