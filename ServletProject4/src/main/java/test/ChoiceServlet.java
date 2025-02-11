package test;

import java.io.IOException;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;

@WebServlet("/choice")

public class ChoiceServlet extends GenericServlet{

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {

		String s1 = req.getParameter("s1");
		if(s1.equals("add")) {
			RequestDispatcher rd = req.getRequestDispatcher("ad");
			rd.forward(req, res);
		}
		else if(s1.equals("avg")){
			RequestDispatcher rd = req.getRequestDispatcher("av");
			rd.forward(req, res);
		}
		
	}

	

}
