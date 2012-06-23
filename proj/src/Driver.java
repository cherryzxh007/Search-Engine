import org.mortbay.jetty.Connector;
import org.mortbay.jetty.Server;
import org.mortbay.jetty.bio.SocketConnector;
import org.mortbay.jetty.handler.ContextHandlerCollection;
import org.mortbay.jetty.handler.HandlerList;
import org.mortbay.jetty.handler.ResourceHandler;
import org.mortbay.jetty.servlet.Context;
import org.mortbay.jetty.servlet.ServletHolder;


public class Driver {

//	public static String crawledURL;
	
	public static void main(String[] args) throws Exception {
		
		Indexer indexer = Indexer.getInstance();
		indexer.getConfig(args);
		indexer.link = indexer.index.get("firstlink");
		ResultPage.recordPageNum = Integer.parseInt(Indexer.getInstance().index.get("recordpagenum"));
		indexer.getInvertedindex(indexer.index.get("firstlink"));
		
		
		// create inverted index
		Server server = new Server();
		Connector connector = new SocketConnector();
		connector.setPort(Integer.parseInt(indexer.index.get("port")));
		server.setConnectors(new Connector[]{connector});
		
		// set handler
		ContextHandlerCollection contexthandler = new ContextHandlerCollection();
		HandlerList handlerlist = new HandlerList();
		ResourceHandler resourcehandler = new ResourceHandler();
		resourcehandler.setResourceBase(indexer.index.get("resources"));
		handlerlist.addHandler(resourcehandler);
		handlerlist.addHandler(contexthandler);
		server.setHandler(handlerlist);
		
		// set path
		Context context = new Context(contexthandler,"/",Context.SESSIONS);
		
		// set servlet
		context.addServlet(new ServletHolder(new MainPageServlet()), "/index/*");
		context.addServlet(new ServletHolder(new LoginServlet()), "/login/*");
		context.addServlet(new ServletHolder(new LogoutServlet()), "/logout/*");
		context.addServlet(new ServletHolder(new RegisterServlet()), "/register/*");
		context.addServlet(new ServletHolder(new CrawlerServlet()), "/account/crawler/*");
		context.addServlet(new ServletHolder(new AccountServlet()), "/account/*");
		context.addServlet(new ServletHolder(new ChangePWServlet()), "/account/changepw/*");
		context.addServlet(new ServletHolder(new CleanHistoryServlet()), "/account/cleanhistory/*");
		context.addServlet(new ServletHolder(new SearchServlet()), "/search/*");
		context.addServlet(new ServletHolder(new UserHistoryServlet()), "/userhistory/*");
		context.addServlet(new ServletHolder(new VisitedPageServlet()), "/show/*");
		context.addServlet(new ServletHolder(new ChangeNumServlet()), "/account/changenumpage/*");
		context.addServlet("org.mortbay.jetty.servlet.DefaultServlet","/");
		
		//start the server
        server.start();
        server.join();
		
	}

}
