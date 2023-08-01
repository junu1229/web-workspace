package servlet.form;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HttpFormServlet
 */
public class HttpFormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		/*
		 * 한글처리는..양방향!
		 */
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String id = request.getParameter("userId");
		String password = request.getParameter("userPwd");
		String gender = request.getParameter("gender");
		String[] menus = request.getParameterValues("menu");
		PrintWriter out = response.getWriter();
		out.println("<h2>정보를 출력합니다...</h2>");
		out.println("<p>"+id+"<p>");
		out.println("<p>"+password+"<p>");
		out.println("<ul>");
		for(String menu : menus) {
			out.println("<li>"+menu+"</li>");
		}
		out.println("</ul>");
		out.println("<p>"+gender+"</p>");
		out.close();
	}

}
