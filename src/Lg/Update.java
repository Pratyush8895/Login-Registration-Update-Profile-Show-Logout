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


//@WebServlet("/Update")
public class Update extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection cn;
	PreparedStatement ps;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
			String username=request.getParameter("t1");
			String Password = request.getParameter("t2");
			int contact=Integer.parseInt(request.getParameter("t3"));
			String Email = request.getParameter("t4");
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/interface","root","root");
		//int result=0;
		ps=cn.prepareStatement( "update register1 set Password=?,Contact=?,Email=? WHERE UserName=?");
		ps.setString(4, username);
		ps.setString(1, Password);
		ps.setInt(2, contact);
		ps.setString(3, Email);

	int i=ps.executeUpdate();
		if(i!=0)
		{
		out.println("<html><body bgcolor='brown'><font color='black' size='5'><center>");
		out.println("<b>You are successfully update </b>");
		RequestDispatcher ds=request.getRequestDispatcher("/index.html");
		ds.include(request, response);
		}else {
			out.println("<b>imformation not available</b>");
			RequestDispatcher ds=request.getRequestDispatcher("/Update.html");
			ds.include(request, response);
		}
		}
		catch(ClassNotFoundException ce)
		{
		out.println("Error " + ce);
		}
		catch(SQLException se)
		{
		out.println("Error " + se);
		}
		finally
		{
		try
		{
		cn.close();
		}
		catch(Exception e)
		{
		}
		}
		}
	}
