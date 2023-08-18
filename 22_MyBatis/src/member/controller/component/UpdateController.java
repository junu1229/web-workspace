package member.controller.component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member.controller.ModelAndView;
import member.model.service.MemberService;
import member.model.vo.MemberVO;

public class UpdateController implements member.controller.Controller{

	@Override
	public member.controller.ModelAndView handle(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		MemberVO temp = (MemberVO) session.getAttribute("vo");
		String password = request.getParameter("password");
		String name = request.getParameter("name");
		String addr = request.getParameter("addr");
		String path = "views/update_result.jsp";
		MemberVO vo = new MemberVO(temp.getId(), password, name, addr);
		new MemberService().updateMember(vo);
		session.setAttribute("vo", vo);
		return new ModelAndView(path, true);
	}

}
