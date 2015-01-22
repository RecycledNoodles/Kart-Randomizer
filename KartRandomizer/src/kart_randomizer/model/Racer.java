package kart_randomizer.model;

public class Racer {
	private String name;
	private Size weight;
	
	
	
	public Racer(String name, Size weight) {
		super();
		this.name = name;
		this.weight = weight;
	}

	public Racer() {
		// TODO Auto-generated constructor stub
		this("",null);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Size getWeight() {
		return weight;
	}

	public void setWeight(Size weight) {
		this.weight = weight;
	}
}
