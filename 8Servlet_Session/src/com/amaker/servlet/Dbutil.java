package com.amaker.servlet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
public class Dbutil {
	/*
	 * ���ڲ������ݿ��Ƿ����ӳɹ�
	 */
	public static void main(String[] args) {
		Dbutil util=new Dbutil();
		Connection conn=util.getConnection();
		System.out.println(conn);
		//util.add();
	}//�˷������������ݿ��������Ϣ
	public void add() {
		Dbutil util=new Dbutil();
		Connection conn=util.getConnection();
		
		String sql="INSERT INTO s_manager(s_name,s_sex,s_age,s_subject) VALUES('mike','��',18,'Ӣ��')";
		try {
			conn.setAutoCommit(false);//����������Զ�������ݣ�����������ݣ���Ҫ���õڶ�ʮ���е�����
			Statement stmt=conn.createStatement();
			stmt.executeUpdate(sql);
			conn.commit();//������������ݵ�������ȥ�����к�23�У������ֱ�������Ϣ
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				conn.rollback();/*������ʾ����洢ʧ�ܣ��򷵻ش洢֮ǰ����ʽ����������ת��ʧ�ܣ���ֹһ�� ��Ǯ���۳�����һ��û�б仯
				 				*��ʱsql�������дsql1="insert into account set balance=balance-1000 where name='tom'"
				 				*sql2="insert into account set balance=balance+1000 where name='kite'"
				 				*/
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}finally {
			util.closeConnection(conn);
		}
	}
	/*�������ڻ�����ݿ�����
	 * ���Ҵ����ӷ���ֻ����������MySQL���ݿ�
	 */
	
	public Connection getConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			//����������������ص���MySQL����������
			return DriverManager.getConnection("jdbc:mysql://localhost:3306/student_system?serverTimezone=UTC","root","Zhy06150412252814732");
			//����ʱ����ͬ������������������ݿ����ƺ����"?serverTimezone=UTC",����д�����������ݿ�Ķ˿ںź����ݿ����ƣ������û���������
			
		}catch(Exception e) {
			e.getStackTrace();
	
		}
		//�����������쳣����һ���Ľ��
		return null;
		
	}
	//�˷��������������Ӹ������ݿ�
	/*public Connection getConnection(String url,String driver,String username,String password) {
		try {
			Class.forName(driver);
			return DriverManager.getConnection(url,username,password);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
		
		
	}*/
	//�˷�����Ȼ�ã�������Ҫ���Ͽ������֤�����Ͽ����ʱδѧ��
	/*public Connection openConnection() {
		properties prop=new properties();
	}*/
	//�������ڹر����ݿ����� 
	 
	public void closeConnection(Connection conn) {
		if(conn!=null) {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
