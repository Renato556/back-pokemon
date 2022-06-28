package com.pokemon.renato.infrastructure.pokeapi.resources;

import com.pokemon.renato.application.commands.PokemonGetAllCommand;
import com.pokemon.renato.application.commands.PokemonGetOneCommand;
import com.pokemon.renato.domain.entities.Pokemon;
import com.pokemon.renato.domain.entities.PokemonList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.doReturn;

@ExtendWith(MockitoExtension.class)
class PokemonResourceTest {
    private PokemonResource pokemonResource;

    @Mock
    private PokemonGetAllCommand pokemonGetAllCommand;

    @Mock
    private PokemonGetOneCommand pokemonGetOneCommand;

    @BeforeEach
    public void setup() {
        pokemonResource = new PokemonResource(pokemonGetAllCommand, pokemonGetOneCommand);
    }

    @Nested
    @DisplayName("Given PokemonResource")
    class ResourceTest {
        @Nested
        @DisplayName("When allPokemon is called")
        class AllPokemonTest {
            List<PokemonList> pokemonList;
            Response response;

            @BeforeEach
            public void mockAndAct() {
                pokemonList = new ArrayList<>();

                doReturn(pokemonList).when(pokemonGetAllCommand).execute();

                response = pokemonResource.allPokemon();
            }

            @Test
            @DisplayName("Then return response entity")
            void allPokemonResultTest() {
                assertEquals(pokemonList, response.getEntity());
            }

            @Test
            @DisplayName("Then response status is OK")
            void allPokemonResponseStatusTest() {
                assertEquals(Response.Status.OK, response.getStatusInfo());
            }
        }

        @Nested
        @DisplayName("When onePokemon is called")
        class OnePokemonTest {
            Pokemon pokemon;
            Response response;

            @BeforeEach
            public void mockAndAct() {
                pokemon = new Pokemon();

                doReturn(pokemon).when(pokemonGetOneCommand).execute(anyString());

                response = pokemonResource.onePokemon(anyString());
            }

            @Test
            @DisplayName("Then return pokemon")
            void onePokemonResultTest() {
                assertEquals(pokemon, response.getEntity());
            }

            @Test
            @DisplayName("Then response status is OK")
            void onePokemonResponseTest() {
                assertEquals(Response.Status.OK, response.getStatusInfo());
            }
        }
    }
}
