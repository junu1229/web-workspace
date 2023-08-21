package member.model.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import common.SqlSessionTemplate;
import member.model.dao.MemberDAO;
import member.model.vo.MemberVO;

// DAO - Service - Controller
public class MemberService {
	
	public int registerMember(MemberVO vo) {
		SqlSession sqlSession = SqlSessionTemplate.getSqlSession();
		int result = MemberDAO.getInstatace().registerMember(sqlSession, vo);
		if(result > 0) sqlSession.commit();
		sqlSession.close();
		return result;
	}
	public List<MemberVO> showAllMember() {
		SqlSession sqlSession = SqlSessionTemplate.getSqlSession();
		List<MemberVO> result = MemberDAO.getInstatace().showAllMember(sqlSession);
		sqlSession.close();
		return result;
	}
	public List<MemberVO> findByIdMember(String[] idList) {
		SqlSession sqlSession = SqlSessionTemplate.getSqlSession();
		List<String> list = Arrays.asList(idList);
		List<MemberVO> result = MemberDAO.getInstatace().findByIdMember(sqlSession, list);
		sqlSession.close();
		return result;
	}
	public MemberVO login(MemberVO vo) {
		SqlSession sqlSession = SqlSessionTemplate.getSqlSession();
		MemberVO result = MemberDAO.getInstatace().login(sqlSession, vo);
		sqlSession.close();
		return result;
	}
	public int updateMember(MemberVO vo) {
		SqlSession sqlSession = SqlSessionTemplate.getSqlSession();
		int result = MemberDAO.getInstatace().updateMember(sqlSession, vo);
		if(result > 0) sqlSession.commit();
		sqlSession.close();
		return result;
	}
}
