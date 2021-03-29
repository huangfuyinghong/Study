package com.web.shopping.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class SellerLoginInterceptor extends HandlerInterceptorAdapter {

	private static final Logger LOGGER = 
			LoggerFactory.getLogger(SellerLoginInterceptor.class);
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		LOGGER.info("==== preHandle 호출");
		// login.jsp에서 form action="main"로 이동하기 전에 데이터를 가로채서 세션에 그 정보를 저장 
		String url = request.getParameter("targetUrl");
		LOGGER.info("목적지 url : " + url);
		if(url != null && url != "") {
			request.getSession().setAttribute("dest", url);
		}
		return true;
	}
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
		LOGGER.info("===== postHandle 호출");
		// model 객체의 loginResult 속성값(sID와 동일)을 확인 
		// - null이 아니면(로그인 성공) session 객체에 sID 속성 추가, 페이지 이동
		// - null이면(로그인 실패) 메인 페이지로 이동
		
		String sID = (String) modelAndView.getModel().get("loginResult");
		LOGGER.info("sID = " + sID);
		if(sID != null) {
			LOGGER.info("로그인 성공");
			HttpSession session = request.getSession();
			session.setAttribute("sID", sID);
			
			// 세션에서 목적 url 가져오기
			String dest = (String) session.getAttribute("dest");
			if(dest != null) {
				response.sendRedirect(dest);
			} else {
				response.sendRedirect("/shopping");
			}
		} else { 
			LOGGER.info("로그인 실패");
			HttpSession session = request.getSession();
			session.setAttribute("loginFail", "loginFail");
			response.sendRedirect("/shopping/seller/login");
		}
		super.postHandle(request, response, handler, modelAndView);
	}
} // AdminInterceptor 
