package test;

import java.io.IOException;

import jakarta.servlet.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.*;
@WebServlet("/login")

public class LoginServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String uName = req.getParameter("uName");
		String pwd = req.getParameter("pwd");
		
		LoginDAO ld = new LoginDAO();
		UserBean ub = ld.login(uName, pwd);
		//System.out.println("ub Done"+ub);
		if (ub==null) {
			//System.out.println("enter to null");
			req.setAttribute("msg", "Invalid Login Process...<br><br><br>");
			RequestDispatcher rd = req.getRequestDispatcher("Msg.jsp");
			rd.forward(req, res);
		}
		else {
			//System.out.println("verifing");
			ServletContext sct = req.getServletContext();
			sct.setAttribute("ub",ub);
			
			Cookie ck = new Cookie("fName",ub.getfName());
			res.addCookie(ck);
			RequestDispatcher rd = req.getRequestDispatcher("LoginSuccess.jsp");
			rd.forward(req, res);
		}
	}
}
