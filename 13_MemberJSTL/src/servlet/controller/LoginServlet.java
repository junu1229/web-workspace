package servlet.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import servlet.model.dao.MemberDAO;
import servlet.model.vo.MemberDTO;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String id = request.getParameter("id");
		String password = request.getParameter("password");
//		MemberDAO dao = new MemberDAO();
		MemberDTO dto = new MemberDTO();
		try {
			dto.setId(MemberDAO.getInstatace().login(id, password).getId());
			dto.setPassword(MemberDAO.getInstatace().login(id, password).getPassword());
			dto.setName(MemberDAO.getInstatace().login(id, password).getName());
			dto.setAddress(MemberDAO.getInstatace().login(id, password).getAddress());
			if (dto.getName()==null) {
				response.sendRedirect("../index.jsp");
			} else {
				session.setAttribute("dto", dto);
				response.sendRedirect("views/login_result.jsp");
			}
		} catch (SQLException e) {
			response.sendRedirect("../index.jsp");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
