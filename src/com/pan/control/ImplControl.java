package com.pan.control;

import java.sql.SQLException;
import java.util.List;

import com.pan.base.BaseController;
import com.pan.bean.DMissionBean;
import com.pan.bean.LoginBean;
import com.pan.bean.MissionBean;
import com.pan.db.DataBaseManager;
import com.pan.db.ImplDB;

public class ImplControl extends BaseController {

	public boolean auth(LoginBean loginBean) {
		String username = loginBean.getUsername();
		String password = loginBean.getPassword();
		String role = loginBean.getRole();

		ImplDB impl = DataBaseManager.getIns(ImplDB.class);
		try {
			return impl.auth(username, password, role);
		} catch (SQLException e) {
			e.printStackTrace();
		}
        return false;
	}
	
	public List<MissionBean> getMissionsByUserid(String userid) throws SQLException{
		ImplDB impl = DataBaseManager.getIns(ImplDB.class);
		return impl.getMbyUserid(userid);
	}
	
	public String getUseridByName(String username) throws SQLException{
		ImplDB impl = DataBaseManager.getIns(ImplDB.class);
		return impl.getUserdByName(username);
	}
	
	public boolean finishM(String mid) throws SQLException{
		ImplDB impl = DataBaseManager.getIns(ImplDB.class);
		return impl.finishM(mid);
	}
	
	public List<DMissionBean> getDetailByMid(String mid) throws Exception{
		ImplDB impl = DataBaseManager.getIns(ImplDB.class);
		return impl.getDByMid(mid);
	}

}
