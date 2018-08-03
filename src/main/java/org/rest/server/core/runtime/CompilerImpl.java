package org.rest.server.core.runtime;

import java.lang.reflect.Method;

import org.rest.server.core.components.Bean;
import org.rest.server.core.exception.ClassCompilationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import net.openhft.compiler.CompilerUtils;

@Component
class CompilerImpl implements RuntimeCompiler {

	@Autowired
	private ServerContainer container;

	/**
	 * The 'compile' method mainly does two jobs: 
	 * 		1. It create a Java Class from the 'bean' parameter
	 * 		2. Once the class is compiled c
	 * @param bean
	 * @return
	 */
	private Class<?> compile(Bean bean) throws ClassCompilationException {
		Class<?> clazz = null;
		try {
			clazz = CompilerUtils.CACHED_COMPILER.loadFromJava(bean.getClassCanonicalName(), bean.getJavaCode());
		} catch (Exception ex) {
			throw new ClassCompilationException(ex);
		}
		return clazz;
	}

	@Override
	public void registerBean(Bean bean) throws ClassCompilationException {
		Class<?> aClass = this.compile(bean);
		try {
			Bean beanObj = (Bean) aClass.newInstance();
			container.registerBean("testBean", beanObj);
			this.invokeMethod("", beanObj);
		} catch (Exception ex) {
			throw new ClassCompilationException(ex);
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
