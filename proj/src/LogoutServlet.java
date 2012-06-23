import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.*;


public class LogoutServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
		
		String uri = req.getRequestURI();
		if (uri.equals("/logout")) {
			Cookie cookie = new Cookie("zapperuser", null);
			cookie.setMaxAge(0);
			cookie.setPath("/");
			res.addCookie(cookie);
			res.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
			res.sendRedirect(res.encodeRedirectURL("/index"));
		}
		else {
			res.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
			res.sendRedirect(res.encodeRedirectURL("/index"));
		}
		
	}
	
}
