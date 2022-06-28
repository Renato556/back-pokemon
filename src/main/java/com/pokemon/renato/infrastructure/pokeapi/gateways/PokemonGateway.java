package com.pokemon.renato.infrastructure.pokeapi.gateways;


import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import com.pokemon.renato.infrastructure.pokeapi.domain.PokemonListResponse;
import com.pokemon.renato.infrastructure.pokeapi.domain.PokemonResponse;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@Path("/api/v2/pokemon")
@RegisterRestClient(baseUri = "https://pokeapi.co")
public interface PokemonGateway {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    PokemonListResponse getAllPokemon(@QueryParam("limit") String limit);

    @GET
    @Path("/{nameOrId}")
    @Produces(MediaType.APPLICATION_JSON)
    PokemonResponse getOnePokemon(@PathParam("nameOrId") String nameOrId);
}
