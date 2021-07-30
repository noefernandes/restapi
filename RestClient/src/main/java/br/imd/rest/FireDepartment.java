package br.imd.rest;

import br.imd.rest.expections.RestRequestException;

public class FireDepartment {

	public static void main(String[] args) throws RestRequestException {
		Client restClient = new Client();
		
		restClient.receiveMessageFireDepartment();
	}

}
