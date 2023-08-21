package controller.component;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import controller.ModelAndView;
import model.service.StudentService;
import model.vo.StudentVO;
import oracle.net.aso.l;

public class FindController implements Controller{

	@Override
	public ModelAndView handle(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String path = "index.jsp";
		String string = request.getParameter("search");
		System.out.println("findcon");
		List<StudentVO> list = new StudentService().showStudent(string);
		PrintWriter out = response.getWriter();
		for(StudentVO vo:list) {
			out.print(vo.getStudentNo());
		}
		request.setAttribute("list", list);
		return new ModelAndView(path);
	}

}
