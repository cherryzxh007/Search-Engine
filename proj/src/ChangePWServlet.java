import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class ChangePWServlet extends HttpServlet {

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
		
		WebPage page = null;
		String uri = req.getRequestURI();
		
		if (uri.equals("/account/changepw")) {
			page = new ChangePWPage();
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
		
		String useremail = Indexer.getInstance().username;
		String oldpw = req.getParameter("oldpw");
		String newpw = req.getParameter("newpw");
		UserDatabase userdb = new UserDatabase();
		
		if (userdb.userVerification(oldpw, useremail)) {
			
			if (userdb.changePW(useremail, newpw)) {
				res.setStatus(HttpServletResponse.SC_OK);
				res.sendRedirect(res.encodeRedirectURL("/index"));
			}
			else {
				res.sendRedirect(res.encodeRedirectURL("/account/changepw?status="+String.valueOf(userdb.error.ordinal())));
			}
			
		}
		else {
			res.sendRedirect(res.encodeRedirectURL("/account/changepw?status="+String.valueOf(userdb.error.ordinal())));
		}
		
		
	}
	
}
