package com.amaker.listener;
//������
import javax.servlet.AsyncEvent;
import javax.servlet.AsyncListener;
import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.ServletRequestAttributeEvent;
import javax.servlet.ServletRequestAttributeListener;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionActivationListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionIdListener;
import javax.servlet.http.HttpSessionListener;


public class ServletContextListenerTest implements ServletContextListener {

   
  

	//��ʼ��
    public void contextInitialized(ServletContextEvent arg0)  { 
   
    	System.out.println("contextInitialized........");
    }

	
   

	//����
    public void contextDestroyed(ServletContextEvent arg0)  { 
   
    	System.out.println("contextDestroyed.......");
    }

	
   
	
}
