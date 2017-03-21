package com.example.camel.rest.routes;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.rest.RestBindingMode;

public class GreetingRoute extends RouteBuilder {

	@Override
	public void configure() throws Exception {
		restConfiguration().component("servlet").bindingMode(RestBindingMode.off);


		rest("greeting")
			.get().to("direct:greeting");


		from("direct:greeting")
			.transform().constant("Hello");
	}

}
