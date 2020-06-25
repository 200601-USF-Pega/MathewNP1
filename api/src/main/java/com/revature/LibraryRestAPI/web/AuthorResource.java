package com.revature.LibraryRestAPI.web;


import com.revature.LibraryRestApi.dao.AuthorRepoDB;
import com.revature.LibraryRestApi.dao.UserRepoDB;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/authors")
public class AuthorResource {

	
	/*
	 * @Produces(MediaType.APPLICATION_JSON)
	 * 
	 * @GET public Response getUser() { System.out.println("getting called");
	 * 
	 * //ObjectMapper mapper = new ObjectMapper(); //String response =
	 * mapper.writerWithDefaultPrettyPrinter().writeValueAsString(persondaodb.
	 * getAllPeople());
	 * 
	 * User user = new User(); user.setFirstName("navin");
	 * user.setLastName("mathew");
	 * 
	 * return Response.ok(user, MediaType.APPLICATION_JSON).build(); }
	 */
	
	 	@GET
	    @Produces("application/json")
	    public Response getAllAuthors()  {
	        //String response = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(persondaodb.getAllPeople());
	 		AuthorRepoDB authorRepoDB = new AuthorRepoDB();
	        return Response
	                .status(Response.Status.OK)
	                .entity(authorRepoDB.getAllAuthors())
	                .type(MediaType.APPLICATION_JSON_TYPE)
	                .build();
	    }
	
	
}
