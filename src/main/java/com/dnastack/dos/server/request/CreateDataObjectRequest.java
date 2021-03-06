package com.dnastack.dos.server.request;

import com.dnastack.dos.server.model.Ga4ghDataObject;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateDataObjectRequest {
	
	@Valid	//needed for custom validation since it's a nested json object
	@NotNull
	private Ga4ghDataObject data_object;
	
}