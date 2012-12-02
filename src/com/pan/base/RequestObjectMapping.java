package com.pan.base;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import javax.servlet.http.HttpServletRequest;

public class RequestObjectMapping {
	
	public static <T extends BaseBean> T mapToObj(HttpServletRequest request,Class<T> clazz){
		T object = null;
		try {
			object = (T)clazz.newInstance();
			Field[] fields = clazz.getDeclaredFields();
			for(Field field:fields){
				if(request.getParameter(field.getName()) != null){
					String str = "set"+field.getName().substring(0,1).toUpperCase() + field.getName().substring(1);
					Method method = clazz.getMethod(str, String.class);
					method.invoke(object,request.getParameter(field.getName()));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return object;
		
	}

}
