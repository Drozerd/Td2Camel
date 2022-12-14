package com.inti.processor;

import org.apache.camel.Exchange;
import org.apache.camel.Header;

public class DynamicRouterBean {
	
	public String route (String body, @Header(Exchange.SLIP_ENDPOINT) String previousRoute) 
	{
		if (previousRoute == null  ) 
		{
			return "direct://route3";
		}
		else if (body.equals("dans route 3"))
				{
					return "direct://route2";
				}
		else if (body.equals("dans route 3 dans route 2")) 
		{
			return "direct://route1";
		}
		else 
		return null;
	}
	

}
