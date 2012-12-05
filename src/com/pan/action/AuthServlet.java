package com.pan.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.pan.base.BaseServlet;
import com.pan.base.Controller;
import com.pan.base.RequestObjectMapping;
import com.pan.bean.LoginBean;
import com.pan.control.ImplControl;

@Controller("auth")
public class AuthServlet extends BaseServlet {

	private static final long serialVersionUID = 1L;

	public void index(HttpServletRequest request, HttpServletResponse response) throws Exception {
		LoginBean loginBean = RequestObjectMapping.mapToObj(request, LoginBean.class);
		ImplControl impl = getIns(ImplControl.class);
		boolean result = impl.auth(loginBean);
		if (result) {
			String userid = impl.getUseridByName(loginBean.getUsername());
			request.getSession().setAttribute("username", loginBean.getUsername());
			request.getSession().setAttribute("userid", userid);
			if (loginBean.getRole().equals("user")) {
				request.getSession().setAttribute("role", "user");
				response.sendRedirect("index.do");
			} else {
				request.getSession().setAttribute("role", "admin");
				response.sendRedirect("adminindex.do");
			}
		} else {
			response.sendRedirect("login.do?message=wrong username or password");
		}
	}

}
