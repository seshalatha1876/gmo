<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login</title>
</head>

<style>
.center {
	margin: 10px;
	padding: 30px;
	position: absolute;
	top: 30%;
	left: 30%;
}
</style>

<body>
	<table align="center">
		<tr>
			<td style="font-style: italic; color: red;">${message}</td>
		</tr>
	</table>
	<form:form id="loginForm" modelAttribute="login" action="loginProcess"	method="post">
		<table align="center" class="center" frame="box">
			<tr>
				<td width="90px"><form:label path="username">ログインID: </form:label></td>
				<td width="30px">&nbsp;</td>
				<td width="120px" colspan="2"><form:input size="40"
						path="username" name="username" id="username" /></td>
			</tr>

			<tr>
				<td height="20px"></td>
			</tr>

			<tr>
				<td width="90px"><form:label path="password">パスワード:</form:label></td>
				<td width="30px">&nbsp;</td>
				<td width="120px" colspan="2"><form:password size="40"
						path="password" name="password" id="password" /></td>
			</tr>
			<tr>
				<td height="20px"></td>
			</tr>
			<tr>
				<td width="120px" colspan="2">&nbsp;</td>
				<c:if test="${identifier == '0'}">
					<td width="60px" align="left" width="40px"><form:button
							id="login" name="login">ログイン</form:button></td>
					<td width="60px" align="right" width="40px"><form:button
							id="register" name="register">アカウント新規登録</form:button></td>
				</c:if>
				<c:if test="${identifier == '1'}">
					<td width="120px" align="right" colspan="2"><form:button
							id="registerNew" name="registerNew">登録</form:button></td>
				</c:if>
			</tr>

			<tr>
				<td height="40px"></td>
			</tr>
			<tr>
				<td colspan="4" align="center"><a href="home.jsp">Home</a></td>
			</tr>
		</table>
	</form:form>


</body>
</html>