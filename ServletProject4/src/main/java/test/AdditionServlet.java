package test;

import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;

@WebServlet("/ad")

public class AdditionServlet  extends GenericServlet{

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		
		int v1 = Integer.parseInt(req.getParameter("v1"));
		int v2 = Integer.parseInt(req.getParameter("v2"));
		
		int add = v1+v2;
		PrintWriter pw = res.getWriter();
		res.setContentType("text/html");
		
		pw.println("Addition: "+(add));
		RequestDispatcher rd = req.getRequestDispatcher("home.html");
		rd.include(req, res);
		
		
		
		
	}
	
}
