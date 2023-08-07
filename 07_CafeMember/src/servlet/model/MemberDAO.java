package servlet.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import config.ServerInfo;


public class MemberDAO implements MemberDAOTemplate{
	public static void main(String[] args) {
		MemberDAO dao = new MemberDAO();
		try {
			dao.insertMember(new MemberVO("마마마", 3, "바바바"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public MemberDAO() {
		// 1. 드라이버 로딩
		try {
			Class.forName(ServerInfo.DRIVER_NAME);
			System.out.println("driver loading...");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Connection getConnection() throws SQLException {
//		2. 데이터 베이스와 연결
		Connection conn = DriverManager.getConnection(ServerInfo.URL,ServerInfo.USER,ServerInfo.PASSWORD);
		System.out.println("db connection...");
		return conn;
	}

	@Override
	public void closeAll(PreparedStatement ps, Connection conn) throws SQLException {
//		5. close 닫기
		ps.close();
		conn.close();
	}

	@Override
	public void closeAll(ResultSet rs, PreparedStatement ps, Connection conn) throws SQLException {
//		5. close 닫기
		rs.close();
		closeAll(ps, conn);
	}

	@Override
	public void insertMember(MemberVO vo) throws SQLException {
		
		// 3. Statement 객체 생성 
		String query = "INSERT INTO MEMBER VALUES (?, ?, ?)";
		Connection conn = getConnection();
		PreparedStatement ps = conn.prepareStatement(query);
		ps.setString(1, vo.getName());
		ps.setInt(2, vo.getAge());
		ps.setString(3, vo.getAddr());
		ps.executeUpdate();
		closeAll(ps, conn);
	}

	@Override
	public ArrayList<MemberVO> showAllMember() throws SQLException {
		String query = "SELECT * FROM MEMBER";
		Connection conn = getConnection();
		PreparedStatement ps = conn.prepareStatement(query); // "SELECT * FROM employee"이걸 jdbc에서 처리할 수 있는 객체를 만들기 위해 Statement를 상속 받은 것
		ArrayList<MemberVO> mvList = new ArrayList();
		//4. 쿼리문 실행
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {	//rs 다음 것들이 있는지
			//어떤 컬럼들을 가져올지 명시
			String name = rs.getString("name");
			int age = rs.getInt("age");
			String addr = rs.getString("addr");
			mvList.add(new MemberVO(name, age, addr));
		}
		closeAll(rs, ps, conn);
		return mvList;
	}

	@Override
	public MemberVO finndByNameMember(String name) throws SQLException {
		Connection conn = getConnection();
		String query = "SELECT * FROM MEMBER WHERE NAME = ?";
		PreparedStatement ps = conn.prepareStatement(query);
		ps.setString(1, name);
		ResultSet rs = ps.executeQuery();
		MemberVO mv = new MemberVO();
		if(rs.next()) {
			mv.setName(rs.getString("name"));
			mv.setAge(rs.getInt("age"));
			mv.setAddr(rs.getString("addr"));
		}
		
		System.out.println(mv);
		closeAll(rs, ps, conn);
		return mv;
	}
		
}
