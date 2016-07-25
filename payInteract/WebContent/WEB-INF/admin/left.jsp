<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@include file="../header.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%
%>
<title>段子手</title>
<%@include file="../head.jsp"%>
<script type="text/javascript">
$(function(){ 
	$(".left-nav li").click(function(){
		$(this).addClass("nav-active").siblings().removeClass("nav-active");
	});
}) 
</script>
</head>
<body>
<div class="tmp-nav pa" id="Left">
			<div class="left-nav mt15">
		    <ul>
			  <li><a href="../Index.h4"><span class="li-1"></span><span>首　　页</span></a></li>
			   <!-- 摇一摇 -->
			  <c:if test="${resultData.opType==0 && resultData.opTypeC==0}">
			  <li class="nav-active"><a href="VbMryxActivity.h4?operationType=1"><span class="li-2"></span><span>创建活动</span></a></li>
			  <li><a href="VbMryxTemplate.h4"><span class="li-4"></span><span>模板设置</span></a></li>
			  <li><a href="VbMryxActivity.h4?operationType=8"><span class="li-3"></span><span>活动列表</span></a></li>
			  <li><a href="WxListLottery.h4?operationType=1"><span class="li-4"></span><span>查看记录</span></a></li>
			   <c:if test="${resultData.pub}">
			     <li><a href="MaintainActivity.h4?operationType=2"><span class="li-3"></span><span>活动管理</span></a></li>
			  </c:if>
			  </c:if>
			   <!-- 吹一吹 -->
			  <c:if test="${resultData.opType==0 && resultData.opTypeC!=0}">
			  <li class="nav-active"><a href="VbMryxActivity.h4?operationType=1&opTypeC=1"><span class="li-2"></span><span>创建活动</span></a></li>
			  <li style="display:none;"><a href=""><span class="li-4"></span><span></span></a></li>
			  <li><a href="VbMryxActivity.h4?operationType=8&opTypeC=8"><span class="li-3"></span><span>活动列表</span></a></li>
			  <li><a href="WxListLottery.h4?operationType=1&opTypeC=1"><span class="li-4"></span><span>查看记录</span></a></li>
			   <c:if test="${resultData.pub}">
			     <li><a href="MaintainActivity.h4?operationType=2&opTypeC=1"><span class="li-3"></span><span>活动管理</span></a></li>
			  </c:if>
			  </c:if>
			   <!-- 淘口令 -->
			  <c:if test="${resultData.opType!=0}">
			  <li class="nav-active"><a href="VbMryxActivity.h4?operationType=1&opType=1"><span class="li-2"></span><span>创建活动</span></a></li>
			  <li><a href="VbMryxTemplate.h4?operationType=10&opType=10"><span class="li-4"></span><span>页面装修</span></a></li>
			  <li><a href="VbMryxActivity.h4?operationType=8&opType=8"><span class="li-3"></span><span>活动列表</span></a></li>
			  <li><a href="WxListLottery.h4?operationType=1&opType=1"><span class="li-4"></span><span>查看记录</span></a></li>
			   <c:if test="${resultData.pub}">
			     <li><a href="MaintainActivity.h4?operationType=2&opType=2"><span class="li-3"></span><span>活动管理</span></a></li>
			  </c:if>
			  </c:if>
			</ul>
		  </div>
			<div class="service">
			  <div style="margin-left:25px">
			   <a href="https://isv081.bbs.taobao.com/detail.html?postId=1818616" target="_blank"><span style="color:#e42929;">使用教程</span></a>
			  </div>
			  <ul style="margin-top: 20px">
			     <li><a href="http://www.taobao.com/webww/ww.php?ver=3&touid=%E6%9D%AD%E5%B7%9E%E4%BD%91%E8%BD%AF%E7%A7%91%E6%8A%80%E6%9C%89%E9%99%90%E5%85%AC%E5%8F%B8&siteid=cntaobao&status=1&charset=utf-8" target="_blank"><img src="/images/service.png"/><br/>售后1</a></li>
			     <li><a href="http://www.taobao.com/webww/ww.php?ver=3&touid=%E6%9D%AD%E5%B7%9E%E4%BD%91%E8%BD%AF%E7%A7%91%E6%8A%80%E6%9C%89%E9%99%90%E5%85%AC%E5%8F%B8&siteid=cntaobao&status=1&charset=utf-8" target="_blank"><img src="/images/service.png"/><br/>售后2</a></li>
			     <li><a href="http://www.taobao.com/webww/ww.php?ver=3&touid=%E6%9D%AD%E5%B7%9E%E4%BD%91%E8%BD%AF%E7%A7%91%E6%8A%80%E6%9C%89%E9%99%90%E5%85%AC%E5%8F%B8&siteid=cntaobao&status=1&charset=utf-8" target="_blank"><img src="/images/service.png"/><br/>售后3</a></li>
			  </ul>
			</div>
			<div class="mt30"><a href="https://fuwu.taobao.com/ser/detail.html?spm=a1z13.2196529.0.0.OUKBSF&serviceCode=FW_GOODS-1830425&tracelog=tracelog&qq-pf-to=pcqq.c2c" target="_blank"><img src="/images/mscj.gif"/></a></div>
		</div>
</body>
</html>