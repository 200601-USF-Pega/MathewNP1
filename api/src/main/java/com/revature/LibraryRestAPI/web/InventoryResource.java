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

import com.revature.LibraryRestAPI.models.Book;
import com.revature.LibraryRestAPI.models.Catalog;
import com.revature.LibraryRestAPI.models.User;
import com.revature.LibraryRestAPI.services.EditUserService;
import com.revature.LibraryRestApi.dao.BookRepoDB;
import com.revature.LibraryRestApi.dao.CatalogRepoDB;

@Path("/catalog")
public class InventoryResource {

	private BookRepoDB bookRepoDB = new BookRepoDB();
	private CatalogRepoDB catalogDB = new CatalogRepoDB(); 
    @Produces("application/json")
  	@GET
  	@Path("/book")
  	public Response getBook(Book book) { 
  		//System.out.println("getting called");
  		return Response.ok(book, MediaType.APPLICATION_JSON).build(); 
  	}


    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/book")
    public Response addCopy(Catalog catalog) {
    	//System.out.println("putUsers getting called.");
    	
    	int bookID = bookRepoDB.getBookID(catalog.getBook());
    	System.out.println("Bookid: " + bookID);
    	catalogDB.addInventory(bookID);

 		return Response.status(200)
 			      .entity("")
 			      .build();	
    }
    
    
    @DELETE
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/book")
    public Response deleteCopy(Catalog catalog) {
    	int bookID = bookRepoDB.getBookID(catalog.getBook());
    	catalogDB.deleteInventory(bookID, 1);
 		return Response.status(200)
 			      .entity("")
 			      .build();	
    }

//    @PUT
//    @Consumes(MediaType.APPLICATION_JSON)
//    @Path("/book")
//    public Response editBook(User user) {
//    	//System.out.println("putUsers getting called.");
//    	//System.out.println(user);
//    	EditUserService editService = new EditUserService();
//    	editService.editUser(user);
// 		return Response.status(200)
// 			      .entity("")
// 			      .build();	
//    }
//    

    
 	@GET
    @Produces("application/json")
 	@Path("/books")
    public Response getCatalog()  {
        //String response = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(persondaodb.getAllPeople());
        return Response
                .status(Response.Status.OK)
                .entity(catalogDB.getAllCatalogs())
                .type(MediaType.APPLICATION_JSON_TYPE)
                .build();
    }
}
