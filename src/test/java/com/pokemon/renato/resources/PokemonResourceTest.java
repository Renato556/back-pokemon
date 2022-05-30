package com.pokemon.renato.resources;

import com.ciandt.pokemon.renato.domain.fixtures.PokemonResourceFixtures;
import io.quarkus.test.junit.QuarkusTest;
import org.hamcrest.Matcher;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;

@QuarkusTest
public class PokemonResourceTest {

    @Test
    public void testAllPokemonEndpoint() {
        given()
                .when().get("/pokemon/all")
                .then().body((Matcher<?>) PokemonResourceFixtures.gimmePokemon())
                .statusCode(200)
                .body(is("hello"));
    }

}

