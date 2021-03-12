package com.amaker.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BasicServlet extends HttpServlet{
	//���췽��
	public BasicServlet(){
		System.out.println("BasicServlet");
	}
	
	
	
	/*�˷������ڳ�ʼ��
	 * ���ҿ��Ի�ó�ʼ���ľֲ��Ĳ���
	 * �����Ի��ȫ�ֵĳ�ʼ������
	 * */
	@Override
	public void init() throws ServletException {
		String url = this.getServletContext().getInitParameter("url");
		System.out.println(url);
		String username = this.getInitParameter("username");
		System.out.println(username);
		System.out.println("init");
	}

	
	
	/*get������ȱ���ǻὫ�û�����ѯ����Ϣ�����ڵ�ַ��
	*���һ����Ա����棬�����post��˵��̫��ȫ
	*/
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		PrintWriter out = response.getWriter();
		out.println("my servlet");
		//�����ض��򣬲�����request�е�����
		if(username!=null&&username.equals("amaker")){
			
			request.getRequestDispatcher("/Success.html").include(request, response);	//�������

			//request.getRequestDispatcher("/Success.html").forward(request, response);	
			//response.sendRedirect("http://google.cn");//����ת��
		}
		else{
			request.getRequestDispatcher("/Failure.html").forward(request, response);
		}
		
		System.out.println("doGet");
		
	}
	
	/*post���������ڲ��Ὣ��������������ʾ��url��
	 * �����get��˵�Ƚϰ�ȫ����������漰��������������û����ü�������
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doPost");
	}
	/*service����Ż��ж��Ƿ���doGet����doPost
	*���û��service�����ǿ��ڱ���ʹ�õ���post����get
	*һ��ʹ��post
	*/
	
	/*protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("service");
	}*/
	/*�˷�����������
	 */
	@Override
	public void destroy() {
		System.out.println("distory");
	}
	
	

}
