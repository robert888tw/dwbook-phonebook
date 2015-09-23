package com.dwbook.phonebook.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.dwbook.phonebook.representations.Contact;

@Produces(MediaType.TEXT_PLAIN)
@Path("/client")
public class ClientResource {
	private Client client;

	public ClientResource(Client client) {
		this.client = client;
	}
	
	@GET
	@Path("showContact")
	public String showContact(@QueryParam("id") int id) {
		WebTarget contactResource = client.target("http://localhost:8080/contact/" + id);
		Contact c = contactResource.request().get(Contact.class);
		String output = "ID: " + id 
				+ "\nFirst name: " + c.getFirstName()
				+ "\nLast name: " + c.getLastName()
				+ "\nPhone: " + c.getPhone();
		return output;
	}
	
	@GET
	@Path("createContact")
	public Response newContact(@QueryParam("firstName") String firstName,
			@QueryParam("lastName") String lastName, @QueryParam("phone") String phone) {
		WebTarget contactResource = client.target("http://localhost:8080/contact/");
		Response response = contactResource.request(MediaType.APPLICATION_JSON)
				.post(Entity.entity(new Contact(0, firstName, lastName, phone), 
						MediaType.APPLICATION_JSON), Response.class);
		if(response.getStatus() == 201) {
			return Response
					.status(302)
					.entity("The contact was created successfully! The new contact can be found at " +
					response.getHeaders().getFirst("Location")).build();
		}
		else {
			return Response.status(422).entity(response.getEntity()).build();
		}
	
	}
	
	
	
}
