<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@include file="../header.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%
%>
<title></title>
<%@include file="../head.jsp"%>
</head>
<body>
<div class="header pr">
	<div class="logo fl">
		<a href="/admin/Index.h4"></a>
	</div>
	<div class="head_tit fr pr20">
		<span class="mr15">${resultData.userName}</span>
		<span class="mr15">账号将于<font class="f_fcff04">${resultData.validity}</font>后过期</span>
		<a href="https://fuwu.taobao.com/ser/detail.html?spm=0.0.0.0.jCmd38&service_code=FW_GOODS-1000036125" target="_blank" class="f_fcff04"><i class="head_tit_pay mr10"></i>立即续费</a>
	</div>
</div>
</body>
</html>