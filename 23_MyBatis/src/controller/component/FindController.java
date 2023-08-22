package controller.component;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import com.fasterxml.jackson.databind.ObjectMapper;

import controller.Controller;
import controller.ModelAndView;
import model.service.StudentService;
import model.vo.StudentVO;
import oracle.net.aso.l;

public class FindController implements Controller{

	@Override
	public ModelAndView handle(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String search = request.getParameter("search");
		System.out.println(search);
		List<StudentVO> list = new StudentService().showStudent(search);
		PrintWriter out = response.getWriter();
//		for(StudentVO vo: list) {
//			out.print("<div style=\"display: flex; justify-content: center; margin-top: 3rem;\">\n"
//					+ "			<p style=\"width: 15%; margin-bottom: 0;\">"+vo.getStudentNo() +"</p>\n"
//					+ "			<p style=\"width: 10%;\">"+vo.getStudentName()+"</p>\n"
//					+ "			<p style=\"width: 50%;\">"+vo.getStudentAddress()+"</p>\n"
//					+ "			<p style=\"width: 10%;\">"+vo.getDepartment().getDepartmentName()+"</p>\n"
//					+ "			<p style=\"width: 10%;\">"+vo.getDepartment().getCategory()+"</p>\n"
//					+ "		</div>\n"
//					+ "		<hr style=\"margin: 0;\">");
//		}
		JSONObject json = new JSONObject();
		ObjectMapper mapper = new ObjectMapper();
		String result = mapper.writeValueAsString(list);
		json.put("result", result);
		out.print(json);
		// JSON 형식 
		request.setAttribute("list", list);
		return new ModelAndView(null);
	}

}
