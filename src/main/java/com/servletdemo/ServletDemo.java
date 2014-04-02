package com.servletdemo;

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

	@Override
	public void init() throws ServletException {
		super.init();
		try {
			Class.forName ("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
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
		out.println("</body>");
		out.println("</html>");
	}
}
