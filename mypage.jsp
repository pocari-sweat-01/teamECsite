<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="./css/button.css">
<link rel="stylesheet" href="./css/header.css">
<link rel="stylesheet" href="./css/verticalList.css">
<link rel="stylesheet" href="./css/message.css">
<link rel="stylesheet" href="./css/title.css">
<title>マイページ画面</title>
</head>
<body>
	<jsp:include page="header.jsp" />
	<div id="main">
	<div id="top">
		<h1>マイページ画面</h1>
	</div>
		<div>

		<s:if test="userInfoDTO != null">
			<s:form action="PurchaseHistoryAction">
				<table class="vertical_list">
					<tr>
						<th><s:label value="姓"/></th>
						<td><s:property value="userInfoDTO.familyName"/></td>
					</tr>
					<tr>
						<th><s:label value="名"/></th>
						<td><s:property value="userInfoDTO.firstName"/></td>
					</tr>
					<tr>
						<th><s:label value="ふりがな"/></th>
						<td><s:property value="userInfoDTO.familyNameKana"/><span>　</span><s:property value="userInfoDTO.firstNameKana"/></td>
					</tr>
					<tr>
						<th><s:label value="性別"/></th>
						<td><s:if test="userInfoDTO.userSex==1">女性</s:if><s:else>男性</s:else></td>
					</tr>
					<tr>
						<th><s:label value="メールアドレス"/></th>
						<td><s:property value="userInfoDTO.userEmail"/></td>
					</tr>
					</table>
					<div id="btn_position">
						<s:submit class="submit_btn" value="購入履歴" />
					</div>
			</s:form>
		</s:if>
		<s:else>
			<div class="message_blue">
				<p>ユーザー情報がありません。</p>
			</div>
		</s:else>
	</div>
	</div>
</body>
</html>