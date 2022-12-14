package com.inti.processor;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

public class MyProcessor implements Processor {

	public void process(Exchange exchange) throws Exception {
		String message = exchange.getIn().getBody(String.class);
		message ="jms:queue:Queueu_Ex_7" + message;
		exchange.getIn().setHeader("queue", message);
		//exchange.getOut().setBody( "jms:queue:Queueu_Ex_7" + message  , String.class);
		//System.out.println(message);
		

		
	}
	

}
