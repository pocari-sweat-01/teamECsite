package com.internousdev.georgia.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.internousdev.georgia.dto.PurchaseHistoryInfoDTO;
import com.internousdev.georgia.util.DBConnector;

public class PurchaseHistoryInfoDAO {

	public List<PurchaseHistoryInfoDTO> purchaseHistoryInfo(String userId) {

		DBConnector db = new DBConnector();
		Connection con = db.getConnection();
		List<PurchaseHistoryInfoDTO> purchaseHistoryInfoDTOList = new ArrayList<PurchaseHistoryInfoDTO>();

		String sql = "SELECT"
				+ " phi.id," /*ID*/
				+ " phi.user_id,"/*ユーザID*/
				+ " phi.product_count,"/*個数*/
				+ " pi.product_id,"/*商品ID*/
				+ " pi.product_name,"/*商品名かな*/
				+ " pi.product_name_kana,"/*商品名かな*/
				+ " pi.product_description,"/*商品詳細*/
				+ " pi.category_id,"/*カテゴリID*/
				+ " pi.image_file_name,"/*画像ファイルパス*/
				+ " pi.image_file_path,"/*画像ファイル名*/
				+ " pi.release_company,"/*発売会社名*/
				+ " pi.release_date,"/*発売年月日*/
				+ " phi.price,"/*値段*/
				+ " phi.price * phi.product_count as subtotal,"/*合計金額*/
				+"  phi.regist_date,"/*登録日*/
				+ " di.family_name,"/*姓*/
				+ " di.first_name,"/*名*/
				+ " di.user_address"/*住所*/
				+ " FROM purchase_history_info as phi"
				+ " LEFT JOIN product_info as pi"
				+ " ON phi.product_id = pi.product_id"
				+ " LEFT JOIN destination_info as di"
				+ " ON phi.destination_id = di.id"
				+ " WHERE phi.user_id = ?"
				+ " ORDER BY regist_date DESC";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, userId);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				PurchaseHistoryInfoDTO dto = new PurchaseHistoryInfoDTO();
				dto.setId(rs.getString("id"));
				dto.setUserId(rs.getString("user_id"));
				dto.setProductCount(rs.getString("product_count"));
				dto.setProductId(rs.getString("product_id"));
				dto.setProductName(rs.getString("product_name"));
				dto.setProductNameKana(rs.getString("product_name_kana"));
				dto.setImageFileName(rs.getString("image_file_name"));
				dto.setImageFilePath(rs.getString("image_file_path"));
				dto.setReleaseDate(rs.getDate("release_date"));
				dto.setReleaseCompany(rs.getString("release_company"));
				dto.setProductCount(rs.getString("product_count"));
				dto.setPrice(rs.getInt("price"));
				dto.setSubtotal(rs.getInt("subtotal"));
				dto.setFamilyName(rs.getString("family_name"));
				dto.setFirstName(rs.getString("first_name"));
				dto.setUserAddress(rs.getString("user_address"));
				purchaseHistoryInfoDTOList.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try{
				con.close();
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
		return purchaseHistoryInfoDTOList;

	}

	public int regist(String userId,int productId,int productCount,int price,int destinationId)
	{

		DBConnector db = new DBConnector();
		Connection con = db.getConnection();

		String sql = "INSERT into purchase_history_info"
				+ "(user_id,product_id,product_count,price,destination_id,regist_date,update_date)"
				+ " VALUES(?,?,?,?,?,now(),now())";
		int count = 0;
		try{
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1,userId);
			ps.setInt(2,productId);
			ps.setInt(3, productCount);
			ps.setInt(4, price);
			ps.setInt(5, destinationId);
			count = ps.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			try{
				con.close();
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
		return count;

	}

	public int allDelete(String userId){

		DBConnector db = new DBConnector();
		Connection con = db.getConnection();

		String sql = "DELETE FROM purchase_history_info "
				+ "WHERE user_id = ?";
		int res = 0;
		try{
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, userId);
			res = ps.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			try{
				con.close();
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
		return res;
	}
}
