package member.controller.component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member.controller.Controller;
import member.controller.ModelAndView;
import member.model.service.MemberService;
import member.model.vo.MemberVO;

public class LoginController implements Controller{

	@Override
	public ModelAndView handle(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		MemberVO temp = new MemberVO(id, password, null, null);
		String path = "index.jsp";
		MemberVO vo = new MemberService().login(temp);
		if(!vo.getName().isBlank()) {
			path = "views/login_result.jsp";
			session.setAttribute("vo", vo);
		} 
		return new ModelAndView(path, true);
	}
	
}
