import org.antlr.stringtemplate.StringTemplate;


public class LoginPage extends WebPage {

	public StringTemplate body() {
		// call login.st
		StringTemplate bodyST = template.getInstanceOf("login");
		return bodyST;
	}
	
	public String Title() {
		return "Zapper"; 	
	}
	
}
