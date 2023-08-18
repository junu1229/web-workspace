package servlet.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import config.Serverinfo;
import servlet.model.vo.MemberDTO;

public class MemberRepository implements MemberDAOTemplate {
	

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
	public void registerMember(MemberDTO dto) throws SQLException {
		String query = "INSERT INTO MEMBER VALUES (?,?,?,?)";
		Connection conn = getConnection();
		PreparedStatement ps = conn.prepareStatement(query);
		ps.setString(1, dto.getId());
		ps.setString(2, dto.getPassword());
		ps.setString(3, dto.getName());
		ps.setString(4, dto.getAddress());
		ps.executeUpdate();
		closeAll(ps, conn);
	}

	@Override
	public MemberDTO login(String id, String password) throws SQLException {
		Connection conn = getConnection();
		String query = "SELECT * FROM MEMBER WHERE ID = ? AND PASSWORD = ? ";
		PreparedStatement ps = conn.prepareStatement(query);
		ps.setString(1, id);
		ps.setString(2, password);
		ResultSet rs = ps.executeQuery();
		MemberDTO memberDTO = new MemberDTO();
		if (rs.next()) {
			String id1 = rs.getString("id");
			String password1 = rs.getString("password");
			String name = rs.getString("name");
			String addr = rs.getString("addr");
			memberDTO.setId(id1);
			memberDTO.setPassword(password1);
			memberDTO.setName(name);
			memberDTO.setAddress(addr);
		}
		closeAll(rs, ps, conn);
		System.out.println(memberDTO.getName());
		return memberDTO;
	}

	@Override
	public MemberDTO findByIdMember(String id) throws SQLException {
		Connection conn = getConnection();
		String query = "SELECT * FROM MEMBER WHERE ID = ?";
		PreparedStatement ps = conn.prepareStatement(query);
		ps.setString(1, id);
		ResultSet rs = ps.executeQuery();
		MemberDTO memberDTO = new MemberDTO();
		if (rs.next()) {
			String id1 = rs.getString("id");
			String password1 = rs.getString("password");
			String name = rs.getString("name");
			String addr = rs.getString("addr");
			memberDTO.setId(id1);
			memberDTO.setPassword(password1);
			memberDTO.setName(name);
			memberDTO.setAddress(addr);
		}
		closeAll(rs, ps, conn);
		return memberDTO;
	}

	@Override
	public ArrayList<MemberDTO> showAllMember() throws SQLException {
		Connection conn = getConnection();
		String query = "SELECT * FROM MEMBER";
		PreparedStatement ps = conn.prepareStatement(query);
		ArrayList<MemberDTO> dtoList = new ArrayList<MemberDTO>();
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			MemberDTO memberDTO = new MemberDTO();
			String id = rs.getString("id");
			String password = rs.getString("password");
			String name = rs.getString("name");
			String addr = rs.getString("addr");
			memberDTO.setId(id);
			memberDTO.setPassword(password);
			memberDTO.setName(name);
			memberDTO.setAddress(addr);
			dtoList.add(memberDTO);
		}
		closeAll(rs, ps, conn);
		return dtoList;
	}
	@Override
	public void updateMember(MemberDTO dto) throws SQLException {
		Connection conn = getConnection();
		String query = "UPDATE MEMBER SET PASSWORD = ?, NAME = ?, ADDR = ? WHERE ID = ?";
		PreparedStatement ps = conn.prepareStatement(query);
		ps.setString(1, dto.getPassword());
		ps.setString(2, dto.getName());
		ps.setString(3, dto.getAddress());
		ps.setString(4, dto.getId());
		ps.executeUpdate();
		closeAll(ps, conn);
	}

}
