package com.amaker.servlet;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



public class UserdaoImpl implements Userdao {

	//�˷���������½�˻�
	public Userbean login(String username, String password) {
		// TODO Auto-generated method stub
		String sql = "select id,name,password from Usertb1 where name = ? and password=?";
		Dbutil util=new Dbutil();
		Connection conn = util.getConnection();
		try {
			PreparedStatement pstmt = conn.prepareCall(sql);
			pstmt.setString(1, username);
			pstmt.setString(2, password);
			ResultSet rs=pstmt.executeQuery();
			if(rs.next()) {
				int id=rs.getInt(1);
				//String name=rs.getString(2);
				Userbean u=new Userbean();
				u.setId(id);
				u.setName(username);
				u.setPassword(password);
				return u;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			util.closeConnection(conn);
		}
		
		return null;
	}

	@Override//�˷�������ע���˻�
	public void register(Userbean u) {
		// TODO Auto-generated method stub
		String sql = "insert into usertb1(id,name,password)"+"values(?,?,?)";
		Dbutil util=new Dbutil();
		Connection conn = util.getConnection();
		try {
			PreparedStatement pstmt = conn.prepareCall(sql);
			pstmt.setInt(1, u.getId());
			pstmt.setString(2, u.getName());
			pstmt.setString(3, u.getPassword());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			util.closeConnection(conn);
		}
		
	}

	@Override//�˷�����������˻��Ƿ���ȷ
	public boolean check(String username) {
		// TODO Auto-generated method stub
		String sql = "select id,name,password from Usertb1 where name = ? ";
		Dbutil util=new Dbutil();
		Connection conn = util.getConnection();
		try {
			PreparedStatement pstmt = conn.prepareCall(sql);
			pstmt.setString(1, username);
			
			ResultSet rs=pstmt.executeQuery();
			if(rs.next()) {
				return true;
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			util.closeConnection(conn);
		}

		return false;
	}

}
