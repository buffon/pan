package com.pan.base;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public  class BaseServlet extends HttpServlet {

	private static final long serialVersionUID = 5107642186270756640L;
	
	public static <T extends BaseController> T getIns(Class<T> clazz){
		try {
			return (T) clazz.newInstance();
		} catch (Exception e) {
			return null;
		}
			
	}

	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		String uri = request.getRequestURI();
        System.out.println("before uri = " + uri);
		uri = uri.substring(request.getContextPath().length(), uri.length() - 3);
		String[] array = uri.split("/");
		uri = array[array.length-1];
		if(uri.contains("?")){
			uri = uri.substring(0 ,uri.indexOf("?"));
		}
		System.out.println("after uri = " + uri);
		@SuppressWarnings("unchecked")
		Map<String, Object> map = (Map<String, Object>) this
				.getServletContext().getAttribute("mapPath");

		if (map.containsKey(uri)) {

			Object obj = map.get(uri);

			String methodName = request.getParameter("method");

			if (methodName == null) {
				methodName = "index";
			}
			Method method = null;
			try {

				method = obj.getClass().getMethod(methodName, HttpServletRequest.class, HttpServletResponse.class);
			} catch (Exception e) {
				throw new RuntimeException("in" + obj.getClass().getName()
						+ " can not find method " + methodName);
			}
			try {
				method.invoke(obj, request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
