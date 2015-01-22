package randomkartwii.data;

public class Vehicle {
	private String name;
	private VehicleType type;
	private Size weight;
	public String getName() {
		return name;
	}
	
	public Vehicle() {
		this("",null,null);
	}
	
	public Vehicle(String name, VehicleType type, Size weight) {
		super();
		this.name = name;
		this.type = type;
		this.weight = weight;
	}
	
	
	public void setName(String name) {
		this.name = name;
	}
	public VehicleType getType() {
		return type;
	}
	public void setType(VehicleType type) {
		this.type = type;
	}
	public Size getWeight() {
		return weight;
	}
	public void setWeight(Size weight) {
		this.weight = weight;
	}
}
