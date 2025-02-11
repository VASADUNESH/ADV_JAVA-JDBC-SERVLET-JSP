package test;

import jakarta.servlet.http.*;

import java.io.IOException;

import jakarta.servlet.*;
import jakarta.servlet.annotation.*;
@WebServlet("/reg")
public class RegisterServlet extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		UserBean ub = new UserBean();
		ub.setuName(req.getParameter("uName"));
		ub.setpWord(req.getParameter("pwd"));
		ub.setfName(req.getParameter("fName"));
		ub.setlName(req.getParameter("lName"));
		ub.setCity(req.getParameter("city"));
		ub.setmId(req.getParameter("email"));
		ub.setPhNo(Long.parseLong(req.getParameter("number")));
		
		RegisterDAO ob = new RegisterDAO();
		int k= ob.register(ub);
		if(k>0) {
			 RequestDispatcher rd = req.getRequestDispatcher("RegSuccess.jsp");
			 rd.forward(req, res);
		 }
		else {
			
				RequestDispatcher rd = req.getRequestDispatcher("RegFail.jsp");
				rd.forward(req, res);
		}
		
	}
	
	
	
}
