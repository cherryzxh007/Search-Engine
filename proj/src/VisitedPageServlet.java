import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class VisitedPageServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		String uri = req.getRequestURI();
		
		if (uri.equals("/show")) {
			String link = req.getParameter("link");
			Indexer indexer = Indexer.getInstance();
			if (indexer.checkCookie(req, indexer.usernameCookie)) {
				DatabaseHistory dbhistory = new DatabaseHistory();
				dbhistory.saveVisitedPage(link, indexer.username);
			}
			
			res.setStatus(HttpServletResponse.SC_OK);
			res.sendRedirect(res.encodeRedirectURL(link));
		}
		
	}
	
}
