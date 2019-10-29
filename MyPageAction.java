package com.internousdev.georgia.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.georgia.dao.UserInfoDAO;
import com.internousdev.georgia.dto.UserInfoDTO;
import com.opensymphony.xwork2.ActionSupport;

public class MyPageAction extends ActionSupport implements SessionAware{

	private Map<String,Object>session;
	UserInfoDTO userInfoDTO;

	public String execute(){

		//ユーザー情報を持っているか判別//
		if(!session.containsKey("tempUserId") && !session.containsKey("userId")){
			return "sessionTimeout";
		}

		//ログイン状態か判別//
		int logined = Integer.parseInt(String.valueOf(session.get("logined")));
		if(logined != 1){
			return "sessionTimeout";
		}

		//マイページに必要な情報の呼び出し//
		UserInfoDAO userInfoDAO = new UserInfoDAO();
		userInfoDTO = userInfoDAO.getUserInfo(String.valueOf(session.get("userId")));

		//例外でユーザーIDがない場合、余計な情報が出ないように初期化する。//
		if(userInfoDTO.getUserId() == null){
			userInfoDTO = null;
		}

		return SUCCESS;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
	public Map<String,Object> getSession(){
		return session;
	}

	public UserInfoDTO getUserInfoDTO() {
		return userInfoDTO;
	}
	public void setUserInfoDTO(UserInfoDTO userInfoDTO) {
		this.userInfoDTO = userInfoDTO;
	}

}
