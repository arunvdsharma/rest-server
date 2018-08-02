package org.rest.server.web.ui.vos;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.rest.server.core.components.MethodBody;

public class BeanVO {

	private String className;
	private String packageName;
	private Class<?> beanClass;
	private List<MethodBody> methods;
	private List<String> importsList;
	private Map<String, String> fields;

	public BeanVO() {
		this.methods = new ArrayList<>();
		this.importsList = new ArrayList<>();
	}

	public BeanVO(String classSignature) {
		this();
		this.className = classSignature;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
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

	public List<MethodBody> getMethods() {
		return methods;
	}

	public void addMethod(MethodBody method) {
		this.methods.add(method);
	}

	public Map<String, String> getFields() {
		return fields;
	}

	public void addField(String fieldName, String fieldType) {
		this.fields.put(fieldName, fieldType);
	}

	public List<String> getImportsList() {
		return importsList;
	}

	public void addImport(String importClass) {
		this.importsList.add(importClass);
	}

}
