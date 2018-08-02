package org.rest.server.core.components;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Bean {

	private String className;
	private String classCanonicalName;
	private String packageName;
	private Class<?> beanClass;
	private List<MethodBody> methods;
	private List<String> importsList;
	private Map<String, String> fields;
	private String javaCode;

	public Bean(){
		this(null);
	}
	
	public Bean(String className) {
		this.className = className;
		this.methods = new ArrayList<>();
		this.importsList = new ArrayList<>();
	}

	public String getClassCanonicalName() {
		return classCanonicalName;
	}

	public void setClassCanonicalName(String classCanonicalName) {
		this.classCanonicalName = classCanonicalName;
	}

	public String getPackageName() {
		return packageName;
	}

	public void setPackageName(String packageName) {
		this.packageName = packageName;
	}

	public Class<?> getBeanClass() {
		return beanClass;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getJavaCode() {
		return javaCode;
	}

	public void setJavaCode(String javaCode) {
		this.javaCode = javaCode;
	}

	public void setBeanClass(Class<?> beanClass) {
		this.beanClass = beanClass;
	}

	public List<MethodBody> getMethods() {
		return methods;
	}

	public void addMethod(MethodBody method) {
		this.methods.add(method);
	}

	public void setMethods(List<MethodBody> methods) {
		this.methods = methods;
	}

	public void setImportsList(List<String> importsList) {
		this.importsList = importsList;
	}

	public Map<String, String> getFields() {
		return fields;
	}

	public void setFields(Map<String, String> fields) {
		this.fields = fields;
	}

	public List<String> getImportsList() {
		return importsList;
	}

	public void addImport(String importClass) {
		this.importsList.add(importClass);
	}

}
