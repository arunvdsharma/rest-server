package org.rest.server.common.utils;

import org.apache.commons.lang3.ObjectUtils;

public class CommonUtils extends ObjectUtils {

	
	public static void checkIfArgumentIsNull(String argumentName, Object... arg){
		for (Object object : arg) {
			if(null == object)
				throw new IllegalArgumentException("'"+argumentName+"' can't be null");
		}
	}
	
}
