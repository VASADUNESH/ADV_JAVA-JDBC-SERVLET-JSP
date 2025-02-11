package test;

import jakarta.servlet.*;
import java.io.*;
import jakarta.servlet.annotation.*;

@WebServlet("/dis")
public class DisplayServlet implements Servlet{
	
	ServletConfig scf;
	
	@Override
	public void init(ServletConfig scf) {
		this.scf=scf;
	}
	
	@Override
	public void service(ServletRequest req, ServletResponse res) throws IOException {
		
		String uName = req.getParameter("uName");
		String pwd	= req.getParameter("pwd");
		String fName = req.getParameter("fName");
		String lName =req.getParameter("lName");
		String city = req.getParameter("city");
		String mId =req.getParameter("mId");
		String pNo =req.getParameter("phoneNo");
		
		//ServletContext sct = req.getServletContext();
		PrintWriter pw = res.getWriter();
		res.setContentType("text/html");
		
		pw.println("Details:\n"+uName+pwd+fName+lName+city+mId+pNo);
		
		
		
	}
	
	@Override
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
