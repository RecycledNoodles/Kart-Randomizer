package kart_randomizer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

import kart_randomizer.model.Racer;
import kart_randomizer.model.Vehicle;

public class KartRandomizer {

	Random randomizer = new Random();

	private static final String[] NAME = { "Baby Mario", "Baby Luigi",
			"Baby Peach", "Baby Daisy", "Toad", "Toadette", "Koopa Troopa",
			"Dry Bones", "Mario", "Luigi", "Peach", "Daisy", "Yoshi", "Birdo",
			"Diddy Kong", "Bowser Jr", "Wario", "Waluigi", "Donkey Kong",
			"Bowser", "King Boo", "Rosalina", "Funky Kong", "Dry Bowser" };
	private static final char[] SIZE = { 's', 's', 's', 's', 's', 's', 's',
			's', 'm', 'm', 'm', 'm', 'm', 'm', 'm', 'm', 'l', 'l', 'l', 'l',
			'l', 'l', 'l', 'l' };
	
	private static final String[] VEHICLE = { "Standard Kart", "Booster Seat",
			"Mini Beast", "Cheep Charger", "Tiny Titan", "Blue Falcon",
			"Standard Bike", "Bullet Bike", "Bit Bike", "Quacker",
			"Magikruiser", "Jet Bubble", "Standard Kart", "Classic Dragster",
			"Wild Wing", "Super Blooper", "Daytripper", "Sprinter",
			"Standard Bike", "Mach Bike", "Sugarscoot", "Zip Zip", "Sneakster",
			"Dolphin Dasher", "Standard Kart", "Flame Runner", "Offroader",
			"Flame Flyer", "Piranha Prowler", "Jetsetter", "Honeycoupe",
			"Standard Bike", "Wario Bike", "Shooting Star", "Spear", "Phantom" };

	private static final String[] INSULTS = { "stupid", "buttface",
			"ya biscuit-eating bullfrog", "jerk", "ya dolt", "ya scrub",
			"idiot", "ya cake-sniffer", "ya ankle-bitter",
			"if you keep doing this you'll make me OVERFLOW", "seriously",
			"come on, this is getting old", "really, i'm waiting",
			"I swear to jeebus if this is Jake i'm going to shut down", "if you actually can",  };

	private static final String[] TRACKS = { "Moo Moo Meadows",
			"Mushroom Gorge", "Toad's Factory", "Mario Circuit",
			"Coconut Mall", "DK Summit", "Wario's Gold Mine", "Daisy Circuit",
			"Koopa Cape", "Maple Treeway", "Grumble Volcano", "Dry Dry Ruins",
			"Moonview Highway", "Bowser's Castle", "Rainbow Road",
			"GCN Peach Beach", "DS Yoshi Falls", "SNES Ghost Valley 2",
			"N64 Mario Raceway", "N64 Sherbet Land", "GBA Shy Guy Beach",
			"DS Delfino Square", "GCN Waluigi Stadium", "DS Desert Hills",
			"GBA Bowser Castle 3", "N64 DK's Jungle Parkway",
			"GCN Mario Circuit", "SNES Mario Circuit 3", "DS Peach Gardens",
			"GCN DK Mountain", "N64 Bowser's Castle" };

	int flag = 0;
	public boolean good = false;
	int value;
	
	private List<Racer> racerSack;

	private List<String> trackSack;
	
	public String start() {
		return "How many players?";
	}
	
	
	public KartRandomizer() {
		racerSack = getRacerSack();
		trackSack = getTrackSack();
	}
	
	public String getPlayers(String players) {

		Scanner console = new Scanner(players);

		if (!console.hasNextInt()) {
			good = false;
			console.close();
			return "Enter a NUMBER between 1 and 4, "
					+ INSULTS[randomizer.nextInt(INSULTS.length)] + ".";
		}
		int value = console.nextInt();

		if (value < 1 || value > 4) {
			good = false;
			console.close();
			return "It needs to be BETWEEN 1 and 4, "
					+ INSULTS[randomizer.nextInt(INSULTS.length)] + ".";
		}
		
		console.close();

		return returnResults(value);

	}
	
	public List<Integer> getSack(int range) {
		
		List<Integer> sack = new ArrayList<>(range);
		for (int i = 0; i < range; i++) sack.add(i);
		Collections.shuffle(sack);
		
		return sack;	
	}

	public String returnResults(int players) {
		good = true;
		value = players;
		return returnList();

	}

	public String returnList() {

		String returnStr = "";
		List<Integer> sack = getSack(NAME.length);
		

		for (int i = 1; i <= value; i++) {
			
			int magicNumber = sack.get(i);

			String name = NAME[magicNumber];
			char size = SIZE[magicNumber];

			if (size == 's')
				magicNumber = randomizer.nextInt(12);
			else if (size == 'm')
				magicNumber = randomizer.nextInt(12) + 12;
			else
				magicNumber = randomizer.nextInt(12) + 24;

			String vehicle = VEHICLE[magicNumber];

			returnStr += "Player " + i + " will be racing the " + vehicle
					+ " with " + name + ".\n";
		}
		
		returnStr += "\n";
		
		sack = getSack(TRACKS.length);
		
		String tracks = "";
		int magicNumber = 0;

		for (int j = 1; j <= 3; j++) {
			
			magicNumber = sack.get(j);

			tracks += "Track " + j + " will be " + TRACKS[magicNumber] + ".\n";

		}

		tracks += "Track 4 will be Luigi Circuit.\n";
		
		return returnStr + tracks;
	}
	
	public List<Racer> getRacerSack() {
		List<Racer> racers = new LinkedList<Racer>(Arrays.asList(Resources.racers));
		Collections.shuffle(racers);
		
		return racers;
	}
	
	public List<String> getTrackSack() {
		List<String> tracks = new LinkedList<String>(Arrays.asList(Resources.tracks));
		Collections.shuffle(tracks);
		
		return tracks;
	}
	public Map<String,Object>[] pickPlayerSelections(int players) {
		Random random = new Random();
		@SuppressWarnings("unchecked")
		Map<String,Object>[] results = new Map[players];
		for (int i=0; i<players; i++) {
			Map<String,Object> selection = new HashMap<String,Object>();
			selection.put("racer",racerSack.get(0));
			racerSack.add(racerSack.get(0));
			racerSack.remove(0);
			
			// filter out vehicles
			List<Vehicle> filteredVehicles = new LinkedList<Vehicle>();
			for (Vehicle vehicle : Resources.vehicles) {
				if (vehicle.getWeight() == ((Racer)(selection.get("racer"))).getWeight())
					filteredVehicles.add(vehicle);
			}
			
			selection.put("vehicle", filteredVehicles.get(random.nextInt(filteredVehicles.size())));
			
			
			
			results[i] = selection;
		}
		return results;
	}
	
	
	public String[] pickTracks(boolean includeLuigisCircuit) {
		String[] tracks = new String[4];
		
		int randomTracks;
		
		if (includeLuigisCircuit) {
			randomTracks = 3;
		} else {
			randomTracks = 4;
		}
		
		for (int i=0; i<randomTracks; i++) {
			//if (includeLuigisCircuit && tracks[i].equals("Luigi Circuit"))
			//	continue;
			tracks[i] = trackSack.get(0);
			trackSack.add(trackSack.get(0));
			trackSack.remove(0);
		}
		
		if (includeLuigisCircuit)
			tracks[3] = "Luigi Circuit";
		
		return tracks;
	}
	
	

}
