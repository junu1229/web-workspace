package edu.kh.test.user.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import edu.kh.test.user.model.vo.UserDTO;

public class UserDAO {
	
	
	
	public UserDAO() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	private Connection getConnection() throws SQLException {
		Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "SAMPLE", "SAMPLE");
		return conn;
	}
	
	private void closeAll(Connection conn, PreparedStatement ps) throws SQLException{
		conn.close();
		ps.close();
	}
	private void closeAll(ResultSet rs ,Connection conn, PreparedStatement ps) throws SQLException{
		rs.close();
		closeAll(conn, ps);
	}
	public UserDTO searchUser(int userNo) throws SQLException{
		Connection conn = getConnection();
		PreparedStatement ps = conn.prepareStatement("SELECT * FROM TB_USER WHERE USER_NO = ?");
		ps.setInt(1, userNo);
		ps.execute();
		ResultSet rs = ps.getResultSet();
		UserDTO dto = null;
		if(rs.next()) {
			dto = new UserDTO();
			dto.setUserNo(rs.getInt(1));
			dto.setUserId(rs.getString(2));
			dto.setUserName(rs.getString(3));
			dto.setUserAge(rs.getInt(4));
		}
		closeAll(rs, conn, ps);
		return dto;
	}
	
}
