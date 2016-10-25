<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录界面</title>
	<link rel="stylesheet" href="../css/bootstrap.min.css" />
	<script type="text/javascript" src="../js/jquery-1.7.1.js"></script>
	<script type="text/javascript" src="../js/bootstrap.min.js"></script>
	<script type="text/javascript">
		function check(form){
			if($("#name").val()==null || $("#name").val()==""){
				$("#msg1").html("请输入用户名！");$("#msg2").html("");
				return false;
			}if($("#pwd").val()==null || $("#pwd").val()==""){
				$("#msg2").html("请输入密码！");$("#msg1").html("");
				return false;
			}else{
			$("#msg1").html("");
			$("#msg2").html("");
			return true;}
		};
		</script>


</head>
<body>
	<form action="/person/login" method="post">
		<table align="center" width="50%">
			<tr>
				<td>用户名:</td><td><input type="text" name="userName" id="name" value=""/></td><td id="msg1" align="left" width="30%"></td>
			</tr><tr>
				<td>密    码：</td><td><input type="password" name="password" id="pwd" value=""/></td><td id="msg2" align="left" width="30%"></td>
			</tr>

			<tr><td>验证码</td><td><input id="index_code" name="code" type="text" /></td>
				<td> <img id="imgObj" alt="验证码" src="code.html" />
					<a href="#" onclick="changeImg()">换一张</a></td></tr>

			<tr>
				<td></td><td><input type="submit" value="登录" onclick="return check(this.form)"/>
			<input type="button"  value="注册"  onclick="window.location.href='/person/toRegist'">
			<input type="reset" value="重置">
		</td>
			</tr>
		</table>
	</form>
	${requestScope.message}
</body>
<script type="text/javascript">
	function changeImg() {
		var imgSrc = $("#imgObj");
		var src = imgSrc.attr("src");
		imgSrc.attr("src", chgUrl(src));
	}
	//时间戳
	//为了使每次生成图片不一致，即不让浏览器读缓存，所以需要加上时间戳
	function chgUrl(url) {
		var timestamp = (new Date()).valueOf();
		url = url.substring(0, 17);
		if ((url.indexOf("&") >= 0)) {
			url = url + "×tamp=" + timestamp;
		} else {
			url = url + "?timestamp=" + timestamp;
		}
		return url;
	}
</script>
</html>