package Lg;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Logout extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  response.setContentType("text/html");  
          PrintWriter out=response.getWriter();  
          
        /*  HttpSession session=request.getSession();  
          session.invalidate(); */ 
            
          out.print("You are successfully logged out!"); 
          RequestDispatcher ds=request.getRequestDispatcher("/index.html");
          ds.forward(request, response);  
          out.close();  
	}

}
