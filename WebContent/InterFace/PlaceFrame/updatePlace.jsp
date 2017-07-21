<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改场地</title>
</head>
<body>
	<fieldset style="font-size:20px;">
		<legend style="font-size:40px;">修改场地信息</legend>
		<form action=<c:if test="${place=='true'}">/EAM/PlaceAction?method=updatePlace</c:if>
			<c:if test="${place!='true'}">/EAM/PlaceAction?method=updatePlace</c:if> method="post"
			style="text-align: center;">
			<div style="margin-top:20px;margin-left:15px;">&nbsp;编号:无法更改&nbsp;&nbsp;&nbsp;<input  type="hidden" name="id" value="${place.id}" <c:if test="${isUpdate=='true'}">readonly</c:if>>&nbsp;
			<br /></div>
			<div style="margin-top:20px;margin-left:9px;">&nbsp;名称:&nbsp;&nbsp;&nbsp;<input type="text" name="name"
				value="${place.name }">&nbsp;<br /></div>
				<div style="margin-top:20px;margin-left:-100px;"> 状态 :&nbsp;&nbsp;&nbsp;<select
				name="state">
				<c:if test="${place=='true'}">
					<c:if test="${place.state=='1'}">
						<option selected="selected" value=1>已用</option>
						<option value=2>未用</option>
					</c:if>
					<c:if test="${place.state=='2'}">
						<option value=1>已用</option>
						<option selected="selected" value=2>未用</option>
					</c:if>
				</c:if>
				<c:if test="${place!='true'}">
					<option selected="selected" value=1>已用</option>
					<option value=2>未用</option>
				</c:if>
			</select><br /></div>
			<div style="margin-top:20px;">场地类型:&nbsp; <input type="text" name="type"
				value="${place.type}"><br /></div>
				<div style="margin-top:20px;"> 场地面积:&nbsp; <input type="text" name="area"
				value="${place.area}"><br /></div>
				<div style="margin-top:20px;"> 联系人:&nbsp;&nbsp; <input type="text" name="person"
				value="${place.person}"><br /></div>
				<div style="margin-top:20px;"> 联系方式:&nbsp; <input type="text" name="tel"
				value="${place.tel}"><br /></div>
			<div style="margin-top:20px;"> 备注:&nbsp;&nbsp;&nbsp; <input type="text" name="detail"
				value="${place.detail}"><br /> </div>
				<div style="margin-top:20px;"><input type="submit" style="font-size:20px;"
				value="确定">&nbsp;&nbsp;&nbsp; <input  style="font-size:20px;" type="reset" value="重置"></div>
		</form>
	</fieldset>
</body>
</html>