package org.rest.server.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.rest.server.app.vo.APIBeanVO;
import org.rest.server.core.components.Bean;
import org.rest.server.core.components.BeanType;
import org.rest.server.core.components.MethodBody;
import org.rest.server.core.exception.ClassCompilationException;
import org.rest.server.core.factory.APIBeanFactory;
import org.rest.server.core.runtime.RuntimeCompiler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class APIBeanFactoryTest {

	@Autowired
	private APIBeanFactory beanFactory;
	
	@Autowired
	private RuntimeCompiler compiler;

	/**
	 * sb.append("package com.test.config;\n");
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

	 */
	@Test
	public void testGetBean() {
		APIBeanVO beanVO = new APIBeanVO();
		beanVO.setClassName("MyClass");
		beanVO.setPackageName("com.test.config");
		beanVO.addImport("org.springframework.web.bind.annotation.*");
		
		MethodBody methodBody = new MethodBody();
		methodBody.setMethodSignature("public void doSomething ()");
		methodBody.setRequestMapping("@RequestMapping(value = \"/test\", method = RequestMethod.GET)");
		methodBody.addStatement("System.out.println(\"from my bean, date: \" + (new java.util.Date()));");
		
		beanVO.addMethod(methodBody);
		
		Bean bean = beanFactory.createBeanClass(BeanType.CONTROLLER, beanVO);
		
		System.out.println(bean.getJavaCode());
		try {
			compiler.registerBean(bean);
		} catch (ClassCompilationException e) {
			e.printStackTrace();
		}
		

	}

}
