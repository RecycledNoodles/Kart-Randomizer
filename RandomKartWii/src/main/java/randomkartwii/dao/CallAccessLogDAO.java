package randomkartwii.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import randomkartwii.data.CallAccessLogEntry;

public class CallAccessLogDAO extends BaseDAO {
	private static CallAccessLogDAO instance = null;
	private static Object mutex = new Object();
	
	public static CallAccessLogDAO getInstance() {
		if (instance == null) {
			synchronized (mutex) {
				if (instance == null) instance = new CallAccessLogDAO();
			}
			
		}
		return instance;
	}
	
	public void addEntry(String call) {
		Connection connection = createConnection();
		
		// check if entry exists
		int id = 0;
		try {
			String query = "SELECT id FROM callAccessLog "
					+ "WHERE dateAccessed=CURDATE() "
					+ "AND callAccessed=?";
			
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setString(1, call);
			ResultSet rs = statement.executeQuery();
			
			if (rs.next()) {
				id = rs.getInt("id");
			}
			
			statement.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if (id > 0) {
			// update that entry
			try {
				String sql = "UPDATE timesAccessed=timesAccessed+1 WHERE id=?";
				PreparedStatement statement = connection.prepareStatement(sql);
				statement.setInt(1, id);
				
				statement.executeUpdate();
				
				statement.close();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		} else {
			// insert new entry
			try {
				String sql = "INSERT INTO callAccessLog "
						+ "(dateAccessed,callAccessed) "
						+ "VALUES (CURDATE(),?)";
				PreparedStatement statement = connection.prepareStatement(sql);
				statement.setString(1, call);
				statement.execute();
				statement.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public CallAccessLogEntry[] getEntriesToday() {
		List<CallAccessLogEntry> results = new LinkedList<CallAccessLogEntry>();
		Connection connection = null;
		
		
		try {
			connection = createConnection();
			Statement statement = connection.createStatement();
			String query = "SELECT dateAccessed,callAccessed,timesAccessed FROM callAccessLog WHERE dateAccessed=CURDATE()";
			ResultSet rs = statement.executeQuery(query);
			
			while (rs.next()) {
				CallAccessLogEntry entry = new CallAccessLogEntry();
				entry.setCallAccessed(rs.getString("callAccessed"));
				entry.setTimesAccessed(rs.getInt("timesAccessed"));
				
				DateFormat df = new SimpleDateFormat("YYYY-MM-DD");
				
				try {
					entry.setDateAccessed(df.parse(rs.getString("dateAccessed")));
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					entry.setDateAccessed(new Date());
				}
				
				results.add(entry);
			}
			statement.close();
			connection.close();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return results.toArray(new CallAccessLogEntry[results.size()]);		
	}
	
	public CallAccessLogEntry[] getEntriesByDate(Date date) {
		List<CallAccessLogEntry> results = new LinkedList<CallAccessLogEntry>();
		
		Connection connection = null;
		
		connection = createConnection();
		String query = "SELECT callAccessed,timesAccessed FROM callAccessLog WHERE dateAccessed=?";
		try {
			PreparedStatement statement = connection.prepareStatement(query);
			
			
			DateFormat df = new SimpleDateFormat("YYYY-MM-DD");
			statement.setString(1, df.format(date));
			ResultSet rs = statement.executeQuery();
			
			while (rs.next()) {
				CallAccessLogEntry entry = new CallAccessLogEntry();
				entry.setCallAccessed(rs.getString("callAccessed"));
				entry.setTimesAccessed(rs.getInt("timesAccessed"));
				
				entry.setDateAccessed(date);
				
				results.add(entry);				
			}
			
			
			statement.close();
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return results.toArray(new CallAccessLogEntry[results.size()]);
		
	}
	public CallAccessLogEntry[] getEntries() {
		List<CallAccessLogEntry> results = new LinkedList<CallAccessLogEntry>();
		Connection connection = null;
		
		
		try {
			connection = createConnection();
			Statement statement = connection.createStatement();
			String query = "SELECT dateAccessed,callAccessed,timesAccessed FROM callAccessLog";
			ResultSet rs = statement.executeQuery(query);
			
			while (rs.next()) {
				CallAccessLogEntry entry = new CallAccessLogEntry();
				entry.setCallAccessed(rs.getString("callAccessed"));
				entry.setTimesAccessed(rs.getInt("timesAccessed"));
				
				DateFormat df = new SimpleDateFormat("YYYY-MM-DD");
				
				try {
					entry.setDateAccessed(df.parse(rs.getString("dateAccessed")));
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					entry.setDateAccessed(new Date());
				}
				
				results.add(entry);
			}
			statement.close();
			connection.close();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return results.toArray(new CallAccessLogEntry[results.size()]);
	}
}
