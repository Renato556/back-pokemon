package com.pokemon.renato.infrastructure.pokeapi.resources;

import com.pokemon.renato.application.commands.PokemonGetAllCommand;
import com.pokemon.renato.application.commands.PokemonGetOneCommand;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/pokemon/")
public class PokemonResource {
    private final PokemonGetAllCommand pokemonGetAllCommand;
    private final PokemonGetOneCommand pokemonGetOneCommand;

    @Inject
    public PokemonResource(PokemonGetAllCommand pokemonGetAllCommand, PokemonGetOneCommand pokemonGetOneCommand) {
        this.pokemonGetAllCommand = pokemonGetAllCommand;
        this.pokemonGetOneCommand = pokemonGetOneCommand;
    }

    @GET
    @Path("all")
    @Produces(MediaType.APPLICATION_JSON)
    public Response allPokemon() {
        return Response.status(Response.Status.OK).entity(pokemonGetAllCommand.execute()).build();
    }

    @GET
    @Path("{nameOrId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response onePokemon(@PathParam("nameOrId") String nameOrId) {
        return Response.status(Response.Status.OK).entity(pokemonGetOneCommand.execute(nameOrId)).build();
    }
}
