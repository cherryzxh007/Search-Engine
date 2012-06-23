
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.antlr.stringtemplate.StringTemplate;



public class UserHistoryPage extends WebPage {
	
	public class queryIndex {
		public String query;
		public String date;
		
	    public queryIndex(String query, String date) {
			this.query = query;
			this.date = date;
		}
	}
	
	public class visitedIndex {
		public String visitedpage;
		public String date;
		
		public visitedIndex(String visitedpage, String date) {
			this.visitedpage = visitedpage;
			this.date =date;
		}
	}
	
	private String username;
	
	private ArrayList<queryIndex> queryRecord = new ArrayList<queryIndex>();
	
	private ArrayList<visitedIndex> visitedRecord = new ArrayList<visitedIndex>();
	
	public void showQueryRecord() {
		
		DatabaseHistory dbhistory = new DatabaseHistory();
		ResultSet result = dbhistory.getQueryHistoryRecord(this.username);	
		try {
			while (result.next()) {
				queryIndex queryindex = new queryIndex(result.getString("query"), result.getString("querydate"));
				queryRecord.add(queryindex);
			}
			result.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void showVisitedRecord() {
		
		DatabaseHistory dbhistory = new DatabaseHistory();
		ResultSet result = dbhistory.getVisitedPageRecord(this.username);
		try {
			while (result.next()) {
				visitedIndex visitedindex = new visitedIndex(result.getString("link"), result.getString("visiteddate"));
				visitedRecord.add(visitedindex);
			}
			result.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public StringTemplate body() {
		// call account.st
		StringTemplate bodyST = template.getInstanceOf("userhistory");
		this.username = Indexer.getInstance().username;
		this.showQueryRecord();
		this.showVisitedRecord();
		bodyST.setAttribute("queryRecord", queryRecord);
		bodyST.setAttribute("visitedRecord", visitedRecord);
		this.TopMenu(bodyST);
		return bodyST;
	}
	
	public String Title() {
		return "Zapper";
	}
	
}
