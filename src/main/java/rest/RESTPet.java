/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mysql.cj.xdevapi.JsonParser;
import facade.FacadePet;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * REST Web Service
 *
 * @author Oliver
 */
@Path("pet")
public class RESTPet {

    @Context
    private UriInfo context;

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpapu");
    Gson gson = new GsonBuilder().setPrettyPrinting().create();
    JsonParser jsonParser = new JsonParser();
    FacadePet fp = new FacadePet(emf);

    public RESTPet() {
        gson = new GsonBuilder().setPrettyPrinting().create();
    }
    
    @Path("{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPet(@PathParam("id") int id) {
        String json = gson.toJson(fp.getPetDTO(id));
        return Response.ok(json).build();
    }
    
    @Path("event")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPetEvents() {
        String json = gson.toJson(fp.getPetEvents());
        return Response.ok(json).build();
    }
    
    @Path("alive")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getLivingPets() {
        String json = gson.toJson(fp.getLivingPets());
        return Response.ok(json).build();
    }
    
    @Path("count")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPetCount() {
        //String s1 = "\"petCount\"";
        //String finalString = s1.replace("\\","");
        //String json = gson.toJson("{\"petCount\":" + fp.getPetCount() + "}");
        return Response.ok("{\"petCount\":" + fp.getPetCount() + "}").build();
    }
    
    
    @Path("all")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getJson() {
        String json = gson.toJson(fp.getAllPets());
        return Response.ok(json).build();
    }
    
    @Path("test")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getTestMessage() {
        return "Dette er en rest-test";
    }

    /**
     * PUT method for updating or creating an instance of RESTPet
     *
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) {
    }
}
