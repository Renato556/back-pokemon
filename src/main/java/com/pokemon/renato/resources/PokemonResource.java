package com.pokemon.renato.resources;

import com.pokemon.renato.resources.controller.PokemonController;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/pokemon/")
public class PokemonResource {

    @GET
    @Path("all")
    @Produces(MediaType.APPLICATION_JSON)
    public String allPokemon() {
        return PokemonController.getAllPokemon();
    }

    @GET
    @Path("{param}")
    @Produces(MediaType.APPLICATION_JSON)
    public String idPokemon(@PathParam("param") String param) {
        return PokemonController.getOnePokemonByIdOrByName(param);
    }

}
