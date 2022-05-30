package com.ciandt.pokemon.renato.domain.fixtures;

import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;

import javax.enterprise.inject.Any;

public class PokemonResourceFixtures {
    public void load(){
        Fixture.of(Any.class).addTemplate("getPokemon", new Rule(){{
            add("name", "bulbasaur");
            add("url", "\"https://pokeapi.co/api/v2/pokemon/1/\"");
            //add("name", "ivysaur");
            //add("url", "\"https://pokeapi.co/api/v2/pokemon/2/\"");
            //add("name", "venusaur");
            //add("url", "\"https://pokeapi.co/api/v2/pokemon/3/\"");
            //add("name", "charmander");
            //add("url", "\"https://pokeapi.co/api/v2/pokemon/4/\"");
            //add("name", "charmeleon");
            //add("url", "\"https://pokeapi.co/api/v2/pokemon/5/\"");
        }});
    }
    public static Object gimmePokemon() {
        return Fixture.from(Any.class).gimme("getPokemon");
    }
}
