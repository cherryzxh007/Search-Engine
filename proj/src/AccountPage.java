import org.antlr.stringtemplate.StringTemplate;


public class AccountPage extends WebPage {

	public StringTemplate body() {
		// call account.st
		StringTemplate bodyST = template.getInstanceOf("account");
		this.TopMenu(bodyST);
		this.sourceURL(bodyST);
		return bodyST;
	}
	
	public String Title() {
		return "Zapper";
	}
	
	public void sourceURL(StringTemplate st) {
		
		String username = Indexer.getInstance().username;
		UserDatabase userdb = new UserDatabase();
		if (userdb.administrator(username)) {
			st.setAttribute("admin", "<li><a href=\"/account/crawler\">crawl a new URL</a></li>");
		}
		else {
			st.setAttribute("admin", "");
		}
		
	}
}
