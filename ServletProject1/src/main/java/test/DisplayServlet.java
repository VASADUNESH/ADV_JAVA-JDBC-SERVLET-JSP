package test;

import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
/*
 * Assignment-1:
Construct Servlet Application to read and display UserDetails.
  UserName
  Password
  FirstName  
  LastName
  City
  MailId
  PhoneNo

 */

@WebServlet("/dis")
public class DisplayServlet implements Servlet{
	
	public ServletConfig scf;
	@Override
	public void init(ServletConfig scf ) throws ServletException{
		this.scf=scf;
	}
	
	@Override
	public void service(ServletRequest req,ServletResponse res) throws IOException{
		
		String uName = req.getParameter("uName");
		String mid = req.getParameter("mId");
		
		//ServletContext sct = req.getServletContext();
		PrintWriter pw = res.getWriter();
		res.setContentType("text/html");
		
		pw.println("Details: Name: "+uName+"Mail Id: "+mid);
		
	}
	
	public void destroy() {
		
	}
	
	@Override
	public String getServletInfo() {
		return "Display Servlet";
	}
	
	public ServletConfig getServletConfig() {
		return this.getServletConfig();
	}
	

}

