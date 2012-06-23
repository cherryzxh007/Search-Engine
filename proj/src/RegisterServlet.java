import java.io.*;

import javax.servlet.*;
import javax.servlet.http.*;

public class RegisterServlet extends HttpServlet {

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
		
		WebPage page = null;
		String uri = req.getRequestURI();
		
		if (uri.equals("/register")) {
			page = new RegisterPage();
			page.req = req;
			page.res = res;
			
		}
		if (page == null) {
			System.out.println("Can not find " + uri);
		}
		else {
			page.generation();
		}
	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
		
		// log in with email
		String useremail = req.getParameter("useremail");
		String pw = req.getParameter("pw");
		String firstname = req.getParameter("firstname");
		String lastname = req.getParameter("lastname");
		
		UserDatabase userdb = new UserDatabase();
		
		if (userdb.register(useremail, pw, firstname, lastname)) {
			
			// set cookie and redirect to main page, show the cookie info in the page
			res.addCookie(new Cookie("zapperuser", useremail));
			res.setStatus(HttpServletResponse.SC_OK);
			res.sendRedirect(res.encodeRedirectURL("/index"));
			
		}
		else {
			res.sendRedirect(res.encodeRedirectURL("/register?status="+String.valueOf(userdb.error.ordinal())));
		}
		
	}
	
}
