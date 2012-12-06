package com.pan.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pan.base.BaseServlet;
import com.pan.base.Controller;
import com.pan.db.DataBaseManager;
import com.pan.db.ImplDB;

@Controller("addmission")
public class AddMServlet extends BaseServlet {

	private static final long serialVersionUID = 1L;
	
	public void index(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ImplDB impl = DataBaseManager.getIns(ImplDB.class);
		String missionname = request.getParameter("missionname").trim();
		String missiondiscrip = request.getParameter("description").trim();
		String userid = impl.getUserdByName((String) request.getSession().getAttribute("username"));
		boolean result = impl.addM(missionname, missiondiscrip, userid);
		System.out.println("addMission res = " + result);
		if(result){
			response.sendRedirect("index.do");
		}
	}

}
