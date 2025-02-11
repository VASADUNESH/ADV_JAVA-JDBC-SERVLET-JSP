package test;

import jakarta.servlet.*;
import java.io.*;
import jakarta.servlet.annotation.*;
/*
 * Assignment-2:
Construct Servlet Application to read and display Book details
   BookCode
   BookName
   BookAuthor
   BookQty
   BookPrice

 */
@WebServlet("/dis")
public class DisplayServlet implements Servlet{
	
	public ServletConfig scf;
	
	@Override
	public void init(ServletConfig scf) {
		this.scf=scf;
	}
	
	@Override
	public void service(ServletRequest req, ServletResponse res) throws IOException{
		
		String bCode = req.getParameter("bc");
		String bName = req.getParameter("bn");
		String bA = req.getParameter("ba");
		String bq =req.getParameter("ba");
		String bp =req.getParameter("bp");
		
		PrintWriter pw = res.getWriter();
		res.setContentType("text/html");
		
		pw.println("Book Details:\n"+bCode+bName+bA+bq+bp);
		
	}
	
	@Override
	public void destroy() {
		
	}
	
	@Override
	public String getServletInfo() {
		return "Display Servlet";
	}
	
	@Override
	public ServletConfig getServletConfig() {
		return this.getServletConfig();
	}
}
