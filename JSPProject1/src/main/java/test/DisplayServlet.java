package test;

import jakarta.servlet.*;
import jakarta.servlet.annotation.*;
import java.io.*;
@WebServlet("/dis")

public class DisplayServlet extends GenericServlet {
	
	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		RequestDispatcher rd = req.getRequestDispatcher("Display.jsp");
		rd.forward(req, res);
		
	}
}
