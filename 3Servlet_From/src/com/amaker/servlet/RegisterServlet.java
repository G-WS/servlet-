package com.amaker.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public RegisterServlet() {
        super();
    }


	public void init(ServletConfig config) throws ServletException {
	}

	
	public void destroy() {
	}
	//�˷����������õ�ע���е�һЩ�����ģ���ԱȽϳ��ã�ֻ��Ҫ����һ��Ŀ��ʱ�ַ���������һ������������ͺã��˷�����Ϊ����
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			String gender = request.getParameter("gender");
			String [] hobby = request.getParameterValues("hobby");//�˷����������ض��ֵ
			String position = request.getParameter("position");
			String memo = request.getParameter("memo");
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			out.println("<!DOCTYPE html>");
			out.println("<html>");
			out.println("<head><title>Register.html</title></head>");
			out.println("<body>");
			out.println("Username:"+username);
			out.println("Password:"+password);
			out.println("Gender:"+gender);
			for(int i=0;i<hobby.length;i++){
				out.println("hobby"+hobby[i]);

		}
		
		out.println("Position:"+position);
		out.println("Memo:"+memo);
		out.println("</body>");
		out.println("</html>");
		out.flush();
		out.close();
		
		/*������һ�ֲ�̫���õķ�����ͨ���������ֶ������ע�����Ϣ
		/*Enumeration enu = request.getParameterNames();
		
		while(enu.hasMoreElements()){
			String name = (String)enu.nextElement();
			if(name!=null&&name.equals("hobby")){
				String [] h = request.getParameterValues("hobby");
				for(int i=0;i<h.length;i++){
					System.out.println(h[i]);
				}continue;
				
			}else{
				String values = request.getParameter(name);
				System.out.println(value);
			}
		}*/
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
