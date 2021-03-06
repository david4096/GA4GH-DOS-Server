package com.dnastack.dos.server.request;

import com.dnastack.dos.server.model.Ga4ghDataBundle;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateDataBundleRequest {
	
	@Valid
	@NotNull
	private Ga4ghDataBundle data_bundle;
	
}
