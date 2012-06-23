import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class CleanHistoryServlet extends HttpServlet {

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
		
		WebPage page = null;
		String uri = req.getRequestURI();
		
		if (uri.equals("/account/cleanhistory")) {
			page = new CleanHistoryPage();
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
		DatabaseHistory dbhistory = new DatabaseHistory();
		
		Map map = req.getParameterMap();
		if (map.containsKey("clearvisitedpage")) {
			dbhistory.resetVisitedPage(useremail);
		}
		if (map.containsKey("clearqueryhistory")) {
			dbhistory.resetQueryHistory(useremail);
		}
		
		res.setStatus(HttpServletResponse.SC_OK);
		res.sendRedirect(res.encodeRedirectURL("/index"));
		
		
	}
	
}
