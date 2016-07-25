<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://www.softright.com/web" prefix="act"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<act:action path="/admin/HeadInfo.do" resultName="rlt" />
<div class="head">
	<div class="p_w">
		<div class="logo fl">
			<a href="#"></a>
		</div>
		<div class="nav">
			<li><a href="/admin/Index.h4" <c:if test="${nav eq 'index' }">class="active"</c:if>>首　页</a></li>
			<li><a href="/admin/wzz/OpenBooks.h4" <c:if test="${nav eq 'sjdz' }">class="active"</c:if>>商家段子</a></li>
			<li><a href="/admin/wzz/SysBooks.h4"<c:if test="${nav eq 'sck' }">class="active"</c:if>>素材库</a></li>
			<li><a href="/admin/wzz/EditBook.h4"<c:if test="${nav eq 'cjdz' }">class="active"</c:if>>创建段子</a></li>
		</div>
		<div class="user fr">
			<ul>
				<li class="pr">
					<a href="/admin/wzz/MyBooks.h4" class="pr" title="${rlt.userName }"><span class="user_name">${rlt.userName }</span><i class="pa"></i></a>
					<ul class="pa">
						<li><a href="/admin/wzz/MyBooks.h4">我的段子</a></li>
						<li><a href="/admin/wzz/MyCollect.h4">我的收藏</a></li>
					<!-- 	<li><a href="#">奖品管理</a></li> -->
						<!-- <li><a href="/admin/wzz/UserMgr.h4">客户管理</a></li> -->
						<c:if test="${rlt.adminuser}">
							<li><a href="/admin/AuditMgr.h4">审核管理</a></li>
							<li><a href="/admin/SysBookMgr.h4">添加模版</a></li>
						</c:if>
					</ul>
				</li>
			</ul>
		</div>
		<div class="clearfix"></div>
	</div>
</div>
