import org.antlr.stringtemplate.StringTemplate;


public class RegisterPage extends WebPage {

	public StringTemplate body() {
		// call index.st
		StringTemplate bodyST = template.getInstanceOf("register");
		return bodyST;
	}
	
	public String Title() {
		
		return "Zapper";
	}
	
}
