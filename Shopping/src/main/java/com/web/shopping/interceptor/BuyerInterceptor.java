package com.web.shopping.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.web.shopping.domain.BuyerVO;

public class BuyerInterceptor extends HandlerInterceptorAdapter {

	private static final Logger LOGGER = 
			LoggerFactory.getLogger(BuyerInterceptor.class);
	
	@Override
	public boolean preHandle(HttpServletRequest req, HttpServletResponse res, Object obj) throws Exception {
		LOGGER.info("buyer interception »£√‚()");
		
		HttpSession session = req.getSession();
		BuyerVO buyer = (BuyerVO)session.getAttribute("buyer");
		LOGGER.info("buyer = " + buyer);
		
		if("/shopping/buyer/login".equals(req.getRequestURI())) {
			return true;
		}
		if(buyer == null) {
			res.sendRedirect("/shopping/buyer/login");
			return false;
		}
		
		return true;
	}
	
} // end BuyerInterceptor
