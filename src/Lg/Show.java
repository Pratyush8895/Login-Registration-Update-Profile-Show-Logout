package Lg;

import java.io.IOException;
import java.io.*;
import java.sql.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class Show extends HttpServlet {
	Connection cn=null;
	PreparedStatement ps;
	ResultSet rs;
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
			response.setContentType("text/html");
			PrintWriter out=response.getWriter();
			out.println("<html><body background='image/baby4.jpg'><font color='black'><center>");
			out.println("<form action='/logout' method='post'>");
			String name=request.getParameter("t1");
			try {
			Class.forName("com.mysql.jdbc.Driver");
			cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/interface","root","root");
			ps=cn.prepareStatement("SELECT UserName, Contact, Email FROM register1 WHERE UserName=?");
			ps.setString(1,name);
			rs=ps.executeQuery();
			while(rs.next())
			{
				
				out.println("<b>WelCome-"+rs.getString(1)+"</b>");
				out.println("<br><b>Your Contact Number :-"+rs.getInt(2)+"</b>");
				out.println("<br><b>Mail Id:-"+rs.getString(3)+"</b>");
			}
			
			out.println("<form action='logout' method='post'>");
			out.println("<br><a href='Update.html'>UPDATE</a>");
			out.println("<br><a href='/LoginReg/index.html'><button type= 'button'>Logout</button></a>");
			out.println("</form></center></font></body><html>");
			cn.close();
			
			}catch(Exception e)
			{
				e.printStackTrace();
			}
		}
	}
