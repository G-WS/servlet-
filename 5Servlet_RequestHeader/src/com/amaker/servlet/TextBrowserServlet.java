package com.amaker.servlet;
/*��Servlet��ͨ�����������ͷ��Ϣ���ж�������Ƿ���ĳ�����͵������
*�˷���Servlet�������ж��Ƿ���IE�����
*/
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TextBrowserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public TextBrowserServlet() {
        super();
    }


	public void init(ServletConfig config) throws ServletException {
			}


	public void destroy() {
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String browser = request.getHeader("user-agent");
		
		response.setContentType("text/html;charset=gbk");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("   <head><title>A Servlet</title></head>");
		out.println("   <body>");
		
		if(browser!=null&&browser.indexOf("MSIE")!=-1){
			out.println("�����õ���IE�����");
		}else{
			out.println("��ʹ�õ��Ƿ�IE�����");
		}
		
		out.println("</body>");
		out.println("</html>");
		out.flush();
		out.close();
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
