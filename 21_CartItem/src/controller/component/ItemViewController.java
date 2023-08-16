package controller.component;

import java.util.Date;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import controller.ModelAndView;
import model.Item;
import model.ItemDAO;

public class ItemViewController implements Controller{

	@Override
	public ModelAndView handle(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Date date = new Date();
		int remainMin = ((24-date.getHours())*60)-date.getMinutes();
		String path = "itemView.jsp";
		int id = Integer.parseInt(request.getParameter("item_id"));
		ItemDAO.getInstance().updateRecordCount(id);
		Item item = ItemDAO.getInstance().getItem(id);
		request.setAttribute("item", item);
		Cookie cookie = new Cookie("item"+id, item.getPictureUrl());
		cookie.setMaxAge(remainMin*60);
		response.addCookie(cookie);
		return new ModelAndView(path);
	}

}
