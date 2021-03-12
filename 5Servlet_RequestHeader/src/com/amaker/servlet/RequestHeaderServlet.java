package com.amaker.servlet;

/*
 * ��ȡ����ͷ��Ϣ
 *	-ʹ��HpptServletRequest�еķ���
 *	 	һ�㷽��
 *		-getHeader(header���Ʋ����ִ�Сд)
 *		-getHeaders
 *		-getHeaderNames
 *		ר�ŷ���
 *		-getCookies
 *		-getAuthType
 *		-getRemoteUser
 *		-getContentLength
 *		-getContentType
 *		-getDateHeader
 *		�����Ϣ
 *		-getMethod
 *		-getRequestURL
 *		-getQueryString
 *		-getProtocol
 *
 */
/*
 * ����������ͷ�ĺ���
 * 		-ACCEPT
 * 			��ʾ������ܴ����MIME���� 
 * 			�ܷ��Ͳ�ͬ�����ݵ���ͬ�Ŀͻ��ˣ�����PNG�ļ��кõ�ѹ�����ԣ��������������֧�ֵĲ��Ǻܹ㷺
 * 		-Accept-Encoding
 * 			�ΰ���������ܴ���ı�������
 *  	-Authorization
 *  		��Ȩ��Ϣ��ͨ�������ڶԷ��������͵�www-Authenticateͷ��Ӧ����
 *   	-Connection
 *   		��־�ǹ���Ҫ�־����ӣ������keep-alive��������ǳ־�����
 *      -cookie
 *      	������
 *  	-host
 *  		����һ��url���û��Ӹ�url�����ҳ��������ʵ�ǰ�����ҳ��
 *   	-if-modified-since
 *   		ֻ�е�������������ݣ����ƶ�������ֻ�����־����޸Ĳŷ�����
 *   		�����򷵻�304
 *   	-Referer
 *   		����һ��url�û��Ӹ�url�����ҳ��������ʵ�ǰ�����ҳ��
 *   	-User-Agent
 *   		���������
 */
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RequestHeaderServlet
 */
public class RequestHeaderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public RequestHeaderServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	
		Enumeration enu = request.getHeaderNames();
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("   <head><title>A Servlet</title></head>");
		out.println("   <body>");
		out.print("   <table>");
		out.print("<tr>");
			out.print("<th>");
				out.print("HeaderName");
			out.print("</th>");
			
			out.print("<th>");
				out.print("HeaderValue");
			out.print("</th>");
		out.print("</tr>");
		
		
		while(enu.hasMoreElements()){
			String headerName = (String)enu.nextElement();
			String headerValue = request.getHeader(headerName);
			
			out.print("<tr>");
			out.print("<td>");
				out.print(headerName);
			out.print("</td>");

			out.print("<td>");
				out.print(headerValue);
			out.print("</td>");
		}
		out.print("   </table>");
		out.println("</body>");
		out.println("</html>");
		out.flush();
		out.close();
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

	
	public void destroy() {
		super.destroy();
	}

	
	public void init() throws ServletException {
		super.init();
	}
	

}
