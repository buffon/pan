package com.pan.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pan.base.BaseServlet;
import com.pan.base.Controller;
import com.pan.db.DataBaseManager;
import com.pan.db.ImplDB;

@Controller("finishdm")
public class FinishMDetailServlet extends BaseServlet{
	
	private static final long serialVersionUID = 1L;
	
	public void index(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ImplDB impl = DataBaseManager.getIns(ImplDB.class);
		boolean result = impl.finishMDetail(request.getParameter("dmissionid"));
		if(result){
			String missionid =request.getParameter("missionid");
			response.sendRedirect("mdetail.do?missionid=" + missionid);
		}
	}

}
