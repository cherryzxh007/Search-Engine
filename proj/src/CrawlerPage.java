import org.antlr.stringtemplate.StringTemplate;


public class CrawlerPage extends WebPage {

	public StringTemplate body() {

		StringTemplate bodyST = template.getInstanceOf("crawler");
		bodyST.setAttribute("zapperlogo", getURL("/logo_small.jpg"));
		this.TopMenu(bodyST);
		return bodyST;
	}
	
	public String Title() {
		return "Zapper";
	}
	
}
