package org.kh.member.service;

import org.apache.ibatis.session.SqlSession;
import org.kh.member.config.SqlSessionTemplate;
import org.kh.member.model.dao.MemberDAO;
import org.kh.member.model.vo.MemberVO;

public class MemberServiceImpl {

	public int insertMember(MemberVO mOne) {
	 	SqlSession session = new SqlSessionTemplate().getSqlSession();
	 	int result = 0;
	 	result = new MemberDAO().insertMember(session, mOne);
	 	if(result>0) {
	 		session.commit();
	 		return result;
	 	} 
	 	session.rollback();
		return result;
	}

}