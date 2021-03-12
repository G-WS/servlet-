package com.amaker.listener;

import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;
import javax.servlet.annotation.WebListener;


public class ServletContextAttributeListenerTest implements ServletContextAttributeListener {

   
    public ServletContextAttributeListenerTest() {
    }

	//���
    public void attributeAdded(ServletContextAttributeEvent event)  { 
    
    	System.out.println("attributeAdded......");
    }

	//ɾ��
    public void attributeRemoved(ServletContextAttributeEvent event)  { 
    
    	System.out.println("attributeRemoved......");

    }

	//�滻
    public void attributeReplaced(ServletContextAttributeEvent event)  { 
    
    	System.out.println("attributeReplaced......");

    }
	
}
