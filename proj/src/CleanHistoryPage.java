import org.antlr.stringtemplate.StringTemplate;


public class CleanHistoryPage extends WebPage {

	public StringTemplate body() {

		StringTemplate bodyST = template.getInstanceOf("cleanhistory");
		bodyST.setAttribute("zapperlogo", getURL("/logo_small.jpg"));
		this.TopMenu(bodyST);
		return bodyST;
	}
	
	public String Title() {
		return "Zapper";
	}
	
}
