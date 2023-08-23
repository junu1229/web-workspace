package edu.kh.test.user.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.kh.test.user.model.dao.UserDAO;
import edu.kh.test.user.model.vo.UserDTO;

@WebServlet("/SelectUserServlet")
public class SelectUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int userNo = Integer.parseInt(request.getParameter("userNo"));
		UserDAO dao = new UserDAO();
		try {
			UserDTO dto = dao.searchUser(userNo);
			
			if(dto!=null) {
				request.setAttribute("result", dto);
				request.getRequestDispatcher("WEB-INF/views/searchSuccess.jsp").forward(request, response);
			} else {
				request.getRequestDispatcher("WEB-INF/views/searchFail.jsp").forward(request, response);
			}
		} catch (SQLException e) {
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
