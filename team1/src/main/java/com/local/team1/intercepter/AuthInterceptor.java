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
					
		System.out.println("uri:" + uri);
		System.out.println("query:" + query);
		String targetLocation;
		if(memberVo == null) {
			if(isAjaxRequest(request)) {
				targetLocation = "/board/fbRead?" + query;				
				System.out.println("targetLocation(ajax) : " + targetLocation);
				session.setAttribute("targetLocation", targetLocation);
				response.sendError(400);
				return false;
			}			
//			System.out.println("uri:" + uri);
//			System.out.println("query:" + query);
		if (query != null) {
			targetLocation = uri + "?" + query;
		} else {
			targetLocation = uri;
		}			
			session.setAttribute("targetLocation", targetLocation);
			System.out.println("targetLocation : " + targetLocation);
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
