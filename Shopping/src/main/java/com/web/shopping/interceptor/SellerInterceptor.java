package com.web.shopping.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.web.shopping.domain.SellerVO;

public class SellerInterceptor extends HandlerInterceptorAdapter {

	private static final Logger LOGGER = 
			LoggerFactory.getLogger(SellerInterceptor.class);
	
	@Override
	public boolean preHandle(HttpServletRequest req, HttpServletResponse res, Object obj) throws Exception {
		LOGGER.info("seller interception »£√‚()");
		
		HttpSession session = req.getSession();
		SellerVO seller = (SellerVO)session.getAttribute("seller");
		LOGGER.info("seller = " + seller);
		
		if("/shopping/seller/login".equals(req.getRequestURI())) {
			return true;
		}
		if(seller == null) {
			res.sendRedirect("/shopping/seller/login" );
			return false;
		}
		
		return true;
		
	}
	
} // end SellerInterceptor
