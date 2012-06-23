import java.io.*;

import javax.servlet.*;
import javax.servlet.http.*;


/**
 * return html to user
 */
public class MainPageServlet extends HttpServlet {

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
		
		WebPage page = null;
		String uri = req.getRequestURI();
		
		if (uri.matches("/index") || uri.matches("/")) {
			page = new MainPage();
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
}
