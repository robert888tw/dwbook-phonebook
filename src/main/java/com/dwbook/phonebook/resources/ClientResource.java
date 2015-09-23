package com.dwbook.phonebook.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

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
	
	
}
