package com.pan.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pan.base.BaseServlet;
import com.pan.base.Controller;

@Controller("login")
public class LoginServlet extends BaseServlet {

	private static final long serialVersionUID = 1L;

	public void index(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		request.getRequestDispatcher("/resource/page/login.jsp").forward(
				request, response);
	}

}
