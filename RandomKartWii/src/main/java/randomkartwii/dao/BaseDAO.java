package randomkartwii.dao;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BaseDAO {
	private final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	private final String DB_URL = "jdbc:mysql://localhost/randomkartwii";	
	private final String USER = "root";
	private final String PASS = "con!rong";
	
	protected BaseDAO() {
		
		try {
			Class.forName(JDBC_DRIVER);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	protected Connection createConnection() {
		try {
			return (Connection) DriverManager.getConnection(DB_URL, USER, PASS);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
}
