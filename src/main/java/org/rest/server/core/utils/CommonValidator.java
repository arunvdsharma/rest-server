package org.rest.server.core.utils;

import static org.junit.Assert.assertNotNull;

public class CommonValidator {

	public static void throwExceptionIfNull(Object... arg){
		for (Object object : arg) {
			assertNotNull(object);
		}
	}
}
