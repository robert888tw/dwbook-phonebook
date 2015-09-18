package com.dwbook.phonebook;

import io.dropwizard.Configuration;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PhonebookConfiguration extends Configuration{
	@JsonProperty
	private String message;
	
	@JsonProperty
	private int messageRepetitions;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public int getMessageRepetitions() {
		return messageRepetitions;
	}

	public void setMessageRepetitions(int messageRepetitions) {
		this.messageRepetitions = messageRepetitions;
	}
	
	
}
