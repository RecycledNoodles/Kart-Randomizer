package randomkartwii.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

import randomkartwii.data.Track;

public class TrackDAO extends BaseDAO {

	private static TrackDAO instance = null;
	private static Object mutex = new Object();

	public static TrackDAO getInstance() {
		if (instance == null) {
			synchronized (mutex ) {
				if (instance == null) instance = new TrackDAO();
			}
			
		}
		return instance;
	}

	public Track[] getAllTracks() {
		List<Track> tracks = new LinkedList<Track>();
		Connection connection = null;
		try {
			connection  = createConnection();
			Statement statement = connection.createStatement();
			String query = "SELECT name,cup FROM tracks";
			ResultSet rs = statement.executeQuery(query);
			
			while (rs.next()) {
				Track track = new Track();
				track.setName(rs.getString("name"));
				track.setCup(rs.getString("cup"));
				
				tracks.add(track);
			}
			statement.close();
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return tracks.toArray(new Track[tracks.size()]);
	}
	
	public Track[] getTracksExcludingIDS(int[] ids) {
		
		// creating array string
		String arrayString = "";
		for (int i=0; i<ids.length; i++) {
			arrayString += ids[i];
			if (i <ids.length-1)
				arrayString += ",";
		}
		
		List<Track> tracks = new LinkedList<Track>();
		Connection connection = null;
		try {
			connection  = createConnection();
			Statement statement = connection.createStatement();
			String query = "SELECT name,cup FROM tracks WHERE id NOT IN ("+arrayString+")";
			ResultSet rs = statement.executeQuery(query);
			
			while (rs.next()) {
				Track track = new Track();
				track.setName(rs.getString("name"));
				track.setCup(rs.getString("cup"));
				
				tracks.add(track);
			}
			statement.close();
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return tracks.toArray(new Track[tracks.size()]);
	}
	
	public Track getTrackByID(int id) {
		
		Connection connection = null;
		Track track = null;
		
		try {
			connection = createConnection();
			
			String query = "SELECT name,cup FROM tracks WHERE id = ?";
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setInt(1, id);
			ResultSet rs = statement.executeQuery();
			
			if (rs.next()) {
				track = new Track();
				track.setName(rs.getString("name"));
				track.setCup(rs.getString("cup"));
			}
			statement.close();
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return track;
	}
	
	public Track[] getTracksByIDS(int[] ids) {
		// creating array string
		String arrayString = "";
		for (int i=0; i<ids.length; i++) {
			arrayString += ids[i];
			if (i <ids.length-1)
				arrayString += ",";
		}		
		List<Track> tracks = new LinkedList<Track>();
		Connection connection = null;
		try {
			connection  = createConnection();
			Statement statement = connection.createStatement();
			String query = "SELECT name,cup FROM tracks WHERE id IN ("+arrayString+")";
			ResultSet rs = statement.executeQuery(query);
			
			while (rs.next()) {
				Track track = new Track();
				track.setName(rs.getString("name"));
				track.setCup(rs.getString("cup"));
				
				tracks.add(track);
			}
			statement.close();
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return tracks.toArray(new Track[tracks.size()]);		
	}

}
