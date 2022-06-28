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
        @DisplayName("When formatData is called")
        class FormatDataTest {
            Float mockFloat;
            Number mockNumber;
            String mockName;
            String mockExtension;

            String resultStringData;
            String resultFloatData;
            String resultNumberData;

            @BeforeEach
            public void mockAndAct() {
                mockFloat = 12.0F;
                mockNumber = 7;
                mockName = "urshifu-single-strike";
                mockExtension = "kg";
            }

            @Test
            @DisplayName("Then formatData is called with float")
            void formatDataFloatTest() {
                String expectedFloatData = "1.2 kg";
                resultFloatData = pokemonMapper.formatData(mockFloat, mockExtension);
                assertEquals(expectedFloatData, resultFloatData);
            }

            @Test
            @DisplayName("Then formatData is called with number")
            void formatDataNumberTest() {
                String expectedNumberData = "7 kg";
                resultNumberData = pokemonMapper.formatData(mockNumber, mockExtension);
                assertEquals(expectedNumberData, resultNumberData);
            }

            @Test
            @DisplayName("Then formatData is called with string")
            void formatDataString() {
                String expectedName = "urshifu single strike";
                resultStringData = pokemonMapper.formatData(mockName);
                assertEquals(expectedName, resultStringData);
            }
        }

        @Nested
        @DisplayName("When createPokemonList is called")
        class CreatePokemonDataTest {
            List<PokemonList> pokemonList;
            PokemonListResponse pokemonListResponse;
            List<PokemonList> result;

            @BeforeEach
            public void mockAndAct() {
                pokemonList = new ArrayList<>(
                        Arrays.asList(
                                new PokemonList(
                                        "1",
                                        "bulbasaur",
                                        "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/1.png"
                                ),
                                new PokemonList(
                                        "2",
                                        "ivysaur",
                                        "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/2.png"
                                ),
                                new PokemonList(
                                        "3",
                                        "venasaur",
                                        "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/3.png"
                                ),
                                new PokemonList(
                                        "892",
                                        "urshifu single strike",
                                        "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/892.png"
                                )
                        )
                );

                pokemonListResponse = new PokemonListResponse();

                pokemonListResponse.setResults(
                        Arrays.asList(
                                new PokemonListResponse.PokemonData(
                                        "bulbasaur",
                                        "https://pokeapi.co/api/v2/pokemon/1/"
                                ),
                                new PokemonListResponse.PokemonData(
                                        "ivysaur",
                                        "https://pokeapi.co/api/v2/pokemon/2/"
                                ),
                                new PokemonListResponse.PokemonData(
                                        "venasaur",
                                        "https://pokeapi.co/api/v2/pokemon/3/"
                                ),
                                new PokemonListResponse.PokemonData(
                                        "urshifu-single-strike",
                                        "https://pokeapi.co/api/v2/pokemon/892/"
                                )
                        )
                );

                result = pokemonMapper.createPokemonList(pokemonListResponse);
            }

            @Test
            @DisplayName("Then return createPokemonList")
            void createPokemonListTest() {
                assertTrue(EqualsBuilder.reflectionEquals(pokemonList, result));
            }
        }

        @Nested
        @DisplayName("When createOnePokemon is called")
        class CreateOnePokemonTest {
            Pokemon pokemon;
            PokemonResponse pokemonResponse;
            Pokemon result;

            @BeforeEach
            public void mockAndAct() {
                pokemon = new Pokemon(
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
                assertTrue(EqualsBuilder.reflectionEquals(pokemon, result));
            }
        }
    }
}
