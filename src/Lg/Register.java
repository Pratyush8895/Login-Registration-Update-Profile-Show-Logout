package Lg;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Register extends HttpServlet {
	Connection con=null;
	PreparedStatement ps;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		String name=request.getParameter("t1");
		String pass=request.getParameter("t2");
		int contact=Integer.parseInt(request.getParameter("t3"));
		String email=request.getParameter("t4");
		
		try{
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/interface","root","root");
			ps=con.prepareStatement(" INSERT INTO register1 VALUES(?,?,?,?)");
			ps.setString(1,name);
			ps.setString(2,pass);
			ps.setInt(3,contact);
			ps.setString(4,email);
			//int i=0;
			int i=ps.executeUpdate();
			//out.println("<html><body bgcolor='red'><center>");
			//out.println("<b>register succesfully</b>");
			RequestDispatcher rd=request.getRequestDispatcher("/login.html");
			rd.forward(request,response);	
	
			}catch(Exception e)
				{
				//out.println("name already exist");
				e.printStackTrace();
				}
			}
	public void destroy()
	{
		try {
			con.close();
			ps.close();
		}catch(Exception ee) {
			ee.printStackTrace();
		}
	}

	}
