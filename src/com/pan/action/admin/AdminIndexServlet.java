package com.pan.action.admin;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pan.base.BaseServlet;
import com.pan.base.Controller;
import com.pan.bean.MissionBean;
import com.pan.db.AdminImplDB;
import com.pan.db.DataBaseManager;

@Controller("adminindex")
public class AdminIndexServlet extends BaseServlet {

	private static final long serialVersionUID = 1L;
	
	public void index(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		AdminImplDB impl = DataBaseManager.getIns(AdminImplDB.class);
		List<MissionBean> missions = impl.getAllMissions();
		List<String> users = impl.getAllUsername();
		request.setAttribute("missions", missions);
		request.setAttribute("users", users);
		request.getRequestDispatcher("/resource/page/adminIndex.jsp").forward(request, response);
	}

}
