package com.dwbook.phonebook.resources;

import java.net.URI;
import java.net.URISyntaxException;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.skife.jdbi.v2.DBI;

import com.dwbook.phonebook.dao.ContactDAO;
import com.dwbook.phonebook.representations.Contact;

@Path("/contact")
@Produces(MediaType.APPLICATION_JSON)
public class ContactResource {
	private final ContactDAO contactDao;
	
	public ContactResource(DBI jdbi) {
		contactDao = jdbi.onDemand(ContactDAO.class);
	}
	
	@GET
	@Path("/{id}")
	public Response getContact(@PathParam("id") int id) {
		Contact contact = contactDao.getContactByid(id);
		return Response.ok(contact).build();
	}
	
	@POST
	public Response createContact(Contact contact) throws URISyntaxException {
		int newContactId = contactDao.createContact(contact.getFirstName(), contact.getLastName(), 
				contact.getPhone());
		return Response.created(new URI(String.valueOf(newContactId))).build();
	}
	
	@DELETE
	@Path("/{id}")
	public Response deleteContact(@PathParam("id") int id) {
		contactDao.deleteContact(id);
		return Response
				.noContent()
				.build();
	}
	
	@PUT
	@Path("/{id}")
	public Response updateContact(@PathParam("id") int id, Contact contact) {
		contactDao.updateContact(id, contact.getFirstName(), contact.getLastName(), 
				contact.getPhone());
		return Response
				.ok(new Contact(id, contact.getFirstName(), 
						contact.getLastName(), contact.getPhone()))
				.build();
	}
			
}
