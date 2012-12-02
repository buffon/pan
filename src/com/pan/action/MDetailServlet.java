package com.pan.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pan.base.BaseServlet;
import com.pan.base.Controller;
import com.pan.bean.DMissionBean;
import com.pan.control.ImplControl;
import com.pan.db.DataBaseManager;
import com.pan.db.ImplDB;

@Controller("mdetail")
public class MDetailServlet extends BaseServlet {

	private static final long serialVersionUID = 3300244281425275064L;
	
	public void index(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String mid = request.getParameter("missionid");
		// TODO(yehui.chen) Drop controller.
		ImplDB implDB = DataBaseManager.getIns(ImplDB.class);
		String mName = implDB.getMNamebyMid(mid);
		ImplControl impl = getIns(ImplControl.class);
		List<DMissionBean> dmissions = impl.getDetailByMid(mid);
		request.setAttribute("mName", mName);
		request.setAttribute("dmissions", dmissions);
		request.getRequestDispatcher("/resource/page/missiondetail.jsp").forward(request, response);
	}

}
