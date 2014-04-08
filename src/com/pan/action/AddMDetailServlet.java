package com.pan.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pan.base.BaseBean;
import com.pan.base.Controller;
import com.pan.db.DataBaseManager;
import com.pan.db.ImplDB;

@Controller("addmdtetail")
public class AddMDetailServlet extends BaseBean {

	private static final long serialVersionUID = 1L;
	
	public void index(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		ImplDB impl = DataBaseManager.getIns(ImplDB.class);
		String helperid = impl.getUserdByName(request.getParameter("helpername"));
		String missionid = request.getParameter("missionid");
		String content = request.getParameter("content").trim();
		boolean result = impl.addMDetail(missionid, helperid,content);
		if(result){
			response.sendRedirect("mdetail.do?missionid=" + missionid);
            response.setStatus(404);
		}
	}

}
