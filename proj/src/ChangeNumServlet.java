import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class ChangeNumServlet extends HttpServlet {

protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
		
		WebPage page = null;
		String uri = req.getRequestURI();
		
		if (uri.equals("/account/changenumpage")) {
			page = new ChangeNumPage();
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
	
		int num = Integer.parseInt(req.getParameter("num"));
		
		ResultPage.recordPageNum = num;
		
		res.setStatus(HttpServletResponse.SC_OK);
		res.sendRedirect(res.encodeRedirectURL("/index"));
		
	}
	
}
