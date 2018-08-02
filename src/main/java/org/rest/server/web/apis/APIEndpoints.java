package org.rest.server.web.apis;

import org.rest.server.common.components.ClassCompilationException;
import org.rest.server.runtime.RuntimeCompiler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
public class APIEndpoints {

	@Autowired
	private RuntimeCompiler envrionment;
	
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	@HystrixCommand(fallbackMethod = "getDataFallBack")
	public void addBean() {
		try {
			envrionment.registerBean(null);
		} catch (ClassCompilationException e) {
			e.printStackTrace();
		}		
	}
	
	public String getDataFallBack(String id) {	
		return "Fallback Method Invoked";
	}
	
}

