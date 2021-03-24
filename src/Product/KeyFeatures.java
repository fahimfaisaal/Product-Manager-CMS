package Product;

import Product.enums.CapacityUnit;

public class KeyFeatures {
	private long capacity;
	private CapacityUnit capacityUnit;
	private String readSpeed;
	private String connectivity;

	private final CapacityUnit[] capacityUnits = {CapacityUnit.TB, CapacityUnit.GB, CapacityUnit.MB, CapacityUnit.KB};

	public KeyFeatures() {
		this.capacity = 0;
		this.capacityUnit = CapacityUnit.KB;
		this.readSpeed = null;
		this.connectivity = null;
	}

	public String getCapacity() {
		return this.capacity + "" + this.capacityUnit;
	}

	public CapacityUnit getCapacityUnit(int index) {
		return capacityUnits[index - 1];
	}

	public String getReadSpeed() {
		return readSpeed;
	}

	public String getConnectivity() {
		return connectivity;
	}

	public void setCapacity(long capacity) {
		this.capacity = capacity;
	}

	public void setCapacityUnit(CapacityUnit capacityUnit) {
		this.capacityUnit = capacityUnit;
	}

	public void setReadSpeed(String readSpeed) {
		this.readSpeed = readSpeed;
	}

	public void setConnectivity(String connectivity) {
		this.connectivity = connectivity;
	}

	public String viewCapacityUnits() {
		StringBuilder units = new StringBuilder();
		int i = 1;

		for (CapacityUnit unit: capacityUnits) {
			units.append(i++).append(".").append(unit).append('\n');
		}

		return units.toString();
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