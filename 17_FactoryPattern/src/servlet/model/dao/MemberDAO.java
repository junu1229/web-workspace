package servlet.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import config.Serverinfo;
import servlet.model.vo.MemberDTO;
import servlet.model.vo.MemberVO;

public class MemberDAO implements MemberDAOTemplate {
	
	// 싱글톤 패턴 - 클래스의 객체가 항상 하나만 존재하도록 
	
	/*
	 * 
	 * DAO 를 반복적으로 생성하고 해제하는 것은 비효율적
	 * 객체 지향적 설계! 싱글톤 패턴은 객체 지향적 설계 원칙을 준수 -> 중앙에서 처리!
	 * 주의할 점은 싱글톤은 전역 상태를 가질 수 있으므로 오남용하면 애플리케이션의 복잡성이 증가
	 * 
	 */
	private static MemberDAO dao = new MemberDAO();
	private MemberDAO() {
		try {
			Class.forName(Serverinfo.DRIVER_NAME);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	public static MemberDAO getInstatace() {
		return dao;
	}

//	public MemberDAO() {
//		try {
//			Class.forName(Serverinfo.DRIVER_NAME);
//		} catch (ClassNotFoundException e) {
//			e.printStackTrace();
//		}
//	}

	@Override
	public Connection getConnection() throws SQLException {
		Connection conn = DriverManager.getConnection(Serverinfo.URL, Serverinfo.USER, Serverinfo.PASSWORD);
		return conn;
	}

	@Override
	public void closeAll(PreparedStatement ps, Connection conn) throws SQLException {
		ps.close();
		conn.close();
	}

	@Override
	public void closeAll(ResultSet rs, PreparedStatement ps, Connection conn) throws SQLException {
		rs.close();
		closeAll(ps, conn);
	}

	@Override
	public void registerMember(MemberVO vo) throws SQLException {
		String query = "INSERT INTO MEMBER VALUES (?,?,?,?)";
		Connection conn = getConnection();
		PreparedStatement ps = conn.prepareStatement(query);
		ps.setString(1, vo.getId());
		ps.setString(2, vo.getPassword());
		ps.setString(3, vo.getName());
		ps.setString(4, vo.getAddress());
		ps.executeUpdate();
		closeAll(ps, conn);
	}

	@Override
	public MemberVO login(String id, String password) throws SQLException {
		Connection conn = getConnection();
		String query = "SELECT * FROM MEMBER WHERE ID = ? AND PASSWORD = ? ";
		PreparedStatement ps = conn.prepareStatement(query);
		ps.setString(1, id);
		ps.setString(2, password);
		ResultSet rs = ps.executeQuery();
		String id1 = "";
		String password1 = "";
		String name = "";
		String addr = "";
		if (rs.next()) {
			id1 = rs.getString("id");
			password1 = rs.getString("password");
			name = rs.getString("name");
			addr = rs.getString("addr");
			
		}
		MemberVO vo = new MemberVO(id1, password1, name, addr);
		closeAll(rs, ps, conn);
		return vo;
	}

	@Override
	public MemberVO findByIdMember(String id) throws SQLException {
		Connection conn = getConnection();
		String query = "SELECT * FROM MEMBER WHERE ID = ?";
		PreparedStatement ps = conn.prepareStatement(query);
		ps.setString(1, id);
		ResultSet rs = ps.executeQuery();
		String id1 = "";
		String password1 = "";
		String name = "";
		String addr = "";
		if (rs.next()) {
			id1 = rs.getString("id");
			password1 = rs.getString("password");
			name = rs.getString("name");
			addr = rs.getString("addr");
		}
		MemberVO vo = new MemberVO(id1, password1, name, addr);
		closeAll(rs, ps, conn);
		return vo;
	}

	@Override
	public ArrayList<MemberVO> showAllMember() throws SQLException {
		Connection conn = getConnection();
		String query = "SELECT * FROM MEMBER";
		PreparedStatement ps = conn.prepareStatement(query);
		ArrayList<MemberVO> voList = new ArrayList<MemberVO>();
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			String id = rs.getString("id");
			String password = rs.getString("password");
			String name = rs.getString("name");
			String addr = rs.getString("addr");
			MemberVO vo = new MemberVO(id, password, name, addr);
			voList.add(vo);
		}
		closeAll(rs, ps, conn);
		return voList;
	}
	@Override
	public void updateMember(MemberVO vo) throws SQLException {
		Connection conn = getConnection();
		String query = "UPDATE MEMBER SET PASSWORD = ?, NAME = ?, ADDR = ? WHERE ID = ?";
		PreparedStatement ps = conn.prepareStatement(query);
		ps.setString(1, vo.getPassword());
		ps.setString(2, vo.getName());
		ps.setString(3, vo.getAddress());
		ps.setString(4, vo.getId());
		ps.executeUpdate();
		closeAll(ps, conn);
	}

}
