/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;
import model.AnimalNoDB;

/**
 * REST Web Service
 *
 * @author sumit
 */
@Path("animals")

public class AnimalDemo {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of AnimalDemo
     */
    public AnimalDemo() {

    }

    /**
     * Retrieves representation of an instance of rest.AnimalDemo
     *
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getJson() {
        //TODO return proper representation object
        return "{VUF}";
    }

    @GET
    @Path("/animal_list")
    @Produces(MediaType.APPLICATION_JSON)

    public String getList() {
        //TODO return proper representation object

        return "[\"Dog\", \"Cat\", \"Mouse\", \"Bird\"]";
    }

    /**
     * PUT method for updating or creating an instance of AnimalDemo
     *
     * @param content representation for the resource
     */
    @GET
    @Path("/animal")
    @Produces(MediaType.APPLICATION_JSON)
    public String animal() {

        Gson GSON = new GsonBuilder().setPrettyPrinting().create();
        AnimalNoDB animal = new AnimalNoDB("Dog", "Bark");

        String animalString = GSON.toJson(animal);

        return animalString;
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) {
    }
}
