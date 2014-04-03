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
			Class.forName ("oracle.jdbc.OracleDriver");
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
		out.println("<form action=\"demo\" method = \"post\">");
		out.println("Name: <input type=\"text\" name=\"input_name\">");
		out.println("<button type=\"submit\" value=\"AddValue\" formmethod=\"post\">Add</button><br/>");
		out.println("</form>");
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.doPost(request, response);
//		response.setContentType("text/html");
//		response.setStatus(HttpServletResponse.SC_TEMPORARY_REDIRECT);
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

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<body>qwe<br/>");
		List<Entity> allFolks = dao.getAll();
		for (Entity folk : allFolks) {
			out.println(folk.getId() + " " + folk.getName());
		}
		printHtmlSubmitForm(out);
		out.println("</body>");
		out.println("</html>");
	}
}
