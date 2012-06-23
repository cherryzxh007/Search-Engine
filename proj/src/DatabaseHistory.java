import java.sql.ResultSet;


public class DatabaseHistory extends DatabaseConnector {
	
	String statement = "";
	
	/**
	 * get list of query suggestion
	 */
	public ResultSet getQuerySuggestion(String link) {
		
		this.query.clear();
		this.statement = "select query from querysuggestion where link=? order by counter desc";
		this.query.add(link);
		return this.executeSelect(this.statement);
		
	}

	/**
	 * get a list of visited page for user
	 */
	public ResultSet getVisitedPageRecord(String useremail) {
		
		this.query.clear();
		this.statement = "select visitedpage.link, visitedpage.visiteddate from" 
			+ " visitedpage inner join users on visitedpage.userid=users.userid"
			+ " where username=? order by visitedpage.visiteddate desc";
		this.query.add(useremail);
		return this.executeSelect(this.statement);
	
	}
	
	/**
	 * get a list for user of query word history
	 */
	public ResultSet getQueryHistoryRecord(String useremail) {
		
		this.query.clear();
		this.statement = "select querydatabase.query, querydatabase.querydate from" 
			+ " querydatabase inner join users on querydatabase.userid=users.userid"
			+ " where username=? order by querydatabase.querydate desc";
		this.query.add(useremail);
		return this.executeSelect(this.statement);
		
	}
	
	/**
	 * save visited page into database
	 */
	public void saveVisitedPage(String link, String useremail) {

		this.query.clear();
		this.statement = "insert into visitedpage (userid, link, visiteddate) select userid, ?, now() from users where username=?";
		this.query.add(link);
		this.query.add(useremail);
		this.Insert(this.statement);
		
	}
	
	/**
	 * save searched query into database
	 */
	public void saveQuery(String query, String useremail) {
		
		this.query.clear();
		this.statement = "insert into querydatabase (userid, query, querydate) select userid, ?, now() from users where username=?";
		this.query.add(query);
		this.query.add(useremail);
		this.Insert(this.statement);
		
	}
	
	/**
	 * remove visited page for user
	 */
	public void resetVisitedPage(String useremail) {
		
		this.query.clear();
		this.statement = "delete x from visitedpage x inner join users z on x.userid=z.userid where z.username=?";
		this.query.add(useremail);
		this.execution(this.statement);
	}
	
	/**
	 * remove query history for user
	 */
	public void resetQueryHistory(String useremail) {
		
		this.query.clear();
		this.statement = "delete y from querydatabase y inner join users z on y.userid=z.userid where z.username=?";
		this.query.add(useremail);
		this.execution(this.statement);
		
	}
	
}
