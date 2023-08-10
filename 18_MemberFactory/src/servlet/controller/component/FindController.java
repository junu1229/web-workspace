package servlet.controller.component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import servlet.controller.Controller;
import servlet.controller.ModelAndView;
import servlet.model.dao.MemberDAO;
import servlet.model.vo.MemberVO;

public class FindController implements Controller{

	@Override
	public ModelAndView handle(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String id = request.getParameter("id");
		String path = "views/find_fail.jsp";
		MemberVO vo = MemberDAO.getInstatace().findByIdMember(id);
		if(!vo.getName().isBlank()) {
			request.setAttribute("findvo", vo);
			path = "views/find_ok.jsp";
			return new ModelAndView(path);
		}
		return new ModelAndView(path, true);
	}

}
