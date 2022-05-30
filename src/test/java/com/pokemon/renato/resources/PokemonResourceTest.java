package com.pokemon.renato.resources;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

@QuarkusTest
public class PokemonResourceTest {
    @Test
    public void testAllPokemonEndpoint() {
        given()
                .when().get("/pokemon/all")
                .then()
                .statusCode(200)
                .body(not("Ocorreu um erro, por favor tente novamente"));
    }

    @Test
    public void testSinglePokemonEndpoint() {
        given()
                .when().get("/pokemon/1")
                .then()
                .statusCode(200)
                .body(not("Pokemon não encontrado, por favor tente novamente"));
    }

    @Test
    public void testNonExistingPokemonEndpointId() {
        given()
                .when().get("/pokemon/0")
                .then()
                .statusCode(200)
                .body(is("Pokemon não encontrado, por favor tente novamente"));
    }

    @Test
    public void testNonExistingPokemonEndpointName() {
        given()
                .when().get("/pokemon/misto")
                .then()
                .statusCode(200)
                .body(is("Pokemon não encontrado, por favor tente novamente"));
    }
}

