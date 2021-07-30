package br.imd.rest;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import br.imd.rest.expections.RestRequestException;

public class Client {

	public Client() {
		// TODO Auto-generated constructor stub
	}

	public void receiveMessagePolice() throws RestRequestException {

		String uri = "http://localhost:8080/RestServer/restapi/messages/send-message-police";
		Map<String, String> headerParams = new HashMap<String, String>();

		headerParams.put("accept", "application/json");
		
		while(true) {
			String response = HttpUtils.httpGetRequest(uri, headerParams);
			if(!response.equals("[]")) {
				System.out.println(response);
			}
		}
	}

	public void receiveMessageFireDepartment() throws RestRequestException {

		String uri = "http://localhost:8080/RestServer/restapi/messages/send-message-firedepartment";
		Map<String, String> headerParams = new HashMap<String, String>();

		headerParams.put("accept", "application/json");
		
		while(true) {
			String response = HttpUtils.httpGetRequest(uri, headerParams);
			if(!response.equals("[]")) {
				System.out.println(response);
			}
		}
	}
	
	public void clientSendMessage(String division_, String type_, String priority_) throws RestRequestException {

		String division = division_;
		String type = type_;
		String priority = priority_;
		String uri = "http://localhost:8080/RestServer/restapi/messages/receive-message-citizen"
				+ "?division="+division+"&type="+type+"&priority="+priority;
		Map<String, String> headerParams = new HashMap<String, String>();

		headerParams.put("accept", "application/json");

		String response = HttpUtils.httpGetRequest(uri, headerParams);

		System.out.println(response);
	}
	
}
