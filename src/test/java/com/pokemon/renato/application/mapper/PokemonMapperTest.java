package com.pokemon.renato.application.mapper;

import com.pokemon.renato.domain.entities.Pokemon;
import com.pokemon.renato.domain.entities.PokemonList;
import com.pokemon.renato.infrastructure.pokeapi.domain.PokemonListResponse;
import com.pokemon.renato.infrastructure.pokeapi.domain.PokemonResponse;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class PokemonMapperTest {
    private PokemonMapper pokemonMapper;

    @BeforeEach
    public void setup() {
        pokemonMapper = new PokemonMapper();
    }

    @Nested
    @DisplayName("Given PokemonMapper")
    class MapperTest {
        @Nested
        @DisplayName("When createPokemonList is called")
        class CreatePokemonDataTest {
            List<PokemonList> expectedPokemonList;
            PokemonListResponse pokemonListResponse = spy(PokemonListResponse.class);
            List<PokemonList> result;

            @BeforeEach
            public void mockAndAct() {
                expectedPokemonList = new ArrayList<>(
                        Arrays.asList(
                                new PokemonList(
                                        "1",
                                        "bulbasaur",
                                        "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/1.png"
                                ),
                                new PokemonList(
                                        "892",
                                        "urshifu single strike",
                                        "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/892.png"
                                )
                        )
                );

                List<PokemonListResponse.PokemonData> getResultsMock = Arrays.asList(
                        new PokemonListResponse.PokemonData(
                                "bulbasaur",
                                "https://pokeapi.co/api/v2/pokemon/1/"
                        ),
                        new PokemonListResponse.PokemonData(
                                "urshifu-single-strike",
                                "https://pokeapi.co/api/v2/pokemon/892/"
                        )
                );

                doReturn(getResultsMock).when(pokemonListResponse).getResults();

                result = pokemonMapper.createPokemonList(pokemonListResponse);
            }

            @Test
            @DisplayName("Then pokemonListResponse.getResults is called")
            void getResultsTest() {
                verify(pokemonListResponse, times(1)).getResults();
            }

            @Test
            @DisplayName("Then return createPokemonList")
            void createPokemonListTest() {
                assertTrue(EqualsBuilder.reflectionEquals(expectedPokemonList, result));
            }
        }

        @Nested
        @DisplayName("When createOnePokemon is called")
        class CreateOnePokemonTest {
            Pokemon expectedPokemon;
            PokemonResponse pokemonResponse;
            Pokemon result;

            @BeforeEach
            public void mockAndAct() {
                expectedPokemon = new Pokemon(
                        "urshifu single strike",
                        null,
                        "275 XP",
                        "1.9 m",
                        "105.0 kg",
                        new ArrayList<>(),
                        new ArrayList<>()
                );

                pokemonResponse = new PokemonResponse(
                        new ArrayList<>(),
                        275,
                        19F,
                        "urshifu-single-strike",
                        new PokemonResponse.Sprites(),
                        new ArrayList<>(),
                        1050F
                );

                result = pokemonMapper.createOnePokemon(pokemonResponse);
            }

            @Test
            @DisplayName("Then return createOnePokemon")
            void createOnePokemonTest() {
                assertTrue(EqualsBuilder.reflectionEquals(expectedPokemon, result));
            }
        }
    }
}
