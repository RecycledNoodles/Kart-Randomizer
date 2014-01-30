package kart_randomizer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

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

	public String start() {
		return "How many players?";
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

}
