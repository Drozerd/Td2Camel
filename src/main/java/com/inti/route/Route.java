package com.inti.route;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;

import com.inti.processor.DynamicRouterBean;
import com.inti.processor.MyProcessor;
import com.inti.processor.ProcessRouting;
import com.inti.processor.ProcessRouting2;
import com.inti.processor.ProcessRouting3;
import com.inti.processor.ProcessRouting4;

public class Route extends RouteBuilder {
	private int count = 0;

	@Override
	public void configure() throws Exception {
		//EX4
//		from("file:C:/inputFolder?noop=true")
//		.split().tokenize("\n")
//		.to("jms:queue:my_queue_FD2");
		
		//EX5
//		from("file:C:/inputFolder?noop=true") //ou direct:test et on met le producerTemplate da ns le main
//		.split().tokenize("\n")
//		.choice()
//		 .when(body().contains("Content"))
//		 .to("jms:queue:my_queue_FD2")
//		.otherwise()
//		 .to("jms:queue:my_queue_FDError");	
		
		//EX6
//		from("file:C:/inputFolder?noop=true")
//		.split().tokenize("\n")
//		.filter(body().contains("Bonjour"))
//		.to("jms:queue:my_queue_FD2");
		
		//EX7
//		from("file:C:/inputFolder?noop=true")
//		.split().tokenize("\n")
//		.process(new MyProcessor())
//		 .recipientList(header("queue"));
		
		
		//EX8
//		from("file:C:/inputFolder?noop=true")
//		.split().tokenize("\n")
//		.to("direct:test1");
//	
//		from("direct:test1")
//		.process(new Processor() {
//			
//			public void process(Exchange exchange) throws Exception {
//				System.out.println("MEssage d'erreur");
//				
//			}
//		})
//		.wireTap("jms:queue:ErreurQueueFD")
//		.to("seda:test2");
//
		
		//EX9
		
//		from("file:C:/inputFolder?noop=true")
//		.split().tokenize("\n")
//		.process(new ProcessRouting())
//		.routingSlip(header("routingSlip"));
//		from("direct:route1")
//		.process(new ProcessRouting2());
//		from("direct:route2")
//		.process(new ProcessRouting3());
//		from("direct:route3")
//		.process(new ProcessRouting4());
		
		//EX10
//		from("file:C:/inputFolder?noop=true")
//		.split().tokenize("\n")
//		.dynamicRouter(method(DynamicRouterBean.class, "route"));
//		from("direct:route1")
//		.process(new ProcessRouting2());
//		from("direct:route2")
//		.process(new ProcessRouting3());
//		from("direct:route3")
//		.process(new ProcessRouting4());
		
		//EX11
//		from("file:C:/inbox?noop=true")
//		.split().tokenize("\n")
//		.loadBalance().roundRobin()
//		.to("jms:queue:java1FD")
//		.to("jms:queue:java2FD")
//		.to("jms:queue:java3FD");
		
		//EX12
		intercept().process(new Processor() {
			
			public void process(Exchange exchange) throws Exception {
				count++;
				System.out.println("Count : " + count + ", message" + exchange.getIn().getBody(String.class));
				
			}
		});
		from("file:C:/inbox?noop=true")
		.split().tokenize("\n")
		.to("jms:queue:java1FD")
		.to("jms:queue:java2FD");
		
		

		
		
		
		
	}

}
