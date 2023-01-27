package com.clothesshop.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.SessionAttributes;

import com.clothesshop.dto.UserDto;
import com.clothesshop.utils.SessionUtil;
@SessionAttributes("loginInfor")
public class AuthorizationFilter implements Filter {
	
	private ServletContext servletContext;

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		this.servletContext = filterConfig.getServletContext();
	}

	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) servletRequest;
		HttpServletResponse response = (HttpServletResponse) servletResponse;
		String url = request.getRequestURI();
		if(url.startsWith("/ClothesShop/admin")) {
			UserDto userDto = (UserDto) SessionUtil.getInstance().get(request, "loginInfor");
			if(userDto != null) {
				if(userDto.getRole().equals("admin")) {
					filterChain.doFilter(servletRequest, servletResponse);
				}else {
					response.sendRedirect(request.getContextPath()+"/home");
				}
			}else {
				response.sendRedirect(request.getContextPath()+"/home");
			}
		}else {
			filterChain.doFilter(servletRequest, servletResponse);
		}
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}


}
