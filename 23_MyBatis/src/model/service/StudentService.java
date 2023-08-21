package model.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import common.Template;
import model.dao.StudentDAO;
import model.vo.StudentVO;

public class StudentService {

	public List<StudentVO> showStudent(String string) {
		SqlSession sqlSession = Template.getSqlSession();
		System.out.println("studentservice");
		List<StudentVO> list = StudentDAO.getInstance().showStudent(sqlSession, string);
		sqlSession.close();
		return list;
	}
	
}
