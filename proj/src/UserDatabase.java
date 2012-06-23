import java.sql.ResultSet;
import java.sql.SQLException;


public class UserDatabase extends DatabaseConnector {
	
	private String statement = "";
	
	public void createdQuerySuggestion(String link, String q) {
		
		this.query.clear();
		this.statement = "insert into querysuggestion (link, query, counter) values (?, ?, 1)";
		this.query.add(link);
		this.query.add(q);
		this.Insert(this.statement);
		
	}
	
	public int getCounter(String q, String link) {
		
		int c = 1;
		this.query.clear();
		this.statement = "select counter from querysuggestion where link=? and query=?";
		this.query.add(link);
		this.query.add(q);
		ResultSet result = this.executeSelect(this.statement);
		try {

			if (result.next()) {
				c = Integer.parseInt(result.getString("counter"));
			}
			
			result.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
//		System.out.println(c);
		
		return c;
		
	}
	
	
	public void checkQueryWord(String q, String link) {
		
		int count;
		this.query.clear();
		this.statement = "select query from querysuggestion where query=? and link=?";
		this.query.add(q);
		this.query.add(link);
		ResultSet result = this.executeSelect(this.statement);
		try {
			if(result.next()) {
				// query existed
//				System.out.println("query existed");
				// get counter
				count = getCounter(q, link) + 1;
				this.query.clear();
				this.statement = "update querysuggestion set counter=? where link=? and query=?";
				this.query.add(String.valueOf(count));
				this.query.add(link);
				this.query.add(q);
				this.execution(this.statement);
				
			}
			else {
//				System.out.println("new query");
				// update database
				createdQuerySuggestion(link, q);
			}

			result.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	/**
	 * check current crawled page is stored in database or not
	 */
	public void checkLink(String link, String q) {
		
		this.query.clear();
		
		this.statement = "select link from querysuggestion where link=?";
		this.query.add(link);
		ResultSet result = this.executeSelect(this.statement);
		
		try {
			if (!result.next()) {
//				System.out.println("new link");
				// created!!!
				createdQuerySuggestion(link, q);
				
			}
			else {
//				System.out.println("link existed");
				checkQueryWord(q, link);
			}
			
			result.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	/**
	 * if it is new user, register into database
	 */
	public boolean register(String useremail, String pw, String firstname, String lastname) {
		
		this.query.clear();
		boolean valid = true;
		this.statement = "select username from users where username=?";
		this.query.add(useremail);
		ResultSet result = this.executeSelect(this.statement);
		
		try {
			if (!result.next()) {
				
				this.statement = "insert into users (username, pw, firstname, lastname, dateOfCreated, groupid)" + "values(?,?,?,?,now(),2)";
				this.query.add(pw);
				this.query.add(firstname);
				this.query.add(lastname);
				this.Insert(this.statement);
				
			}
			else {
				// print error
				this.error = ErrorMsg.USER_EXISTED;
				valid = false;
			}
			
			result.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			valid = false;
		}
		return valid;
	}
	
	/**
	 * to verify whether user name and pw is matched
	 */
	public boolean userVerification(String pw, String useremail) {
		
		boolean valid = true;
		this.query.clear();
		this.statement = "select username from users where username=? and pw=?";
		this.query.add(useremail);
		this.query.add(pw);
		ResultSet result = this.executeSelect(this.statement);
		
		try {
			if (!result.next()) {
				// print error;
				this.error = ErrorMsg.USER_INVALID;
				valid = false;
			}
			
			result.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			valid = false;
		}
		return valid;
	}
	
	/**
	 * change password
	 */
	public boolean changePW(String useremail, String newpw) {
		
		this.query.clear();
		this.statement = "update users set pw=? where username=?";
		this.query.add(newpw);
		this.query.add(useremail);
		return this.execution(this.statement);
		
	}
	
	/**
	 * check whether user is administrator or not
	 */
	public boolean administrator(String useremail) {

		int groupid = 1;
		boolean valid = false;
		ResultSet result;
		this.statement = "select * from users where username=? and groupid=?";
		this.query.clear();
		this.query.add(useremail);
		this.query.add(String.valueOf(groupid));
		result = this.executeSelect(this.statement);
		try {
			if (result.next()) {
				valid = true;
			}
			result.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return valid;
		
	}
}
