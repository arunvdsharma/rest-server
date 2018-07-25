package org.rest.server.ui.vos;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.rest.server.core.components.MethodBody;

public class BeanVO {

	private String classSignature;
	private String packageName;
	private Class<?> beanClass;
	private List<MethodBody> methods;
	private List<String> importsList;
	private Map<String, String> fields;
	
	public BeanVO(String classSignature) {
		this.classSignature = classSignature;
		this.methods = new ArrayList<>();
		this.importsList = new ArrayList<>();
	}
	
	
	public String getClassSignature() {
		return classSignature;
	}


	public void setClassSignature(String classSignature) {
		this.classSignature = classSignature;
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
	public void setBeanClass(Class<?> beanClass) {
		this.beanClass = beanClass;
	}
	public List<MethodBody> getMethods() {
		return methods;
	}
	public void addMethod(MethodBody method) {
		this.methods.add(method);
	}
	
	public Map<String, String> getFields() {
		return fields;
	}
	
	public void setFields(Map<String, String> fields) {
		this.fields = fields;
	}
	
	public List<String> getImportsList(){
		return importsList;
	}
	
	public void addImport(String importClass){
		this.importsList.add(importClass);
	}

}
