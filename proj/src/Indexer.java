import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

import javax.servlet.http.*;


public class Indexer {
	
	private final String config = "/Users/Leo/Documents/USF/Courses/CS212/Assignment/proj/static/application.config";
	
	HashMap<String, String> index = new HashMap<String, String>();
	
	public static final Indexer instance = new Indexer();
	
	public String username;
	
	public String link;
	
	public final String usernameCookie = "zapperuser";
	
	public static Indexer getInstance() {
		return Indexer.instance;
	}
	
	public void getInvertedindex(String firstlink) {
		
		Utility utility = new Utility();
		Workqueue workqueue = new Workqueue(utility.nThreads);
		Parser parser = new Parser(workqueue);
		parser.invertedindexBuilder(firstlink);
		parser.checkWorkQueue();
		workqueue.threadStop();
		
	}
	
	public Boolean checkCookie(HttpServletRequest req, String cookiename) {
		
		boolean valid = false;
		Cookie[] cookies = req.getCookies();
		if (cookies == null) {
			return valid;
		}
		else {
			for (int i = 0 ; i < cookies.length ; i++) {
				Cookie cookie = cookies[i];
				if (cookie.getName().equals(cookiename)) {
					valid = true;
					this.username = cookie.getValue();
				}
			}
		}
		return valid;
	}
	
	public void getConfig(String[] args) {
		try {
			
			Util util = new Util();
			BufferedReader reader = new BufferedReader(new FileReader(config));
			String str = null;
			String[] strarray = null;
			while ((str = reader.readLine()) != null) {
				strarray = str.split(",");
				index.put(strarray[0], strarray[1]);
			}
			
		} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		} 
	}
}
