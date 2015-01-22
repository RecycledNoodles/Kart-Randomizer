package randomkartwii.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import randomkartwii.data.Racer;
import randomkartwii.data.Size;

public class RacerDAO {
	
	private static RacerDAO instance = null;
	private static Object mutex = new Object();
	private Connection connection;
	
	private RacerDAO() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost/feedback?"
		              + "user=root&password=con!rong");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static RacerDAO getInstance() {
		if (instance == null) {
			synchronized (mutex) {
				if (instance == null) instance = new RacerDAO();
			}
			
		}
		return instance;
	}
	
	public Racer[] getRacers() {
		Racer[] racers = new Racer[2];
		racers[0]= new Racer();
		racers[0].setName("Mario");
		racers[0].setWeight(Size.MEDIUM);
		
		racers[1] = new Racer();
		racers[1].setName("Bowser");
		racers[1].setWeight(Size.LARGE);
		return racers;
	}
	
	
}
