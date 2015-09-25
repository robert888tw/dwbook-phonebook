package com.dwbook.phonebook.auth;

import io.dropwizard.auth.AuthenticationException;
import io.dropwizard.auth.Authenticator;
import io.dropwizard.auth.basic.BasicCredentials;

import com.google.common.base.Optional;

public class PhonebookAuthenticator implements Authenticator<BasicCredentials, Boolean>{
	
	public Optional<Boolean> authenticate(BasicCredentials c) throws AuthenticationException {
		if(c.getUsername().equals("john_doe") && c.getPassword().equals("secret")) {
			return Optional.of(true);
		}
		else {
			return Optional.absent();
		}
	}
	
}
