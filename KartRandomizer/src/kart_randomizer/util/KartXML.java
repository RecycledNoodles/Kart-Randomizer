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
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import kart_randomizer.model.Racer;
import kart_randomizer.model.Size;
import kart_randomizer.model.Track;
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
			name = vehicleElement.getElementsByTagName("Name").item(0).getNodeValue();
			String typeString = vehicleElement.getElementsByTagName("Type").item(0).getNodeValue();
			String weightString = vehicleElement.getElementsByTagName("Weight").item(0).getNodeValue();
			
			if (typeString.equals("Bike")) {
				type = VehicleType.BIKE;
			} else {
				type = VehicleType.KART;
			}
			
			if (weightString.equals("Small")) {
				weight = Size.SMALL;
			} else if (weightString.equals("Medium")) {
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
	
	public Track[] getTracks() {
		List<Track> results = new LinkedList<Track>();
		ClassLoader cl = this.getClass().getClassLoader();
		InputStream in = cl.getResourceAsStream(trackFile);
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder;
		Document document;
		try {
			builder = factory.newDocumentBuilder();
			document = builder.parse(in);
		} catch (ParserConfigurationException | SAXException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return results.toArray(new Track[results.size()]);
		}
		
		NodeList cupList = document.getElementsByTagName("Cup");
		
		for (int i=0; i<cupList.getLength(); i++) {
			Element cup = (Element) cupList.item(i);
			String cupName = cup.getAttribute("name");
			NodeList trackList = cup.getElementsByTagName("Track");
			
			for (int j=0; j<trackList.getLength(); j++) {
				Element element = (Element) trackList.item(j);
				Track track = new Track();
				track.setCup(cupName);
				track.setName(element.getAttribute("name"));
				
				results.add(track);
			}
		}
		
		
		return results.toArray(new Track[results.size()]);
	}
	
	public Racer[] getRacers() {
		List<Racer> results = new LinkedList<Racer>();
		
		ClassLoader cl = this.getClass().getClassLoader();
		InputStream in = cl.getResourceAsStream(racerFile);
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder;
		Document document;
		try {
			builder = factory.newDocumentBuilder();
			document = builder.parse(in);
		} catch (ParserConfigurationException | SAXException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return results.toArray(new Racer[results.size()]);
		}
		
		NodeList racerList = document.getElementsByTagName("Racer");
		for (int i=0; i<racerList.getLength(); i++) {
			Element element = (Element) racerList.item(i);
			Racer racer = new Racer();
			
			String name = element.getElementsByTagName("Name").item(0).getNodeValue();
			String weightString = element.getElementsByTagName("Weight").item(0).getNodeValue();
			
			racer.setName(name);
			if (weightString.equals("Small")) {
				racer.setWeight(Size.SMALL);
			} else if (weightString.equals("Medium")) {
				racer.setWeight(Size.MEDIUM);
			} else {
				racer.setWeight(Size.LARGE);
			}
			
			results.add(racer);
		}
		
		return results.toArray(new Racer[results.size()]);
	}

}
