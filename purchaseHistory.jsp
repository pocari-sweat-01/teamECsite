<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="./css/button.css">
<link rel="stylesheet" href="./css/header.css">
<link rel="stylesheet" href="./css/horizonList.css">
<link rel="stylesheet" href="./css/message.css">
<link rel="stylesheet" href="./css/title.css">

<title>商品購入履歴一覧画面</title>
</head>
<body>

	<jsp:include page="header.jsp" />
	<div id = main>
	<div id = top>
		<h1>商品購入履歴一覧</h1>
	</div>
		<div>

			<s:if test="purchaseHistoryInfoDTOList !=null && purchaseHistoryInfoDTOList.size()>0">
				<table class="horizon_list">
					<tbody>
					<tr>
						<th>商品名</th>
						<th>ふりがな</th>
						<th>商品画像</th>
						<th>発売会社名</th>
						<th>発売年月日</th>
						<th>値段</th>
						<th>個数</th>
						<th>合計金額</th>
						<th>宛先名前</th>
						<th>宛先住所</th>
					</tr>
					</tbody>
					<tbody>
					<s:iterator value="purchaseHistoryInfoDTOList">
						<tr>
						<td><s:property value="productName"/></td>
						<td><s:property value="productNameKana"/></td>
						<td><img src='<s:property value="imageFilePath"/>/<s:property value="imageFileName"/>' width="50px" height="50px"/></td>
						<td><s:property value="releaseCompany"/></td>
						<td><s:property value="releaseDate"/></td>
						<td><s:property value="price"/></td>
						<td><s:property value="productCount"/></td>
						<td><s:property value="subtotal"/></td>
						<td><s:property value="familyName"/><span>　</span><s:property value="firstName"/></td>
						<td><s:property value="userAddress"/></td>
						</tr>
					</s:iterator>
					</tbody>
				</table>
				<div id="btn_position">
				<s:form action="DeletePurchaseHistoryAction">
					<s:submit class="submit_btn" value="履歴削除"/>
				</s:form>
				</div>
			</s:if>
			<s:else>
			<div class="message_blue">
				<p>商品購入履歴情報がありません。</p>
			</div>
			</s:else>
		</div>
	</div>
</body>
</html>