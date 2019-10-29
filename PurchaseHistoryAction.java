package com.internousdev.georgia.action;

import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.georgia.dao.PurchaseHistoryInfoDAO;
import com.internousdev.georgia.dto.PurchaseHistoryInfoDTO;
import com.opensymphony.xwork2.ActionSupport;

public class PurchaseHistoryAction extends ActionSupport implements SessionAware{

	private List<PurchaseHistoryInfoDTO>purchaseHistoryInfoDTOList;
	private Map<String,Object>session;

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

		//購入履歴の呼び出し//
		PurchaseHistoryInfoDAO purchaseHistoryInfoDAO= new PurchaseHistoryInfoDAO();
		purchaseHistoryInfoDTOList = purchaseHistoryInfoDAO.purchaseHistoryInfo(String.valueOf(session.get("userId")));

		return SUCCESS;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
	public Map<String,Object> getSession(){
		return session;
	}

	public List<PurchaseHistoryInfoDTO> getPurchaseHistoryInfoDTOList(){
		return this.purchaseHistoryInfoDTOList;
	}
	public void setPurchaseHistoryInfoDTOList(List<PurchaseHistoryInfoDTO> purchaseHistoryInfoDTOList){
		this.purchaseHistoryInfoDTOList = purchaseHistoryInfoDTOList;
	}
}
