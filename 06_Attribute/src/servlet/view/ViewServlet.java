package servlet.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import servlet.model.MemberVO;

/**
 * Servlet implementation class ViewServlet
 */
public class ViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private ServletContext context;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		request.setCharacterEncoding("utf-8");
//		response.setContentType("text/html;charset=utf-8");
//		String name = request.getParameter("name");
//		String age = request.getParameter("age");
//		String addr = request.getParameter("addr");
		/*
		 * 1. Attribute에 바인딩된 데이터를 받아와서
		 * 2. 웹브라우저로 출력하는 로직을 작성..
		 * 
		 */
		context = getServletContext();
		MemberVO vo = (MemberVO) context.getAttribute("vo");
		PrintWriter out = response.getWriter();
		out.println("<p>" + vo + "<p>");
//		out.println("<p>"+ name + " " + age + " " + addr +"</p>");
		
	}

}
