package org.rest.server.app.controller;

import org.rest.server.app.facade.AppFacade;
import org.rest.server.core.exception.ClassCompilationException;
import org.rest.server.core.runtime.RuntimeCompiler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
public class APIEndpoints {

	@Autowired
	private AppFacade envrionment;
	
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	@HystrixCommand(fallbackMethod = "getDataFallBack")
	public void addBean() {
		try {
			envrionment.createControllerClass(null);
		} catch (ClassCompilationException e) {
			e.printStackTrace();
		}		
	}
	
	public String getDataFallBack(String id) {	
		return "Fallback Method Invoked";
	}
	
}

