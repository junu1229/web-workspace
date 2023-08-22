package model.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import common.Template;
import model.dao.StudentDAO;
import model.vo.StudentVO;

public class StudentService {

	public List<StudentVO> showStudent(String search) {
		SqlSession sqlSession = Template.getSqlSession();
		List<StudentVO> list = StudentDAO.getInstance().showStudent(sqlSession, search);
		sqlSession.close();
		return list;
	}
	
}
