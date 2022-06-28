package com.pokemon.renato.application.commands;

import com.pokemon.renato.application.mapper.PokemonMapper;
import com.pokemon.renato.domain.entities.Pokemon;
import com.pokemon.renato.infrastructure.pokeapi.domain.PokemonResponse;
import com.pokemon.renato.infrastructure.pokeapi.gateways.PokemonGatewayInterface;
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
class PokemonGetOneCommandTest {
    private PokemonGetOneCommand pokemonGetOneCommand;

    @Mock
    private PokemonGatewayInterface pokemonGatewayInterface;

    @Mock
    private PokemonMapper pokemonMapper;

    @BeforeEach
    public void setup() {
         pokemonGetOneCommand = new PokemonGetOneCommand(pokemonGatewayInterface, pokemonMapper);
    }

    @Nested
    @DisplayName("Given PokemonGetOneCommand")
    class GetOneCommandTest {
        @Nested
        @DisplayName("When execute is called")
        class ExecuteCallTest {
            PokemonResponse pokemonResponse;
            Pokemon pokemon;
            Pokemon result;

            @BeforeEach
            public void mockAndAct() {
                pokemonResponse = new PokemonResponse();
                pokemon = new Pokemon();

                doReturn(pokemonResponse).when(pokemonGatewayInterface).getOnePokemon(anyString());
                doReturn(pokemon).when(pokemonMapper).createOnePokemon(pokemonResponse);

                result = pokemonGetOneCommand.execute(anyString());
            }

            @Test
            @DisplayName("Then getSinglePokemon is called")
            void GetSinglePokemonTest() {
                verify(pokemonGatewayInterface, times(1)).getOnePokemon(anyString());
            }

            @Test
            @DisplayName("Then createOnePokemon is called")
            void CreateOnePokemonTest() {
                verify(pokemonMapper, times(1)).createOnePokemon(any(PokemonResponse.class));
            }

            @Test
            @DisplayName("Then return pokemon")
            void ExecuteResultTest() {
                assertEquals(pokemon, result);
            }
        }
    }
}
