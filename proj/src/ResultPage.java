import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.antlr.stringtemplate.StringTemplate;

public class ResultPage extends WebPage {

	public class searchIndex {
		
		public String link;
		public String title;
		public String quotelink;
		public String relative;
		
		public searchIndex(String link, String title, String quotelink, String relative) {
			this.link = link;
			this.title = title;
			this.quotelink = quotelink;
			this.relative = relative;
		}
	}
	
	public class pageIndex {
		
		public String page;
		
		public pageIndex(String link, String temp) {
			
			if (link.equals("")) {
				this.page = temp;
			}
			else {
				this.page = "<a href=\"" + link + "\">" + temp + "</a>";
			}
		}
		
	}
	
	
	private ArrayList<searchIndex> searchTool = new ArrayList<searchIndex>();
	private ArrayList<pageIndex> pageTool = new ArrayList<pageIndex>();
	private ArrayList<String> querySuggestionTool = new ArrayList<String>();
	
	private int recordStartPoint;
	private int recordEndPoint;
	private int recordNum;
	public static int recordPageNum;
	
	public void showQuerySuggestion(String q) {
		
		int cou = 0;
		Indexer indexer = Indexer.getInstance();
		UserDatabase userdb = new UserDatabase();
		DatabaseHistory dbhistory = new DatabaseHistory();

		userdb.checkLink(indexer.link, q);
		ResultSet result = dbhistory.getQuerySuggestion(indexer.link);
		
		try {
			
			while (result.next() && cou < 10) {
				querySuggestionTool.add(result.getString("query"));
				cou++;
			}
			
//			for (String str : this.querySuggestionTool) {
//				System.out.println(str);
//			}
//			System.out.println("--------------------------------------");
			
			result.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	private void showSearchResult() {
		
		String q = this.req.getParameter("q");
		Search getsearch = new Search();
		ArrayList<Search.DocLevel> searchresult = getsearch.search(q);
		
		this.recordNum = searchresult.size();
		Search.DocLevel[] resultarray = new Search.DocLevel[this.recordNum];
		searchresult.toArray(resultarray);
		searchresult = null;
		this.setPage(q);
		
		Invertedindex invertedindex = Invertedindex.getInvertedindex();
		LinkData linkdata = invertedindex.getLinkData();
		
		for (int i = this.recordStartPoint ; i <= this.recordEndPoint ; i++) {
			LinkInfo linkinfo = linkdata.getResult().get(resultarray[i].ID);
			if (linkinfo != null) {
				searchIndex searchindex = new searchIndex(this.getURL("/show?link="+linkinfo.linkstr), linkinfo.title, linkinfo.linkstr, linkinfo.relative);
				searchTool.add(searchindex);
				
			}
		}
		
		Indexer indexer = Indexer.getInstance();
		DatabaseHistory dbhistory = new DatabaseHistory();
		if (indexer.checkCookie(this.req, indexer.usernameCookie)) {
			String useremail = indexer.username;
			
			dbhistory.saveQuery(q, useremail);
		}
		
		showQuerySuggestion(q);
		
	}
	
	private void setPage(String query) {
		
		int currentpage = 1;
		
		if (this.req.getParameterMap().containsKey("p")) {
			currentpage = Integer.parseInt(this.req.getParameter("p"));
		}
		
		int n;
		
		if (this.recordNum % this.recordPageNum > 0) {
			n = 1;
		}
		else {
			n = 0;
		}
		
		int pageNum = this.recordNum / this.recordPageNum + n;
		
		String str = "";
		
		for (int i = 1 ; i <= pageNum ; i++) {
			str = String.valueOf(i);
			if (i == currentpage) {
				pageIndex pageindex = new pageIndex("", str);
				pageTool.add(pageindex);
			}
			else {
				pageIndex pageindex = new pageIndex(this.getURL("/search?q="+query+"&p="+str), str);
				pageTool.add(pageindex);
			}
		}
		
		this.recordStartPoint = 0;
		this.recordEndPoint = this.recordPageNum - 1;
		if (currentpage > 0) {
			this.recordStartPoint += this.recordPageNum * (currentpage - 1);
			this.recordEndPoint = (this.recordPageNum * currentpage) - 1;
			
			if (this.recordEndPoint > this.recordNum) {
				this.recordEndPoint = this.recordNum - 1;
			}
		}
		
	}
	
	private String getRecordSetting() {
		
		String record = "";
		if (this.recordNum == 0) {
			record = "no record";
			return record;
		}
		if (this.recordStartPoint != this.recordEndPoint) {
			record = String.valueOf(this.recordStartPoint + 1) + "-"  + String.valueOf(this.recordEndPoint + 1);
			return record;
		}
		else {
			record = String.valueOf(this.recordStartPoint + 1);
			return record;
		}
		
	}
	
	public StringTemplate body() {
		StringTemplate bodyST = template.getInstanceOf("results");
			this.TopMenu(bodyST);
			showSearchResult();
	        bodyST.setAttribute("searchTool",searchTool.toArray());
	        bodyST.setAttribute("queryword", this.req.getParameter("q"));
	        bodyST.setAttribute("querysearch", this.req.getParameter("q"));
	        
	        bodyST.setAttribute("pageTool", pageTool.toArray());
	        bodyST.setAttribute("RecordSetting", this.getRecordSetting());
	        bodyST.setAttribute("recordNum", String.valueOf(this.recordNum));
	        bodyST.setAttribute("querySuggestionTool", querySuggestionTool.toArray());
	        
	        return bodyST;
	}

	public String getTitle() { 
		return "Zapper"; 
	}
}
