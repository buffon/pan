package com.pan.action.admin;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pan.base.BaseServlet;
import com.pan.base.Controller;
import com.pan.bean.MissionBean;
import com.pan.db.AdminImplDB;
import com.pan.db.DataBaseManager;
import com.pan.db.ImplDB;

@Controller("filteruser")
public class AdminFilterUserServlet extends BaseServlet {

	private static final long serialVersionUID = 1L;
	
	public void index(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String currentname = null;
		if(request.getParameter("selectedname") != null){
			currentname = request.getParameter("selectedname");
		}else {
			currentname = (String) request.getParameter("currentname");
		}
		
		AdminImplDB impl = DataBaseManager.getIns(AdminImplDB.class);
		ImplDB implU = DataBaseManager.getIns(ImplDB.class);
		List<MissionBean> missions = null;
		if(currentname.equals("all")){
			missions = impl.getAllMissions();
		}else {
			missions = implU.getMbyUserid(implU.getUserdByName(currentname));
		}
		 
		List<String> users = impl.getAllUsername();
		request.setAttribute("missions", missions);
		request.setAttribute("users", users);
		request.setAttribute("currentname", currentname);
		request.getRequestDispatcher("/resource/page/adminIndex.jsp").forward(request, response);
	}

}
