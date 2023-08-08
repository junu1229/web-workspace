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

@WebServlet("/UpdateServlet")
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String password = request.getParameter("password");
		String name = request.getParameter("name");
		String addr = request.getParameter("addr");
		MemberDTO currentMem = (MemberDTO)session.getAttribute("dto");
		System.out.println(currentMem);
		String id = currentMem.getId();
		System.out.println(id);
		MemberDTO newMem = new MemberDTO();
		newMem.setId(id);
		newMem.setPassword(password);
		newMem.setName(name);
		newMem.setAddress(addr);
		try {
			MemberDAO.getInstatace().updateMember(newMem);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		session.setAttribute("dto", newMem);
		response.sendRedirect("../views/update_result.jsp");
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
