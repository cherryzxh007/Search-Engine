import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.*;


public class LoginServlet extends HttpServlet {

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
		
		WebPage page = null;
		String uri = req.getRequestURI();
		
		if (uri.equals("/login")) {
			page = new LoginPage();
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
	
	/**
	 * post username and password
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
	
		/**
		 * set email as a account
		 */
		String useremail = req.getParameter("useremail");
		String pw = req.getParameter("pw");
		
		UserDatabase userdb = new UserDatabase();
		
		if (userdb.userVerification(pw, useremail)) {
			
			res.addCookie(new Cookie("zapperuser", useremail));
			res.setStatus(HttpServletResponse.SC_OK);
			res.sendRedirect(res.encodeRedirectURL("/index"));
			
		}
		else {
			// not finished
			res.sendRedirect(res.encodeRedirectURL("/login?status="+String.valueOf(userdb.error.ordinal())));
		}
		
	}
	
}
