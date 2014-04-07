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
import java.util.List;

/**
 * Created by Vladimir Mishatkin on 31.03.2014.
 */
public class ServletDemo extends HttpServlet {
	static {
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	private EntityDAO dao;

	@Override
	public void init() throws ServletException {
		super.init();
		dao = new EntityDAOImpl();
	}

	private void printHtmlSubmitForm(PrintWriter out) {
		out.println("<form action=\"other\" method = \"post\">");
		out.println("Name: <input type=\"text\" name=\"input_name\">");
		out.println("<button type=\"submit\" value=\"AddValue\" formmethod=\"post\">Add</button><br/>");
		out.println("</form>");
	}

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
		super.service(request, resp);
		List<Entity> allFolks = dao.getAll();
		request.setAttribute("folks", allFolks);
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		List<Entity> allFolks = dao.getAll();
		request.setAttribute("folks", allFolks);
		request.setAttribute("message", "Waddup");
//		request.getRequestDispatcher("index.jsp").forward(request,response);
	}
}
