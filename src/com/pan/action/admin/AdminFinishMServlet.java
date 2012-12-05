package com.pan.action.admin;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pan.base.BaseServlet;
import com.pan.base.Controller;
import com.pan.base.IServletM;
import com.pan.control.ImplControl;

@Controller("adminfinishm")
public class AdminFinishMServlet extends BaseServlet implements IServletM{

	private static final long serialVersionUID = -3719254943702637328L;

	@Override
	public void index(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String currentname = (String) request.getParameter("currentname");
		ImplControl impl = getIns(ImplControl.class);
		boolean result = impl.finishM(request.getParameter("missionid"));
		if(result){
			response.sendRedirect("filteruser.do?currentname=" + currentname);
		}
	}

}
