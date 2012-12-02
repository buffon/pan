package com.pan.action;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.pan.base.BaseServlet;
import com.pan.base.Controller;
import com.pan.control.ImplControl;

@Controller("finish")
public class FinishMServlet extends BaseServlet {

	private static final long serialVersionUID = -1627122827922402704L;

	public void index(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		ImplControl impl = getIns(ImplControl.class);
		boolean result = impl.finishM(request.getParameter("missionid"));
		if(result){
			response.sendRedirect("index.do");
		}
	}

}
