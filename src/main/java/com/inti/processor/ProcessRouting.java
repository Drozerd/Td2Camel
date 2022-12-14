package com.inti.processor;

import org.apache.activemq.command.Response;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;

public class ProcessRouting implements Processor {
	

	public void process(Exchange exchange) throws Exception {
		String message = exchange.getIn().getBody(String.class);
		String response;
		
		if(message.contains("monBody")) 
		{
			response = "direct:route1,direct:route2,direct:route3";
		}
		else 
		{
			response = "direct:route3,direct:route2,direct:route1";
		}
		exchange.getIn().setHeader("routingSlip", response);
	}

}
