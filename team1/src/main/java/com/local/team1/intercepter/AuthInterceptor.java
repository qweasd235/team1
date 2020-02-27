package com.local.team1.intercepter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.local.team1.domain.MemberVo;

public class AuthInterceptor extends HandlerInterceptorAdapter {
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		HttpSession session = request.getSession();
		MemberVo memberVo = (MemberVo)session.getAttribute("memberVo");
		String uri = request.getRequestURI();
		String query = request.getQueryString(); // ? 뒤로 전달되는 내용
		String targetLocation;
		if(memberVo == null) {
			if(isAjaxRequest(request)) {
				targetLocation = uri + "?" + query;
				session.setAttribute("targetLocation", targetLocation);
				response.sendError(400);
				return false;
			}			
//			System.out.println("uri:" + uri);
//			System.out.println("query:" + query);
			targetLocation = uri + "?" + query;
			session.setAttribute("targetLocation", targetLocation);
			response.sendRedirect("/mem/loginGet");
			return false;
		}
		return true;
	}
	
	private boolean isAjaxRequest(HttpServletRequest req) {
        String header = req.getHeader("AJAX");
//        System.out.println("header:" + header);
        if ("true".equals(header)){
         return true;
        }else{
         return false;
        }
    }

}
