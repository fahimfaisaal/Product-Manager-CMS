package Product;

import Product.enums.DimensionUnit;
import Product.enums.WeightUnit;

public class PhysicalAttribute {
	private final int width;
	private final int height;
	private final int length;
	private final DimensionUnit dimensionUnit;
	private final int weight;
	private final WeightUnit weightUnit;

	private final String[] systemRequirement = new String[10];
	private int reqIndex = 0;

	public PhysicalAttribute(int width, int height, int length, DimensionUnit dimensionUnit, int weight, WeightUnit weightUnit) {
		this.width = width;
		this.height = height;
		this.length = length;
		this.dimensionUnit = dimensionUnit;
		this.weight = weight;
		this.weightUnit = weightUnit;
	}

	public PhysicalAttribute(int width, int height, int length, DimensionUnit dimensionUnit, int weight) {
		this.width = width;
		this.height = height;
		this.length = length;
		this.dimensionUnit = dimensionUnit;
		this.weight = weight;
		this.weightUnit = WeightUnit.g;
	}

	public PhysicalAttribute(int width, int height, int length, DimensionUnit dimensionUnit) {
		this.width = width;
		this.height = height;
		this.length = length;
		this.dimensionUnit = dimensionUnit;
		this.weight = 0;
		this.weightUnit = WeightUnit.g;
	}

	public PhysicalAttribute(int width, int height, int length) {
		this.width = width;
		this.height = height;
		this.length = length;
		this.dimensionUnit = DimensionUnit.mm;
		this.weight = 0;
		this.weightUnit = WeightUnit.g;
	}

	public PhysicalAttribute(int width, int height) {
		this.width = width;
		this.height = height;
		this.length = 0;
		this.dimensionUnit = DimensionUnit.mm;
		this.weight = 0;
		this.weightUnit = WeightUnit.g;
	}

	public PhysicalAttribute(int width) {
		this.width = width;
		this.height = 0;
		this.length = 0;
		this.dimensionUnit = DimensionUnit.mm;
		this.weight = 0;
		this.weightUnit = WeightUnit.g;
	}

	public PhysicalAttribute() {
		this.width = 0;
		this.height = 0;
		this.length = 0;
		this.dimensionUnit = DimensionUnit.mm;
		this.weight = 0;
		this.weightUnit = WeightUnit.g;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	public int getLength() {
		return length;
	}

	public DimensionUnit getDimensionUnit() {
		return dimensionUnit;
	}

	public int getWeight() {
		return weight;
	}

	public WeightUnit getWeightUnit() {
		return weightUnit;
	}

	public String getSystemRequirement() {
		StringBuilder req = new StringBuilder();

		for (int i = 0; i < reqIndex; i++) {
			req.append(" * ").append(systemRequirement[i]).append("\n");
		}

		return req.toString();
	}

	public void setSystemRequirement(String[] requirement) {
		for (String s : requirement) {
			systemRequirement[reqIndex++] = s;
		}
	}

	@Override
	public String toString() {
		return "PhysicalAttribute {" + '\n' +
				 " width=" + width + ",\n" +
				 " height=" + height + ",\n" +
				 " length=" + length + ",\n" +
				 " dimensionUnit=" + dimensionUnit + ",\n" +
				 " weight=" + weight + ",\n" +
				 " weightUnit=" + weightUnit + ",\n" +
				 " systemRequirement ->\n" + getSystemRequirement() +
				 '}';
	}
}