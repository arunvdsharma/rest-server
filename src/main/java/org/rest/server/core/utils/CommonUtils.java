package org.rest.server.core.utils;

import org.apache.commons.lang3.ObjectUtils;

public class CommonUtils extends ObjectUtils {

	
	public static void checkIfArgumentIsNull(Object... arg){
		for (Object object : arg) {
			if(null == object)
				throw new IllegalArgumentException("Argument(s) can't be null");
		}
	}
	
}
