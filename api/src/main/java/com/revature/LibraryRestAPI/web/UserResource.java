package com.revature.LibraryRestAPI.web;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.revature.LibraryRestAPI.models.User;
import com.revature.LibraryRestAPI.services.EditUserService;
import com.revature.LibraryRestApi.dao.UserRepoDB;

@Path("/userResource")
public class UserResource {

		private UserRepoDB userRepoDb = new UserRepoDB();
		
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
	    @Path("/user")
	    public Response putUsers(User user) {
	    	//System.out.println("putUsers getting called.");
	    	System.out.println(user);

	 		UserRepoDB userRepoDB = new UserRepoDB();
	 		userRepoDB.addUser(user);
	 		return Response.status(200)
	 			      .entity("")
	 			      .build();	
	    }
	    
	    @PUT
	    @Consumes(MediaType.APPLICATION_JSON)
	    @Path("/user")
	    public Response editUser(User user) {
	    	//System.out.println("putUsers getting called.");
	    	//System.out.println(user);
	    	EditUserService editService = new EditUserService();
	    	editService.editUser(user);
	 		return Response.status(200)
	 			      .entity("")
	 			      .build();	
	    }
	    
	    
	    @DELETE
	    @Consumes(MediaType.APPLICATION_JSON)
	    @Path("/user")
	    public Response deleteUser(User user) {

	 		UserRepoDB userRepoDB = new UserRepoDB();
	 		userRepoDB.deleteUser(user);
	 		return Response.status(200)
	 			      .entity("")
	 			      .build();	
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
