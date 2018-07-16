package org.rest.server.runtime;

import java.lang.reflect.Method;

import org.rest.server.components.Bean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import net.openhft.compiler.CompilerUtils;

@Component
class RuntimeEnvironmentImpl implements RuntimeEnvironment {

	@Autowired
	private ServerContainer container;

	private StringBuilder sb = new StringBuilder();

	public RuntimeEnvironmentImpl() {

		sb.append("package com.test.config;\n");
		sb.append("import org.springframework.web.bind.annotation.*;\n");
		sb.append("@RestController\n");
		sb.append("public class MyController extends org.rest.server.components.Bean{\n");

		sb.append("@RequestMapping(value = \"/test\", method = RequestMethod.GET)\n");
		sb.append("public String test() {\n");
		sb.append("return \"This is a runtime controller\";\n");
		sb.append("}\n");

		sb.append("public void doSomething () {\n");
		sb.append("System.out.println(\"from my bean, date: \" + (new java.util.Date()));\n");
		sb.append("}\n");
		sb.append("\n");
		sb.append("}\n");
	}

	private String createController() {
		return sb.toString();
	}

	public Class<?> compile(Bean controller) {
		Class<?> aClass = null;
		try {
			aClass = CompilerUtils.CACHED_COMPILER.loadFromJava("com.test.config.MyController", createController());
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return aClass;
	}

	@Override
	public void registerBean(String beanName, Bean bean) {
		Class<?> aClass = this.compile(bean);
		try {
			Bean beanObj = (Bean) aClass.newInstance();
			container.registerController("testBean", beanObj);
			this.invokeMethod("", beanObj);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public void invokeMethod(String methodName, Bean beanObject) {
		Method[] methods = beanObject.getClass().getMethods();

		for (Method method : methods) {
			if (method.getName().equals(methodName)) {
				try {
					method.invoke(beanObject);
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		}
	}

}
