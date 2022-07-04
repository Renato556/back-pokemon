package com.pokemon.renato.application.commands;

import com.pokemon.renato.application.mapper.PokemonMapper;
import com.pokemon.renato.domain.entities.PokemonList;
import com.pokemon.renato.infrastructure.pokeapi.domain.PokemonListResponse;
import com.pokemon.renato.infrastructure.pokeapi.gateways.PokemonGatewayInterface;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class PokemonGetAllCommandTest {
    private PokemonGetAllCommand pokemonGetAllCommand;
    @Mock
    private PokemonGatewayInterface pokemonGatewayInterface;
    @Mock
    private PokemonMapper pokemonMapper;

    @BeforeEach
    public void setup() {
        pokemonGetAllCommand = new PokemonGetAllCommand(pokemonGatewayInterface, pokemonMapper);
    }

    @Nested
    @DisplayName("Given PokemonGetAllCommand")
    class GetAllCommandTest {
        @Nested
        @DisplayName("When execute is called")
        class ExecuteCallTest {
            PokemonListResponse pokemonListResponse;
            List<PokemonList> pokemonList;
            List<PokemonList> result;
            String POKEMON_LIMIT = "898";

            @BeforeEach
            public void mockAndAct() {
                pokemonListResponse = new PokemonListResponse();
                pokemonList = new ArrayList<>();

                doReturn(pokemonListResponse).when(pokemonGatewayInterface).getAllPokemon(POKEMON_LIMIT);
                doReturn(pokemonList).when(pokemonMapper).createPokemonList(any(PokemonListResponse.class));

                result = pokemonGetAllCommand.execute();
            }

            @Test
            @DisplayName("Then getAllPokemon is called")
            void GetAllPokemonTest() {
                verify(pokemonGatewayInterface, times(1)).getAllPokemon(POKEMON_LIMIT);
            }

            @Test
            @DisplayName("Then createPokemonList is called")
            void CreatePokemonListTest() {
                verify(pokemonMapper, times(1)).createPokemonList(pokemonListResponse);
            }

            @Test
            @DisplayName("Then return pokemonList")
            void ExecuteResultTest() {
                assertEquals(pokemonList, result);
            }
        }
    }
}
