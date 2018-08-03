package org.rest.server.core.factory;

import org.rest.server.core.components.MethodBody;

class BuilderUtility {

	public static String buildMethod(MethodBody methodBody) {
		StringBuilder sb = new StringBuilder();
		sb.append(methodBody.getRequestMapping()).append("\n"); // Adding
																// RequestMapping
		sb.append(methodBody.getMethodSignature());
		sb.append("{\n");
		methodBody.getBodyStatements().forEach((statement) -> sb.append(statement).append("\n"));
		sb.append("}\n");
		return sb.toString();
	}
}
