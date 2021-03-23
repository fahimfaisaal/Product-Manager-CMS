package Product;

import Product.enums.CapacityUnit;

public class KeyFeatures {
	private final long capacity;
	private final CapacityUnit capacityUnit;
	private final String readSpeed;
	private final String connectivity;

	public KeyFeatures(long capacity, CapacityUnit capacityUnit, String readSpeed, String connectivity) {
		this.capacity = capacity;
		this.capacityUnit = capacityUnit;
		this.readSpeed = readSpeed;
		this.connectivity = connectivity;
	}

	public KeyFeatures(long capacity, CapacityUnit capacityUnit, String readSpeed) {
		this.capacity = capacity;
		this.capacityUnit = capacityUnit;
		this.readSpeed = readSpeed;
		this.connectivity = null;
	}

	public KeyFeatures(long capacity, CapacityUnit capacityUnit) {
		this.capacity = capacity;
		this.capacityUnit = capacityUnit;
		this.readSpeed = null;
		this.connectivity = null;
	}

	public KeyFeatures(long capacity) {
		this.capacity = capacity;
		this.capacityUnit = CapacityUnit.KB;
		this.readSpeed = null;
		this.connectivity = null;
	}

	public KeyFeatures() {
		this.capacity = 0;
		this.capacityUnit = CapacityUnit.KB;
		this.readSpeed = null;
		this.connectivity = null;
	}

	public String getCapacity() {
		return this.capacity + "" + this.capacityUnit;
	}

	public CapacityUnit getCapacityUnit() {
		return capacityUnit;
	}

	public String getReadSpeed() {
		return readSpeed;
	}

	public String getConnectivity() {
		return connectivity;
	}

	@Override
	public String toString() {
		return "KeyFeatures {" + "\n" +
				 " capacity=" + capacity + ",\n" +
				 " capacityUnit=" + capacityUnit + ",\n" +
				 " readSpeed='" + readSpeed + '\'' + ",\n" +
				 " connectivity='" + connectivity + '\'' + "\n" +
				 '}';
	}
}