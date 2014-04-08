package com.pan.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pan.base.BaseServlet;
import com.pan.base.Controller;
import com.pan.base.RequestMapping;
import com.pan.base.RequestObjectMapping;
import com.pan.bean.LoginBean;
import com.pan.bean.MissionBean;
import com.pan.control.ImplControl;
import com.pan.db.DataBaseManager;
import com.pan.db.ImplDB;

import java.util.List;

@Controller
public class MissionServlet extends BaseServlet {

    private static final long serialVersionUID = 1L;

    @RequestMapping("/login")
    public void login(HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        request.setAttribute("message", request.getParameter("message"));
        request.getRequestDispatcher("/resource/page/login.jsp").forward(request, response);
    }

    @RequestMapping("/logout")
    public void logout(HttpServletRequest request, HttpServletResponse response) throws Exception {
        request.getSession().removeAttribute("username");
        response.sendRedirect("login.do");
    }

    @RequestMapping("/finish")
    public void finishm(HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        ImplControl impl = getIns(ImplControl.class);
        boolean result = impl.finishM(request.getParameter("missionid"));
        if(result){
            response.sendRedirect("index.do");
        }
    }

    @RequestMapping("/finishdm")
    public void finishdm(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ImplDB impl = DataBaseManager.getIns(ImplDB.class);
        boolean result = impl.finishMDetail(request.getParameter("dmissionid"));
        if(result){
            String missionid =request.getParameter("missionid");
            response.sendRedirect("mdetail.do?missionid=" + missionid);
        }
    }

    @RequestMapping("/auth")
    public void auth(HttpServletRequest request, HttpServletResponse response) throws Exception {
        LoginBean loginBean = RequestObjectMapping.mapToObj(request, LoginBean.class);
        ImplControl impl = getIns(ImplControl.class);
        boolean result = impl.auth(loginBean);
        if (result) {
            String userid = impl.getUseridByName(loginBean.getUsername());
            request.getSession().setAttribute("username", loginBean.getUsername());
            request.getSession().setAttribute("userid", userid);
            if (loginBean.getRole().equals("user")) {
                request.getSession().setAttribute("role", "user");
                response.sendRedirect("index.do");
            } else {
                request.getSession().setAttribute("role", "admin");
                response.sendRedirect("adminindex.do");
            }
        } else {
            response.sendRedirect("login.do?message=wrong username or password");
        }
    }

    @RequestMapping("/addmission")
    public void addmission(HttpServletRequest request, HttpServletResponse response) throws Exception {
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

    @RequestMapping("/index")
    public void index(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String username = (String) request.getSession().getAttribute("username");
        ImplControl impl = getIns(ImplControl.class);
        List<MissionBean> missions = impl.getMissionsByUserid(impl.getUseridByName(username));
        request.setAttribute("missions", missions);
        request.getRequestDispatcher("/resource/page/index.jsp").forward(request, response);
    }

    @RequestMapping("addmdtetail")
    public void addmdtetail(HttpServletRequest request, HttpServletResponse response)
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
