
public enum ErrorMsg {
	
	LOGIN_FAILURE ("Login failure.Try again please."),
	USER_EXISTED ("Registed email, please register different email."),
	USER_INVALID ("User name and password do not matched."),
	SQL_FAILURE ("Cannot execute query statement."),
	USER_VERIFICATION_FAILURE ("User verification failure."),
	PASSWORD_INVALID ("User name and password do not matched."),
	REGISTRATION_FAILURE ("User registration failure."),
	DATABASE_CONNECTION_FAILURE ("Database connection failure.");
	
	private final String statement;
	
	ErrorMsg(String statement) {
		this.statement = statement;
	}
	
	public String getErrormsg() {
		return this.statement;
	}
	
}
