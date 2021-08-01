package br.imd.rest;

import br.imd.rest.expections.RestRequestException;

public class Citizen {

	public static void main(String[] args) throws RestRequestException {
		Client restClient = new Client();
		restClient.clientSendMessage("policia", "roubo", "");
		restClient.clientSendMessage("policia", "assassinato", "");
		restClient.clientSendMessage("bombeiros", "incendio", "");
		restClient.clientSendMessage("bombeiros", "resgate", "");
	}

}
