<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>新用户注册</title>
	<link rel="stylesheet" href="../css/bootstrap.min.css" />
	<script type="text/javascript" src="../js/jquery-1.7.1.js"></script>
	<script type="text/javascript" src="../js/bootstrap.min.js"></script>
	<script type="text/javascript">
	<!--	function check(form){
			var email = document.getElementById("address");
			var phone = document.getElementById("phone");
			if($("#name").val()==null || $("#name").val()==""){
				$("#msg1").html("用户名不能为空！");$("#msg2").html("");$("#msg3").html("");$("#msg4").html("");
				return false;
			}if($("#pwd").val()==null || $("#pwd").val()==""){
				$("#msg2").html("密码不能为空！");$("#msg1").html("");$("#msg3").html("");$("#msg4").html("");
				return false;
			}if($("#phone").val()==null || $("#phone").val()==""){
				$("#msg3").html("手机号不能为空！");$("#msg2").html("");$("#msg1").html("");$("#msg4").html("");
				return false;
			}if($("#address").val()==null || $("#address").val()==""){
				$("#msg4").html("邮箱不能为空！");$("#msg2").html("");$("#msg3").html("");$("#msg1").html("");
				return false;
			}if(!/^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/.test(email.value)&&email.value!=""){
				$("#msg4").html("请输入正确的邮箱地址！");$("#msg2").html("");$("#msg3").html("");$("#msg1").html("");
				return false;
			}if(!/^(13[0-9]|14[0-9]|15[0-9]|18[0-9])\d{8}$/i.test(phone.value)&&phone.value!=""){
				$("#msg3").html("请输入正确的手机号码！");$("#msg2").html("");$("#msg1").html("");$("#msg4").html("");
				return false;
			}
			return true;
		};-->

	</script>
</head>
<body>
	
	<form:form action="/person/regist" method="post" name="regist_form" onsubmit="return check(this)" modelAttribute="Person">
		<table align="center" width="50%">
			<tr>
				<td>用户名:</td><td><input type="text" name="userName" id="name"/></td><td id="msg1" align="left" width="30%"></td>
				<td><form:errors path="userName"></form:errors></td>
			</tr><tr>
				<td>密    码：</td><td><input type="password" name="userPassword" id="pwd"/></td><td id="msg2" align="left" width="30%"></td>
			</tr><tr>
				<td>手    机：</td><td><input type="text" name="phone" id="phone"/></td><td id="msg3" align="left" width="30%"></td>
			</tr><tr>
				<td>邮    箱：</td><td><input type="text" name="address" id="address"/></td><td id="msg4" align="left" width="30%"></td>
			</tr>
			<tr>
				<td></td><td><input type="submit" value="注册"  class="btn btn-primary"
				onclick="return check(this.form)"/></td>
			</tr>
		</table>
	</form:form>
	${requestScope.errfields}
	${requestScope.registPerson}
</body>
</html>