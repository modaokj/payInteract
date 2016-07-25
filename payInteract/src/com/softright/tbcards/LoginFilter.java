package com.softright.tbcards;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;

import com.softright.tbcards.actions.KickUserAction;

public class LoginFilter implements Filter {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse res,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) res;
		Cookie[] cookies = request.getCookies();
		//		String fr = request.getParameter("fr");
		//		if (StringUtils.isBlank(fr))
		//			fr = "";
		
		
		if (cookies == null) {
			req.setAttribute("resultData", "请从淘宝登陆");
			request.getRequestDispatcher("/WEB-INF/jsps/error.jsp").forward(request, response);
			return;
		}
		
		String pptStr = null;
		for (int i = 0; i < cookies.length; i++) {
			if (cookies[i].getName().equals(Constants.PASSPORT_COOKIE_NAME)) {
				//判断cardid是否存在，如果不存在，直接挑战到卡片设置页面
				pptStr = cookies[i].getValue();
				break;
			}
		}
		
		if(StringUtils.isBlank(pptStr)){
			req.setAttribute("resultData", "请从淘宝登陆");
			request.getRequestDispatcher("/WEB-INF/jsps/error.jsp").forward(request, response);
			return;
		}
		if(StringUtils.isNotBlank(pptStr)){
			PassportNew ppt = PassportNew.fromString(pptStr);
			if(KickUserAction.kuser.contains(ppt.getId())){
				Cookie cookie = new Cookie(Constants.PASSPORT_COOKIE_NAME, "");
				cookie.setDomain("card.cd");
				cookie.setPath("/");
				cookie.setMaxAge(0);
				response.addCookie(cookie);
				req.setAttribute("resultData", "您的帐号存在安全问题");
				request.getRequestDispatcher("/WEB-INF/jsps/error.jsp").forward(request, response);
				return;
			}
		}

	/*	PassportNew ppt= PassportNew.fromString(pptStr);
		if(StringUtils.isBlank(ppt.getCardId())){
			if(request.getRequestURI().endsWith("FirstSaveCard.h4") || request.getRequestURI().endsWith("SaveCard.json")|| request.getRequestURI().endsWith("SendToMe.json")){
				chain.doFilter(req, res);
				return;
			}else{
				String url = request.getContextPath()+"/admin/sys/FirstSaveCard.h4?first=true";
				response.sendRedirect(url);
				return;
			}
		}*/

		chain.doFilter(req, res);

	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
             
	}

}
