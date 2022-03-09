package com.askme.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "accDetails")

public class AccountDetails {

	@Id
	private String id;
	private String queryName;
	private String queryDescription;
	
	public AccountDetails(String queryName, String queryDescription) {
		super();
		this.queryName = queryName;
		this.queryDescription = queryDescription;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getQueryName() {
		return queryName;
	}

	public void setQueryName(String queryName) {
		this.queryName = queryName;
	}

	public String getQueryDescription() {
		return queryDescription;
	}

	public void setQueryDescription(String queryDescription) {
		this.queryDescription = queryDescription;
	}
	
	
	
}
