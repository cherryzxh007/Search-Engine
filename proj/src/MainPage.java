import org.antlr.stringtemplate.StringTemplate;


public class MainPage extends WebPage{
	
	public StringTemplate body() {
		// call index.st
		StringTemplate bodyST = template.getInstanceOf("index");
		this.TopMenu(bodyST);
		return bodyST;
	}
	
	public String Title() {
		return "Zapper";
	}
	
}
