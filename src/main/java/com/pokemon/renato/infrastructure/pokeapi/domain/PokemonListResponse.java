package com.pokemon.renato.infrastructure.pokeapi.domain;

import javax.json.bind.annotation.JsonbProperty;
import java.util.List;

public class PokemonListResponse {
    @JsonbProperty("results")
    private List<PokemonData> results;

    public PokemonListResponse(List<PokemonData> results) {
        this.results = results;
    }

    public PokemonListResponse() {
    }

    public List<PokemonData> getResults() {
        return results;
    }

    public void setResults(List<PokemonData> results) {
        this.results = results;
    }

    public static class PokemonData {
        @JsonbProperty("name")
        private String name;
        @JsonbProperty("url")
        private String url;

        public PokemonData(String name, String url) {
            this.name = name;
            this.url = url;
        }

        public PokemonData() {
        }

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
