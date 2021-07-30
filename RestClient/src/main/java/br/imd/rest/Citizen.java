package br.imd.rest;

import br.imd.rest.expections.RestRequestException;

public class Citizen {

	public static void main(String[] args) throws RestRequestException {
		Client restClient = new Client();
		restClient.clientSendMessage("policia", "briga", "MEDIA");
		restClient.clientSendMessage("policia", "roubo", "ALTA");
		restClient.clientSendMessage("policia", "assassinato", "URGENTE");
		restClient.clientSendMessage("bombeiros", "incendio", "URGENTE");
		restClient.clientSendMessage("bombeiros", "resgate", "MEDIA");
	}

}
