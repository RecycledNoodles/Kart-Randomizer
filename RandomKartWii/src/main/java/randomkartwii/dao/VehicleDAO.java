package randomkartwii.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

import randomkartwii.data.Size;
import randomkartwii.data.Vehicle;
import randomkartwii.data.VehicleType;

public class VehicleDAO extends BaseDAO {

	private static VehicleDAO instance = null;
	private static Object mutex = new Object();

	public static VehicleDAO getInstance() {
		if (instance  == null) {
			synchronized (mutex) {
				if (instance == null) instance = new VehicleDAO();
			}
		}
		return instance;
	}

	public Vehicle[] getAllVehicles() {
		List<Vehicle> vehicles = new LinkedList<Vehicle>();
		Connection connection = null;
		try {
			connection  = createConnection();
			Statement statement = connection.createStatement();
			String query = "SELECT name,vehicleType,size FROM vehicles";
			ResultSet rs = statement.executeQuery(query);
			
			while (rs.next()) {
				
				Vehicle vehicle = new Vehicle();
				
				vehicle.setName(rs.getString("name"));
				vehicle.setType(VehicleType.valueOf(rs.getString("vehicleType")));
				vehicle.setWeight(Size.valueOf(rs.getString("size")));
				
				vehicles.add(vehicle );
			}
			statement.close();
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return vehicles.toArray(new Vehicle[vehicles.size()]);
	}
	
	public Vehicle[] getVehiclesBySize(Size size) {
		System.out.println("BY SIZE");
		List<Vehicle> vehicles = new LinkedList<Vehicle>();
		Connection connection = null;
		try {
			connection = createConnection();
			String query = "SELECT name,vehicleType,size FROM vehicles WHERE size=?";
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, size.name());
			
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				Vehicle vehicle = new Vehicle();
				vehicle.setName(rs.getString("name"));
				vehicle.setType(VehicleType.valueOf(rs.getString("vehicleType")));
				vehicle.setWeight(Size.valueOf(rs.getString("size")));
				vehicles.add(vehicle);
			}
			
			preparedStatement.close();
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return vehicles.toArray(new Vehicle[vehicles.size()]);
	}

}
