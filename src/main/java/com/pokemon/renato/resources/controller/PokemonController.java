package com.pokemon.renato.resources.controller;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class PokemonController {
    static String URL = "https://pokeapi.co/api/v2/pokemon";

    public static String getAllPokemon() {
        var client = HttpClient.newHttpClient();

        var request = HttpRequest.newBuilder(
                URI.create(URL + "?limit=898&offset=0"))
                .build();

        var response = client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                .join();

        if (response.statusCode() != 200) {
            return "Ocorreu um erro, por favor tente novamente";
        }

        return response.body();
    }

    public static String getOnePokemonByIdOrByName(String param) {
        var client = HttpClient.newHttpClient();

        var request = HttpRequest.newBuilder(
                URI.create(URL + "/" + param))
                .build();

        var response = client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                .join();

        if (response.statusCode() != 200) {
            return "Pokemon não encontrado, por favor tente novamente";
        }

        return response.body();
    }

}
