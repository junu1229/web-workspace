package servlet.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import servlet.model.MemberDAO;
import servlet.model.MemberVO;

/**
 * Servlet implementation class SearchServlet
 */
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private ServletContext context;
	MemberVO mv = new MemberVO();
	public void init(ServletConfig config) throws ServletException {
//		context = config.getServletContext();
//		context.setAttribute("list", list);
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MemberDAO dao = new MemberDAO();
		String searchName = request.getParameter("searchName");
		request.setAttribute("mv", mv);
		try {
			mv.setName(dao.finndByNameMember(searchName).getName()); 
			mv.setAge(dao.finndByNameMember(searchName).getAge());
			mv.setAddr(dao.finndByNameMember(searchName).getAddr());
			System.out.println(mv);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		RequestDispatcher rdp = request.getRequestDispatcher("view.jsp");
		rdp.forward(request, response);
	}
}
