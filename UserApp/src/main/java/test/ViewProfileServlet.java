package test;
import jakarta.servlet.http.*;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.*;
@WebServlet("/view")

public class ViewProfileServlet extends HttpServlet{
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		Cookie c[] = req.getCookies();
		if(c==null) {
			req.setAttribute("msg","Session Expired");
			req.getRequestDispatcher("Msg.jsp").forward(req, res);;
		}
		else {
			String fn = c[0].getValue();
			req.setAttribute("fname", fn);
			req.getRequestDispatcher("ViewProfile.jsp").forward(req, res);
			
		}
	}
}
