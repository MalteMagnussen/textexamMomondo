/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import dto.JokeOutDTO;
import facades.JokeFacade;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeoutException;
import javax.annotation.security.RolesAllowed;
import javax.persistence.EntityManagerFactory;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import utils.EMF_Creator;

/**
 * REST Web Service
 *
 * @author Malte
 */
@Path("jokeByCategoryV2")
public class JokeResourceV2 {

    private static final EntityManagerFactory EMF = EMF_Creator.createEntityManagerFactory(EMF_Creator.DbSelector.DEV, EMF_Creator.Strategy.CREATE);
    private static final JokeFacade FACADE = JokeFacade.getJokeFacade(EMF);

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of JokeResourceV2
     */
    public JokeResourceV2() {
    }

    /**
     * Retrieves representation of an instance of rest.JokeResourceV2
     *
     * @param categories
     * @return an instance of java.lang.String
     */
    @GET
    @Path("{categories}")
    @Produces(MediaType.APPLICATION_JSON)
    @RolesAllowed({"admin", "user"})
    public JokeOutDTO getJson(@PathParam("categories") String categories) {
        boolean permission = true;
        try {
            return FACADE.getJoke(categories, permission);
        } catch (InterruptedException | ExecutionException | TimeoutException ex) {
            throw new WebApplicationException("Error in the Jokefinder Server.", Response.Status.INTERNAL_SERVER_ERROR);
        }
    }
}
