package com.amaker.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
/*
 * �˹�������Ϊ�ַ����������
 */
public class EncodingFilter implements Filter {

       public EncodingFilter() {
    }

		public void destroy() {
	}

	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		request.setCharacterEncoding("gbk");
		response.setCharacterEncoding("gbk");
		chain.doFilter(request, response);
	}

	
	public void init(FilterConfig fConfig) throws ServletException {
	}

}
