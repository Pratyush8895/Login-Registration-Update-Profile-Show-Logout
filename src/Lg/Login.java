package Lg;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//@WebServlet("/xyz")
public class Login extends HttpServlet {
	//private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String name=request.getParameter("t1");
		String pass=request.getParameter("t2");
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/interface","root","root");
			PreparedStatement ps=con.prepareStatement("select * from register1 where Username=(?) and Password=(?)");
	
			ps.setString(1, name);
			ps.setString(2,pass);
			ResultSet rs=ps.executeQuery();
			if(rs.next())
			{
			out.println("<html><body bgcolor='yellow'><font color='cyan' size='5'><center>");
			out.println("<b>u are an authenticate user</b>");
			out.println("</center></font></body></html>");
			RequestDispatcher rd=request.getRequestDispatcher("/Show");
			rd.forward(request,response);
			}else{
			out.println("<html><body bgcolor='yellow'><font color='cyan' size='5'><center>");
			out.println("<b>u are not an authenticate user</b>");
			out.println("<i>try again</i>");
			out.println("</center></font></body></html>");
			RequestDispatcher rd=request.getRequestDispatcher("/login.html");
			rd.include(request,response);
			con.close();
	}
}catch(Exception e)
		{
	System.out.println(e);
		}
	}
}