package com.revature.LibraryRestAPI.web;

import com.revature.LibraryRestAPI.models.User;
import com.revature.LibraryRestApi.dao.UserRepoDB;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/userResource")
public class UserResource {

	
	    @Produces("application/json")
	  	@GET
	  	@Path("/user")
	  	public Response getUser() { 
	  		System.out.println("getting called");
	  		User user = new User(); user.setFirstName("navin");
	  		user.setLastName("mathew");
	  		return Response.ok(user, MediaType.APPLICATION_JSON).build(); 
	  	}
	
	
	    @POST
	    @Consumes(MediaType.APPLICATION_JSON)
	    @Path("/newUser")
	    public Response putUsers(User user) {
	    	System.out.println("putUsers getting called.");
	    	System.out.println(user);
	 		UserRepoDB userRepoDB = new UserRepoDB();
	 		userRepoDB.addUser(user);
	 		return Response.ok().build();
	    }
	    
	    
	    
	    
	 	@GET
	    @Produces("application/json")
	 	@Path("/users")
	    public Response getAllUsers()  {
	        //String response = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(persondaodb.getAllPeople());
	 		UserRepoDB userRepoDB = new UserRepoDB();
	 		System.out.println(userRepoDB.getAllUsers());
	        return Response
	                .status(Response.Status.OK)
	                .entity(userRepoDB.getAllUsers())
	                .type(MediaType.APPLICATION_JSON_TYPE)
	                .build();
	    }
	
	
}
