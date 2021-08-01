package br.imd.restServer;

import java.util.ArrayList;
import java.util.HashMap;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.imd.model.Message;

@Path("messages")
public class RestService {
	ArrayList<Message> messageBuffer;
	HashMap<String, String> map;

	public RestService() {
		messageBuffer = new ArrayList<Message>();
		map = new HashMap<String, String>();
		map.put("assassinato", "URGENTE");
		map.put("roubo", "ALTA");
		map.put("incendio", "URGENTE");
		map.put("resgate", "ALTA");
	}
	
	@GET
	@Path("send-message-police")
	@Produces(MediaType.APPLICATION_JSON)
	public Response sendMessagePolice() {
		
		ArrayList<Message> temp = new ArrayList<Message>();
		
		for(int i = 0; i < messageBuffer.size(); i++) {
			if(messageBuffer.get(i).getDivision().equals("policia")) {
				Message m = messageBuffer.get(i);
				m.setPriority(map.get(m.getType()));
				temp.add(m);
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
				Message m = messageBuffer.get(i);
				m.setPriority(map.get(m.getType()));
				temp.add(m);
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
