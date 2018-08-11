package org.rest.server.core.runtime;

import java.lang.reflect.Method;

import org.apache.commons.lang.StringUtils;
import org.rest.server.core.components.BeanClass;
import org.rest.server.core.exception.ClassCompilationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import net.openhft.compiler.CompilerUtils;

/**
 * 
 * @author Arun Sharma
 *
 */
@Component
class CompilerImpl implements RuntimeCompiler {

	@Autowired
	private BeanContext beanContext;

	/**
	 * The 'compile' method mainly does two jobs: 
	 * 		1. It create a Java Class from the 'bean' parameter
	 * 		2. Once the class is compiled c
	 * @param bean
	 * @return
	 */
	private Class<?> compile(BeanClass bean) throws ClassCompilationException {
		Class<?> clazz = null;
		try {
			clazz = CompilerUtils.CACHED_COMPILER.loadFromJava(bean.getClassCanonicalName(), bean.getJavaCode());
		} catch (Exception ex) {
			throw new ClassCompilationException(ex);
		}
		return clazz;
	}

	@Override
	public void registerBean(BeanClass bean) throws ClassCompilationException {
		Class<?> aClass = this.compile(bean);
		try {
			BeanClass beanObj = (BeanClass) aClass.newInstance();
			beanContext.registerBean(beanObj.getClassName().toLowerCase(), beanObj);
			this.invokeMethod(StringUtils.EMPTY, beanObj);
		} catch (Exception ex) {
			throw new ClassCompilationException(ex);
		}
	}
	
	
	
	private void invokeMethod(String methodName, BeanClass beanObject) throws ClassCompilationException {
		Method[] methods = beanObject.getClass().getMethods();

		for (Method method : methods) {
			if (method.getName().equals(methodName)) {
				try {
					method.invoke(beanObject);
				} catch (Exception ex) {
					throw new ClassCompilationException(ex);
				}
			}
		}
	}

}
