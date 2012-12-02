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

	public void index(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		LoginBean loginBean = RequestObjectMapping.mapToObj(request, LoginBean.class);
		ImplControl impl = getIns(ImplControl.class);
		boolean result = impl.auth(loginBean);
        
		String page = null;
		if (result) {
			if (loginBean.getRole().equals("user")) {
				System.out.println("user logins");
				request.getSession().setAttribute("username", loginBean.getUsername());
				response.sendRedirect("index.do");
			} else {
				System.out.println("admin logins");
				request.getSession().setAttribute("adminname", loginBean.getUsername());
				response.sendRedirect("adminindex.do");
			}
		} else {
			page = "/Pan/resource/page/login.jsp?message=wrong username or password";
			response.sendRedirect(page);
		}
	}

}
