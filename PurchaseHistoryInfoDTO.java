package com.internousdev.georgia.dto;

import java.util.Date;

public class PurchaseHistoryInfoDTO {

	private String id;
	private String userId;
	private String productId;
	private String productName;
	private String productNameKana;
	private String imageFileName;
	private String imageFilePath;
	private Date releaseDate;
	private String releaseCompany;
	private String productCount;
	private int price;
	private int subtotal;
	private String familyName;
	private String firstName;
	private String userAddress;

	//ID
	public void setId(String id){
		this.id = id;
	}
	public String getId(){
		return id;
	}

	//ユーザーID
	public void setUserId(String userId){
		this.userId = userId;
	}
	public String getUserId(){
		return userId;
	}

	//商品ID
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public String getProductId(){
		return productId;
	}

	//商品名
	public void setProductName(String productName){
		this.productName = productName;
	}
	public String getProductName(){
		return productName;
	}

	//商品名かな
	public void setProductNameKana(String productNameKana){
		this.productNameKana = productNameKana;
	}
	public String getProductNameKana(){
		return productNameKana;
	}

	//画像ファイル名
	public void setImageFileName(String imageFileName){
		this.imageFileName = imageFileName;
	}
	public String getImageFileName(){
		return imageFileName;
	}

	//画像ファイルパス
	public void setImageFilePath(String imageFilePath){
		this.imageFilePath = imageFilePath;
	}
	public String getImageFilePath(){
		return imageFilePath;
	}

	//発売年月日
	public void setReleaseDate(Date releaseDate){
		this.releaseDate = releaseDate;
	}
	public Date getReleaseDate(){
		return releaseDate;
	}

	//発売会社名
	public void setReleaseCompany(String releaseCompany){
		this.releaseCompany = releaseCompany;
	}
	public String getReleaseCompany(){
		return releaseCompany;
	}

	//個数
	public void setProductCount(String productCount){
		this.productCount = productCount;
	}
	public String getProductCount(){
		return productCount;
	}

	//値段
	public void setPrice(int price){
		this.price = price;
	}
	public int getPrice(){
		return price;
	}

	//合計金額
	public void setSubtotal(int subtotal) {
		this.subtotal = subtotal;
	}
	public int getSubtotal(){
		return subtotal;
	}

	//姓
	public void setFamilyName(String familyName){
		this.familyName = familyName;
	}
	public String getFamilyName(){
		return familyName;
	}

	//名
	public void setFirstName(String firstName){
		this.firstName = firstName;
	}
	public String getFirstName(){
		return firstName;
	}

	//メールアドレス
	public void setUserAddress(String userAddress){
		this.userAddress = userAddress;
	}
	public String getUserAddress(){
		return userAddress;
	}
}
