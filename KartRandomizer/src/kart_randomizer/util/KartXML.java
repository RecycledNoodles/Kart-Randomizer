package kart_randomizer.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.LinkedList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import kart_randomizer.model.Racer;
import kart_randomizer.model.Size;
import kart_randomizer.model.Vehicle;
import kart_randomizer.model.VehicleType;

public class KartXML {
	
	private String vehicleFile = "resource/vehicles.xml";
	private String racerFile = "resource/racers.xml";
	private String trackFile = "resource/tracks.xml";
	
	public KartXML() {
		// TODO Auto-generated constructor stub
	}
	
	public Vehicle[] getVehicles() {
		List<Vehicle> results = new LinkedList<Vehicle>();
		
		ClassLoader cl = this.getClass().getClassLoader();
		InputStream in = cl.getResourceAsStream(vehicleFile);
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder;
		Document document;
		try {
			builder = factory.newDocumentBuilder();
			document = builder.parse(in);
		} catch (ParserConfigurationException | SAXException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return results.toArray(new Vehicle[results.size()]);
		}
		
		NodeList vehicleList = document.getElementsByTagName("Vehicle");
		for (int i=0; i<vehicleList.getLength(); i++) {
			Element vehicleElement = (Element)vehicleList.item(i);
			
			Vehicle vehicle = new Vehicle();
			
			// declared variables
			String name;
			VehicleType type;
			Size weight;
			/*
			 * needs variables for stats
			 */
			
			
			
			// initialization
			name = (String)(vehicleElement.getAttribute("Name"));
			if (((String)(vehicleElement.getAttribute("Type"))).equals("Bike")) {
				type = VehicleType.BIKE;
			} else {
				type = VehicleType.KART;
			}
			
			if (((String)(vehicleElement.getAttribute("Weight"))).equals("Small")) {
				weight = Size.SMALL;
			} else if (((String)(vehicleElement.getAttribute("Weight"))).equals("Medium")) {
				weight = Size.MEDIUM;
			} else {
				weight = Size.LARGE;
			}
			
			// setting to vehicle
			vehicle.setName(name);
			vehicle.setType(type);
			vehicle.setWeight(weight);
			
			
			
			results.add(vehicle);
		}
		
		
		return results.toArray(new Vehicle[results.size()]);
	}
	
	public String[] getTracks() {
		return null;
	}
	
	public Racer[] getRacers() {
		return null;
		
	}

}
