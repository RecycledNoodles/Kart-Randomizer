package randomkartwii.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

import randomkartwii.data.Racer;
import randomkartwii.data.Size;

public class RacerDAO extends BaseDAO {
	
	private static RacerDAO instance = null;
	private static Object mutex = new Object();
	
	public static RacerDAO getInstance() {
		if (instance == null) {
			synchronized (mutex) {
				if (instance == null) instance = new RacerDAO();
			}
			
		}
		return instance;
	}
	
	public Racer[] getAllRacers() {
		List<Racer> racers = new LinkedList<Racer>();
		Connection connection = null;
		try {
			connection  = createConnection();
			Statement statement = connection.createStatement();
			String query = "SELECT name,size FROM racers";
			ResultSet rs = statement.executeQuery(query);
			
			while (rs.next()) {
				Racer racer = new Racer();
				racer.setName(rs.getString("name"));
				racer.setWeight(Size.valueOf(rs.getString("size")));
				
				racers.add(racer);
			}
			statement.close();
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

		}

		return racers.toArray(new Racer[racers.size()]);
	}
	
	
}
