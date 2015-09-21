package com.dwbook.phonebook;

import io.dropwizard.Configuration;
import io.dropwizard.db.DataSourceFactory;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PhonebookConfiguration extends Configuration{
	@JsonProperty
	private String message;
	
	@JsonProperty
	private int messageRepetitions;
	
	@JsonProperty
	private DataSourceFactory database = new DataSourceFactory();
	
	public DataSourceFactory getDataSourceFactory() {
		return database;
	}

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
