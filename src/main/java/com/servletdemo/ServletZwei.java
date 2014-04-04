package com.servletdemo;

import com.servletdemo.dao.Entity;
import com.servletdemo.dao.EntityDAO;
import com.servletdemo.dao.EntityDAOImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Vladimir Mishatkin on 03.04.2014.
 */
public class ServletZwei extends HttpServlet {
	private EntityDAO dao;

	@Override
	public void init() throws ServletException {
		super.init();
		dao = new EntityDAOImpl();
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.doPost(request, response);
		PrintWriter out = response.getWriter();
		out.print("<html><body>");
		String name = request.getParameter("input_name");
		out.println("Did");
		try {
			dao.saveEntity(new Entity(7, name));
		} catch (Exception e) {
			out.println(" not");
		}
		out.println(" save " + name + "<br/>");
		out.println("<form method = \"get\"><button type=\"submit\" value=\"OKValue\" formmethod=\"get\">OK</button></form><br/>");
		out.println("</body></html>");
	}
}
