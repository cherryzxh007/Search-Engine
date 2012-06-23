import java.io.IOException;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.net.URL;

import javax.servlet.http.*;

import org.antlr.stringtemplate.*;


public abstract class WebPage {
	
	/**
	 * define string template library
	 */
	protected static StringTemplateGroup template = new StringTemplateGroup("mygroup", Indexer.getInstance().index.get("template"));
	
	private PrintWriter out;
	
	public int error;
	
	public HttpServletRequest req;
	
	public HttpServletResponse res;
	
	static {
		// do not cahce templates
		template.setRefreshInterval(0);
	}
	
	public void generation() throws IOException {
		out = res.getWriter();
		
		// call head.st
		StringTemplate webpage = template.getInstanceOf("head");
		StringTemplate bodyST = body();
		
		webpage.setAttribute("shortico", getURL("/zapper.ico"));
		// pic ?
		webpage.setAttribute("icon", getURL("/zapper.gif"));
		webpage.setAttribute("zapperjs", getURL("/zapper.js"));
		webpage.setAttribute("zappercss", getURL("/zapper.css"));
		webpage.setAttribute("body", bodyST);
		webpage.setAttribute("title", Title());
		this.errorMsg(bodyST);
		
		// render web page
		String web = webpage.toString();
		out.print(web);
	}
	
	public StringTemplate body() {
		return null;
	}
	
	public String Title() {
		return null;
	}
	
	public void TopMenu(StringTemplate st) {
		String headBar = "";
		Indexer indexer = Indexer.getInstance();
		if (!indexer.checkCookie(this.req, indexer.usernameCookie)) {
			// no cookies
			st.setAttribute("user", headBar);
			headBar = "<li><a href=\"/login\" title=\"Sign in\">Sign in</a></li>";
			st.setAttribute("logout", headBar);
		}
		else {
			// has cookies
			headBar = "<li>"+indexer.username+"</li><li>|</li>";
			st.setAttribute("user", headBar);
			headBar = "<li><a href=\"/account\" title=\"Settings\">Settings</a></li><li>|</li>";
			st.setAttribute("setting", headBar);
			headBar = "<li><a href=\"/userhistory\" title=\"Myhistory\">My History</a></li><li>|</li>";
			st.setAttribute("userhistory", headBar);
			headBar = "<li><a href=\"/logout\" title=\"Sign in\">Sign out</a></li>";
			st.setAttribute("logout", headBar);
		}
		
	}
	
	/**
	 * get absolute url
	 */
	public String getURL(String link) {
		URL url = null;
		try {
			url = new URL(req.getScheme(), req.getServerName(), req.getServerPort(), link);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (url != null) {
			return url.toString();
		}
		else {
			return link;
		}
	}
	
	/**
	 * set up error msg
	 */
	private void errorMsg(StringTemplate st) {
		
		if (req.getParameterMap().containsKey("status"))
		{
			int errorNum = ErrorMsg.values().length;
			int status = Integer.parseInt(req.getParameter("status"));
			
			if (status >= errorNum)
				//undefined server error message
				st.setAttribute("errormsg","Application error, Please restart application.");
			else
				st.setAttribute("errormsg", ErrorMsg.values()[status].getErrormsg());
		}
		
	}
}
