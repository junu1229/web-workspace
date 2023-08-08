package servlet.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import servlet.model.dao.MemberDAO;
import servlet.model.vo.MemberDTO;

/**
 * Servlet implementation class FindMemberServlet
 */
public class FindMemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
//		MemberDAO dao = new MemberDAO();
		MemberDTO dto = new MemberDTO();
		try {
			dto.setId(MemberDAO.getInstatace().findByIdMember(id).getId());
			dto.setPassword(MemberDAO.getInstatace().findByIdMember(id).getPassword());
			dto.setName(MemberDAO.getInstatace().findByIdMember(id).getName());
			dto.setAddress(MemberDAO.getInstatace().findByIdMember(id).getAddress());
			request.setAttribute("finddto", dto);
		} catch (SQLException e) {
		}
		if (dto.getName()!=null) {
			RequestDispatcher rdp = request.getRequestDispatcher("views/find_ok.jsp");
			rdp.forward(request, response);
		} else {
			response.sendRedirect("views/find_fail");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
