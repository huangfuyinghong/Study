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
		LOGGER.info("==== preHandle ȣ��");
		// login.jsp���� form action="main"�� �̵��ϱ� ���� �����͸� ����ä�� ���ǿ� �� ������ ���� 
		String url = request.getParameter("targetUrl");
		LOGGER.info("������ url : " + url);
		if(url != null && url != "") {
			request.getSession().setAttribute("dest", url);
		}
		return true;
	}
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
		LOGGER.info("===== postHandle ȣ��");
		// model ��ü�� loginResult �Ӽ���(sID�� ����)�� Ȯ�� 
		// - null�� �ƴϸ�(�α��� ����) session ��ü�� sID �Ӽ� �߰�, ������ �̵�
		// - null�̸�(�α��� ����) ���� �������� �̵�
		
		String sID = (String) modelAndView.getModel().get("loginResult");
		LOGGER.info("sID = " + sID);
		if(sID != null) {
			LOGGER.info("�α��� ����");
			HttpSession session = request.getSession();
			session.setAttribute("sID", sID);
			
			// ���ǿ��� ���� url ��������
			String dest = (String) session.getAttribute("dest");
			if(dest != null) {
				response.sendRedirect(dest);
			} else {
				response.sendRedirect("/shopping");
			}
		} else { 
			LOGGER.info("�α��� ����");
			HttpSession session = request.getSession();
			session.setAttribute("loginFail", "loginFail");
			response.sendRedirect("/shopping/seller/login");
		}
		super.postHandle(request, response, handler, modelAndView);
	}
} // AdminInterceptor 
