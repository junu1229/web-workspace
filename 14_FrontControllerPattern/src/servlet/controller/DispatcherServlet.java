package servlet.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import servlet.model.dao.MemberDAO;
import servlet.model.vo.MemberVO;

@WebServlet(urlPatterns = "/front.do")
public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 요청이 어디에서 들어오는 요청인지.. command 값 받는다.
		String command = request.getParameter("command");
		String path = "index.jsp";
		
		try {
			if(command.equals("register")) {
				path = register(request, response);
			} else if(command.equals("showAll")) {
				path = showAll(request, response);
			} else if(command.equals("findMember")) {
				path = findMember(request, response);
			} else if(command.equals("login")) {
				path = login(request, response);
			} else if(command.equals("update")) {
				path = update(request, response);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		// 네비게이션
		request.getRequestDispatcher(path).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	protected String register(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException{
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		String name = request.getParameter("name");
		String addr = request.getParameter("addr");
		MemberVO vo = new MemberVO(id, password, name, addr);
		try {
			MemberDAO.getInstatace().registerMember(vo);
		} catch (SQLException e) {
		}
		return "index.jsp";
	}
	protected String showAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException{
		ArrayList<MemberVO> voList = new ArrayList<>();
		try {
			voList = MemberDAO.getInstatace().showAllMember();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		request.setAttribute("voList", voList);
		return "views/allShow.jsp";
	}
	protected String findMember(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException{
		String id = request.getParameter("id");
//		MemberDAO dao = new MemberDAO();
		MemberVO vo = new MemberVO();
		try {
			vo = MemberDAO.getInstatace().findByIdMember(id);
			if (!vo.getName().isBlank()) {
				request.setAttribute("findvo", vo);
				return "views/find_ok.jsp";
			}
		} catch (SQLException e) {
		}
		return "views/find_fail.jsp";
	}
	protected String login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException{
		HttpSession session = request.getSession();
		String id = request.getParameter("id");
		String password = request.getParameter("password");
//		MemberDAO dao = new MemberDAO();
		MemberVO vo = new MemberVO();
		try {
			vo = (MemberDAO.getInstatace().login(id, password));
			
			if (vo.getName().isBlank()) {
				return "/index.jsp";
			} else {
				session.setAttribute("vo", vo);
			}
		} catch (SQLException e) {
		}
		return "views/login_result.jsp";
	}
	protected String update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException{
		HttpSession session = request.getSession();
		String password = request.getParameter("password");
		String name = request.getParameter("name");
		String addr = request.getParameter("addr");
		MemberVO currentVo = (MemberVO)session.getAttribute("vo");
		System.out.println(currentVo);
		String id = currentVo.getId();
		System.out.println(id);
		MemberVO newVo = new MemberVO(id, password, name, addr);
		try {
			MemberDAO.getInstatace().updateMember(newVo);
			System.out.println(id);
		} catch (SQLException e) {
		}
		session.setAttribute("vo", newVo);
		return "views/update_result.jsp";
	}
	

}
