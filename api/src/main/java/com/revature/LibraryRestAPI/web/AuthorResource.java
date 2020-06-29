package com.revature.LibraryRestAPI.web;


import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.revature.LibraryRestApi.dao.AuthorRepoDB;

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
