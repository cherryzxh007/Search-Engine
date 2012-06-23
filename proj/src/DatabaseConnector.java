import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public abstract class DatabaseConnector {
	
	public ErrorMsg error;
	
	private Indexer DBconfig = Indexer.getInstance();
	private final String username = DBconfig.index.get("user");
	private final String pw = DBconfig.index.get("pw");
	private final String dbURL = DBconfig.index.get("dbURL");
	private final String db = DBconfig.index.get("db");
	
	protected ArrayList<String> query = new ArrayList<String>();
	
	public DatabaseConnector() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * create connection
	 */
	private Connection connect() {
		String url = this.dbURL + this.db;
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(url, this.username, this.pw);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}
	
	/**
	 * close connection
	 */
	protected void closeConnection(Connection conn) {
		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * execute select statment with preparedstatement to avoid sql injection attack
	 */
	protected ResultSet executeSelect(String q) {
		
		int i = 1;
		ResultSet result = null;
		PreparedStatement prestat = null;
		Connection conn = this.connect();
		try {
			prestat = conn.prepareStatement(q);
			for (String str : this.query) {
				prestat.setString(i, str);
				i += 1;
			}
			result = prestat.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
	/**
	 * execute insert statement
	 * return true if success
	 */
	protected boolean Insert(String q) {

		int i = 1;
		boolean valid = false;
		PreparedStatement prestat = null;
		Connection conn = this.connect();
		try {
			prestat = conn.prepareStatement(q);
			for (String str : this.query) {
				prestat.setString(i, str);
				i += 1;
			}
			prestat.execute();
			conn.close();
			valid = true;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return valid;
		
	}
	
	/**
	 * execute insert, update, delete statement
	 * return true if success
	 */
	protected boolean execution(String q) {
	
		int i = 1;
		PreparedStatement prestat = null;
		Connection conn = this.connect();
		try {
			prestat = conn.prepareStatement(q);
			for (String str : this.query) {
				prestat.setString(i, str);
				i += 1;
			}
			prestat.execute();
			conn.close();
			return true;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}		
	}
	
}
