package br.imd.restServer;

import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

import br.imd.model.Message;

@Path("messages")
public class RestService {
	ArrayList<Message> messageBuffer;

	public RestService() {
		// TODO Auto-generated constructor stub
		messageBuffer = new ArrayList<Message>();
	}
	
	@GET
	@Path("send-message-police")
	@Produces(MediaType.APPLICATION_JSON)
	public Response sendMessagePolice() {
		
		ArrayList<Message> temp = new ArrayList<Message>();
		
		for(int i = 0; i < messageBuffer.size(); i++) {
			if(messageBuffer.get(i).getDivision().equals("policia")) {
				temp.add(messageBuffer.get(i));
				messageBuffer.remove(i);
			}
		}
		
		return Response.ok(temp).build();
	}
	
	@GET
	@Path("send-message-firedepartment")
	@Produces(MediaType.APPLICATION_JSON)
	public Response sendMessageFireDepartment() {
		
		ArrayList<Message> temp = new ArrayList<Message>();
		
		for(int i = 0; i < messageBuffer.size(); i++) {
			if(messageBuffer.get(i).getDivision().equals("bombeiros")) {
				temp.add(messageBuffer.get(i));
				messageBuffer.remove(i);
			}
		}
		
		return Response.ok(temp).build();
	}

	@GET
	@Path("receive-message-citizen")
	@Produces(MediaType.APPLICATION_JSON)
	public Response receiveMessageCitizen(@QueryParam("division") String division, 
			@QueryParam("type") String type, @QueryParam("priority") String priority) {

		Message message = new Message(division, type, priority);
		messageBuffer.add(message);
		
		return Response.ok(messageBuffer).build();
	}
		
}
