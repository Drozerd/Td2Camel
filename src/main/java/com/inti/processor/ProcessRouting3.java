package com.inti.processor;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

public class ProcessRouting3 implements Processor {

	public void process(Exchange exchange) throws Exception {
		String message = exchange.getIn().getBody(String.class);
		message+="dans route 2";
		System.out.println(message);
		exchange.getOut().setBody(message);
		
		
		
	}

}
