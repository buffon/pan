package com.pan.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pan.base.BaseServlet;
import com.pan.base.Controller;
import com.pan.bean.MissionBean;
import com.pan.control.ImplControl;

@Controller("index")
public class IndexServlet extends BaseServlet {

	private static final long serialVersionUID = 1L;

	public void index(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String username = (String) request.getSession().getAttribute("username");
		ImplControl impl = getIns(ImplControl.class);
		List<MissionBean> missions = impl.getMissionsByUserid(impl.getUseridByName(username));
		request.setAttribute("missions", missions);
		request.getRequestDispatcher("/resource/page/index.jsp").forward(request, response);
	}

}
