<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript" src="../js/jquery-1.7.1.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function del(id){
		if(confirm('确认删除吗？')){
			$.get("/user/delUser?id=" + id,function(data){
				if("success" == data.result){
					alert("删除成功");
					window.location.reload();
				}else{
					alert("删除失败");
				}
			});
		}else{return}
	}
	function submitForm(){
		document.getElementById("select").submit();
	}
</script>
</head>
<body>
<form id="select" action="/user/getAllUser" method ="post">
	<div style="text-align:right;">
		<input type="text"  name="sname" placeholder="请输入姓名"> <input type="button" onclick="submitForm()" value="检索"/>

</div>
</form>
	<h6 align="center"><a href="/user/toAddUser">添加用户</a></h6>
	<table border="1" align="center" width="800px">
		<tbody>
			<tr>
				<th>姓名</th>
				<th>年龄</th>
				<th>操作</th>
			</tr>
			<c:if test="${!empty userList }">
				<c:forEach items="${userList }" var="user">
					<tr>
						<td>${user.userName }</td>
						<td>${user.age }</td>
						<td>
							<a href="/user/getUser?id=${user.id }">编辑</a>
							<a href="javascript:del('${user.id }')">删除</a>
						</td>
					</tr>				
				</c:forEach>
			</c:if>
			<TR>
				<TD colspan="4" align="center" bgcolor="#5BA8DE">共${count}条记录 共${pageCount}页 当前第${pageNumber}页<br>

					<a href="/user/getAllUser?pageNumber=1">首页</a>
					<a href="/user/getAllUser?pageNumber=${pageNumber-1}">上一页</a>
					<a href="/user/getAllUser?pageNumber=${pageNumber+1}">下一页</a>
					<a href="/user/getAllUser?pageNumber=${pageCount}">尾页</a>
				</TD>
			</TR>
		</tbody>
	</table>
</body>
</html>