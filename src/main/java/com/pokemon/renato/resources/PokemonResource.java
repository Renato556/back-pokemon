package com.pokemon.renato.resources;

import com.pokemon.renato.domain.entities.Pokemon;
import com.pokemon.renato.domain.entities.PokemonList;
import com.pokemon.renato.infrastructure.pokeapi.domain.PokemonListResponse;
import com.pokemon.renato.infrastructure.pokeapi.domain.PokemonResponse;
import com.pokemon.renato.application.commands.PokemonCommand;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/pokemon/")
public class PokemonResource {
    private final PokemonCommand pokemonCommand;

    @Inject
    public PokemonResource(PokemonCommand pokemonCommand) {
        this.pokemonCommand = pokemonCommand;
    }

    @GET
    @Path("all")
    @Produces(MediaType.APPLICATION_JSON)
    public Response allPokemon() {
        PokemonListResponse pokemonListResponse = pokemonCommand.getAllPokemon();
        List<PokemonList> pokemonList = pokemonCommand.createPokemonList(pokemonListResponse);
        return Response.status(Response.Status.OK).entity(pokemonList).build();
    }

    @GET
    @Path("{nameOrId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response idPokemon(@PathParam("nameOrId") String nameOrId) {
        try{
            PokemonResponse pokemonResponse = pokemonCommand.getOnePokemonByIdOrByName(nameOrId);
            Pokemon pokemon = pokemonCommand.createSinglePokemon(pokemonResponse);
            return Response.status(Response.Status.OK).entity(pokemon).build();
        }
        catch(Exception e){
            return Response.status(Response.Status.NOT_FOUND).entity("POKEMON NOT FOUND").build();
        }
    }
}
