package Product;

import Product.enums.DimensionUnit;
import Product.enums.WeightUnit;

public class PhysicalAttribute {
	private int width;
	private int height;
	private int length;
	private DimensionUnit dimensionUnit;
	private int weight;
	private WeightUnit weightUnit;

	private final String[] systemRequirement = new String[10];
	private final DimensionUnit[] dimensionUnits = {DimensionUnit.cm, DimensionUnit.mm, DimensionUnit.m};
	private final WeightUnit[] weightUnits = {WeightUnit.Kg, WeightUnit.g};
	private int reqIndex = 0;

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

	public int getWeight() {
		return weight;
	}

	public DimensionUnit getDimensionUnit(int index) {
		return dimensionUnits[index - 1];
	}

	public WeightUnit getWeightUnit(int index) {
		return weightUnits[index - 1];
	}

	public int getReqIndex() {
		return this.reqIndex;
	}

	public String viewSystemRequirement() {
		StringBuilder req = new StringBuilder();

		for (int i = 0; i < reqIndex; i++) {
			req.append(" * ").append(systemRequirement[i]).append('\n');
		}

		return req.toString();
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public void setDimensionUnit(DimensionUnit unit) {
		this.dimensionUnit = unit;
	}

	public void setWeightUnit(WeightUnit weightUnit) {
		this.weightUnit = weightUnit;
	}

	public void pushSystemRequirement(String[] requirements) {
		for (String req : requirements) {
			systemRequirement[reqIndex++] = req;
		}
	}

	public void popSystemRequirementItem(int deleteCount) {
		for (int i = 0; i < deleteCount; i++) {
			systemRequirement[reqIndex--] = null;
		}
	}

	public DimensionUnit viewDimensionUnit() {
		return this.dimensionUnit;
	}

	public String viewDimensionUnits() {
		StringBuilder dimensionUnits = new StringBuilder();
		int i = 1;

		for (DimensionUnit unit: this.dimensionUnits) {
			dimensionUnits.append(i++).append(".").append(unit).append('\n');
		}

		return dimensionUnits.toString();
	}

	public WeightUnit viewWeightUnit() {
		return this.weightUnit;
	}

	public String viewWeightUnits() {
		StringBuilder weightUnits = new StringBuilder();
		int i = 1;

		for (WeightUnit unit: this.weightUnits) {
			weightUnits.append(i++).append(".").append(unit).append('\n');
		}

		return weightUnits.toString();
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
				 " systemRequirement ->\n" + viewSystemRequirement() +
				 '}';
	}
}