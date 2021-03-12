package com.amaker.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class TestSession extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public TestSession() {
        super();
          
    }

	
	public void init(ServletConfig config) throws ServletException {
	}

	
	public void destroy() {
	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		//���sessionʵ�����ýӿڵ�ʵ���������ṩ
		HttpSession session = request.getSession();
		
		//��������
		session.setAttribute("Username", "amaker");
	
		//�������
		
		String username = (String)session.getAttribute("Username");
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head><title>A Servlet</title></head>");
		out.println("<body>");
		out.println(username);
		out.println("</body>");
		out.println("</html>");
		out.flush();
		out.close();
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
