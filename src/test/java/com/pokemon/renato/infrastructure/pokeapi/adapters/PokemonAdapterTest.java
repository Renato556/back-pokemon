package com.pokemon.renato.infrastructure.pokeapi.adapters;

import com.pokemon.renato.infrastructure.pokeapi.domain.PokemonListResponse;
import com.pokemon.renato.infrastructure.pokeapi.domain.PokemonResponse;
import com.pokemon.renato.infrastructure.pokeapi.gateways.PokemonGateway;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class PokemonAdapterTest {
    private PokemonAdapter pokemonAdapter;
    @Mock
    private PokemonGateway pokemonGateway;

    @BeforeEach
    public void setup() {
        pokemonAdapter = new PokemonAdapter(pokemonGateway);
    }

    @Nested
    @DisplayName("Given PokemonAdapter")
    class AdapterTest {
        @Nested
        @DisplayName("When getAllPokemon is called")
        class GetAllPokemonTest {
            PokemonListResponse pokemonListResponse;
            PokemonListResponse result;
            String mockLimit = "limit";

            @BeforeEach
            public void mockAndAct() {
                pokemonListResponse = new PokemonListResponse();

                doReturn(pokemonListResponse).when(pokemonGateway).getAllPokemon(anyString());

                result = pokemonAdapter.getAllPokemon(mockLimit);
            }

            @Test
            @DisplayName("Then pokemonGateway.getAllPokemon is called")
            void gatewayGetAllPokemonTest() {
                verify(pokemonGateway, times(1)).getAllPokemon(mockLimit);
            }

            @Test
            @DisplayName("Then return pokemonListResponse")
            void getAllPokemonResultTest() {
                assertEquals(pokemonListResponse, result);
            }
        }

        @Nested
        @DisplayName("When getOnePokemon is called")
        class GetOnePokemon {
            PokemonResponse pokemonResponse;
            PokemonResponse result;
            String mockNameOrId = "nameOrId";

            @BeforeEach
            public void mockAndAct() {
                pokemonResponse = new PokemonResponse();

                doReturn(pokemonResponse).when(pokemonGateway).getOnePokemon(anyString());

                result = pokemonAdapter.getOnePokemon(mockNameOrId);
            }

            @Test
            @DisplayName("Then pokemonGateway.getOnePokemon is called")
            void gatewayGetOnePokemonTest() {
                verify(pokemonGateway, times(1)).getOnePokemon(mockNameOrId);
            }

            @Test
            @DisplayName("Then return pokemonResponse")
            void getOnePokemonResultTest() {
                assertEquals(pokemonResponse, result);
            }
        }
    }
}
