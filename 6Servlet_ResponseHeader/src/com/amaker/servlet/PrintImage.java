package com.amaker.servlet;
//�˷�����������һ��ͼƬ
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class PrintImage extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
    public PrintImage() {
        super();
    }

	
	public void init(ServletConfig config) throws ServletException {
	}

	
	public void destroy() {
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("image/jpeg");

		InputStream in = this.getClass().getClassLoader().getResourceAsStream("052b8a9c379ad9094608efa651c9d8af.jpg");
		byte[] b = new byte[in.available()];//����һ���ֽ�����
		in.read(b);//��ȡ������
		OutputStream out = response.getOutputStream();//��Ӧ�����
		out.write(b);
		
		out.close();
		in.close();
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
