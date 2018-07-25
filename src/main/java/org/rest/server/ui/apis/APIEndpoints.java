package org.rest.server.ui.apis;

import org.rest.server.runtime.Compiler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
public class APIEndpoints {

	@Autowired
	private Compiler envrionment;
	
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	@HystrixCommand(fallbackMethod = "getDataFallBack")
	public void addBean() {
		envrionment.registerBean("testBean", null);
		
	}
	
	public String getDataFallBack(String id) {	
		return "Fallback Method Invoked";
	}
	
}

