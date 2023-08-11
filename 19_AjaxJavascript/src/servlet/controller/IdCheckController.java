package servlet.controller;

import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import servlet.model.dao.MemberDAO;
import servlet.model.vo.MemberVO;

public class IdCheckController implements Controller{

	@Override
	public ModelAndView handle(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String id = request.getParameter("id");
		try {
			MemberVO mv = MemberDAO.getInstatace().findByIdMember(id);
			PrintWriter pw = response.getWriter();
			if(mv.getName().isBlank()) {
				pw.println("사용 가능한 아이디입니다.");
				System.out.println("~~~~~");
			} else {
				pw.println("이미 존재하는 아이디입니다.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return new ModelAndView();
	}

}
