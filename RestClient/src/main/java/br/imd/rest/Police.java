package br.imd.rest;

import br.imd.rest.expections.RestRequestException;

public class Police {

	public static void main(String[] args) throws RestRequestException {
		Client restClient = new Client();
		
		restClient.receiveMessagePolice();
	}

}
