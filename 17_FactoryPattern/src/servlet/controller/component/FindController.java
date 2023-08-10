package servlet.controller.component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import servlet.controller.Controller;
import servlet.model.dao.MemberDAO;
import servlet.model.vo.MemberVO;

public class FindController implements Controller{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String path = "find_fail.jsp";
		String id = request.getParameter("id");
		MemberVO vo = MemberDAO.getInstatace().findByIdMember(id);
		request.setAttribute("findvo", vo);
		if(!vo.getName().isBlank()) {
			path = "find_ok.jsp";
		}
		return path;
	}

}
