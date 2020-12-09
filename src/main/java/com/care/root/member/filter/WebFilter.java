package com.care.root.member.filter;
	
import java.io.IOException;	
import java.util.ArrayList;	
import java.util.List;	
	
import javax.servlet.Filter;	
import javax.servlet.FilterChain;	
import javax.servlet.FilterConfig;	
import javax.servlet.ServletException;	
import javax.servlet.ServletRequest;	
import javax.servlet.ServletResponse;	
import javax.servlet.http.HttpServletRequest;	
import javax.servlet.http.HttpServletResponse;	
import javax.servlet.http.HttpSession;	
	
public class WebFilter implements Filter {	
		
	private List<String> passUrl = null;	
	private String contextPath;	
		
	@Override	
	public void destroy() {	
		// TODO Auto-generated method stub	
		
	}	
		
	@Override	
	public void init(FilterConfig filterConfig) throws ServletException {	
		// TODO Auto-generated method stub	
		// 웹페이지의 root페이지의 url를 취득한다.	
		contextPath = filterConfig.getServletContext().getContextPath();	
		passUrl = new ArrayList<String>();	
		// web.xml에서 설정했던 parameter를 가져와서 설정한다.	
		String[] ignoredPaths = filterConfig.getInitParameter("passPage").split(",");	
		for (String ignoredPath : ignoredPaths) {	
			passUrl.add(contextPath + ignoredPath);	
		}	
	}	
		
	@Override	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {	
		HttpServletRequest req = (HttpServletRequest) request;	
		HttpServletResponse res = (HttpServletResponse) response;	
		HttpSession session = req.getSession();	
		//User 세션 값이 있으면 통과!	
		if (session.getAttribute("USER") != null) {	
			chain.doFilter(req, res);	
			return;	
		}	
		// url를 가져와서 passUrl에 있는 경로면 통과	
		String url = req.getRequestURI();	
		for (String buf : passUrl) {	
			if (buf.equals(url)) {	
				chain.doFilter(req, res);	
				return;	
			}	
		}	
		// User 세션도 없고 passUrl이면 에러를 발생한다.	
		// System.out.println(contextPath); - /root
		System.out.println(contextPath);
		res.sendRedirect(contextPath + "/member/loginForm");	
	}	
}


