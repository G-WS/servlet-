package com.amaker.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class TestScopeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public TestScopeServlet() {
        super();
    }

	
	public void init(ServletConfig config) throws ServletException {
	}

	
	public void destroy() {
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//request ��������������������
		request.setAttribute("request_name", "request_value");
		//session �Ự
		HttpSession session = request.getSession();
		session.setAttribute("session_name","session_value" );
		
		//ServletContext ȫ�֣������û�����
		
		ServletContext cxt = this.getServletContext();
		cxt.setAttribute("servletcontext_name", "servletcontext_value");
		
		request.getRequestDispatcher("/servlet/ResultServlet").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
