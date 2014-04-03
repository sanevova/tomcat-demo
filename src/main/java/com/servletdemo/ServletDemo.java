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
import java.sql.*;

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
		Connection connection = null;
		try {
			connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "DAVID", "asdzxc");
			out.println("Did connect<br/><h1>");
			Statement statement = connection.createStatement();
			if(statement.execute("SELECT * FROM table1")) {
				out.print("Execution succeeded<br/>");
			}
			ResultSet resultSet = statement.getResultSet();
			while(resultSet.next()) {
				out.print(resultSet.getInt(1) + "\t");
				out.println(resultSet.getString(2) + "<br/>");
			}
		} catch (SQLException e) {
			out.print(e.getMessage());
			e.printStackTrace();
		} finally {
			if (connection != null) {
				out.print("</h1>finally thingy<br/>");
				try {
					connection.close();
					out.print("did close connection<br/>");
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		printHtmlSubmitForm(out);
		out.println("</body>");
		out.println("</html>");
	}
}
