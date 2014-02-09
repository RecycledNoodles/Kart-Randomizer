package kart_randomizer;

import kart_randomizer.model.Racer;
import kart_randomizer.model.Vehicle;
import kart_randomizer.model.VehicleType;
import kart_randomizer.model.Size;

public class Resources {
	public static Racer[] racers = {
		new Racer("Baby Mario",Size.SMALL),
		new Racer("Baby Luigi",Size.SMALL),
		new Racer("Baby Peach",Size.SMALL),
		new Racer("Baby Daisy",Size.SMALL),
		new Racer("Toad",Size.SMALL),
		new Racer("Toadette",Size.SMALL),
		
		new Racer("Koopa Troopa",Size.MEDIUM),
		new Racer("Dry Bones",Size.MEDIUM),
		new Racer("Mario",Size.MEDIUM),
		new Racer("Luigi",Size.MEDIUM),
		new Racer("Peach",Size.MEDIUM),
		new Racer("Daisy",Size.MEDIUM),
		new Racer("Yoshi",Size.MEDIUM),
		new Racer("Birdo",Size.MEDIUM),
		new Racer("Diddy Kong",Size.MEDIUM),
		new Racer("Bowser Jr",Size.MEDIUM),
		
		new Racer("Wario",Size.LARGE),
		new Racer("Waluigi",Size.LARGE),
		new Racer("Donkey Kong",Size.LARGE),
		new Racer("Bowser",Size.LARGE),
		new Racer("King Boo",Size.LARGE),
		new Racer("Rosalina",Size.LARGE),
		new Racer("Funky Kong",Size.LARGE),
		new Racer("Dry Bowser",Size.LARGE)
	};
	
	public static Vehicle[] vehicles = {
		new Vehicle("Standard Kart S",VehicleType.KART,Size.SMALL),
		new Vehicle("Booster Seat",VehicleType.KART,Size.SMALL),
		new Vehicle("Mini Beast",VehicleType.KART,Size.SMALL),
		new Vehicle("Cheep Charger",VehicleType.KART,Size.SMALL),
		new Vehicle("Tiny Titan",VehicleType.KART,Size.SMALL),
		new Vehicle("Blue Falcon",VehicleType.KART,Size.SMALL),
		
		new Vehicle("Standard Bike S",VehicleType.BIKE,Size.SMALL),
		new Vehicle("Bullet Bike",VehicleType.BIKE,Size.SMALL),
		new Vehicle("Bit Bike",VehicleType.BIKE,Size.SMALL),
		new Vehicle("Quacker",VehicleType.BIKE,Size.SMALL),
		new Vehicle("Magikruiser",VehicleType.BIKE,Size.SMALL),
		new Vehicle("Jet Bubble",VehicleType.BIKE,Size.SMALL),
		
		new Vehicle("Standard Kart M",VehicleType.KART,Size.MEDIUM),
		new Vehicle("Classic Dragster",VehicleType.KART,Size.MEDIUM),
		new Vehicle("Wild Wing",VehicleType.KART,Size.MEDIUM),
		new Vehicle("Super Blooper",VehicleType.KART,Size.MEDIUM),
		new Vehicle("Daytripper",VehicleType.KART,Size.MEDIUM),
		new Vehicle("Sprinter",VehicleType.KART,Size.MEDIUM),
		
		new Vehicle("Standard Bike M",VehicleType.BIKE,Size.MEDIUM),
		new Vehicle("Mach Bike",VehicleType.BIKE,Size.MEDIUM),
		new Vehicle("Sugarscoot",VehicleType.BIKE,Size.MEDIUM),
		new Vehicle("Zip Zip",VehicleType.BIKE,Size.MEDIUM),
		new Vehicle("Sneakster",VehicleType.BIKE,Size.MEDIUM),
		new Vehicle("Dolphin Dasher",VehicleType.BIKE,Size.MEDIUM),
		
		new Vehicle("Standard Kart L",VehicleType.KART,Size.LARGE),
		new Vehicle("Offroader",VehicleType.KART,Size.LARGE),
		new Vehicle("Flame Flyer",VehicleType.KART,Size.LARGE),
		new Vehicle("Piranha Prowler",VehicleType.KART,Size.LARGE),
		new Vehicle("Jetsetter",VehicleType.KART,Size.LARGE),
		new Vehicle("Honeycoupe",VehicleType.KART,Size.LARGE),
		
		new Vehicle("Standard Bike L",VehicleType.BIKE,Size.LARGE),
		new Vehicle("Flame Runner",VehicleType.BIKE,Size.LARGE),
		new Vehicle("Wario Bike",VehicleType.BIKE,Size.LARGE),
		new Vehicle("Shooting Star",VehicleType.BIKE,Size.LARGE),
		new Vehicle("Spear",VehicleType.BIKE,Size.LARGE),
		new Vehicle("Phantom",VehicleType.BIKE,Size.LARGE),
	};

	public static String[] tracks = {
		 "Moo Moo Meadows",
			"Mushroom Gorge", "Toad's Factory", "Mario Circuit",
			"Coconut Mall", "DK Summit", "Wario's Gold Mine", "Daisy Circuit",
			"Koopa Cape", "Maple Treeway", "Grumble Volcano", "Dry Dry Ruins",
			"Moonview Highway", "Bowser's Castle", "Rainbow Road",
			"GCN Peach Beach", "DS Yoshi Falls", "SNES Ghost Valley 2",
			"N64 Mario Raceway", "N64 Sherbet Land", "GBA Shy Guy Beach",
			"DS Delfino Square", "GCN Waluigi Stadium", "DS Desert Hills",
			"GBA Bowser Castle 3", "N64 DK's Jungle Parkway",
			"GCN Mario Circuit", "SNES Mario Circuit 3", "DS Peach Gardens",
			"GCN DK Mountain", "N64 Bowser's Castle" 
	};
}
