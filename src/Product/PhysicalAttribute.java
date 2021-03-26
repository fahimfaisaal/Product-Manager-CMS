package Product;

import Product.enums.DimensionUnit;
import Product.enums.WeightUnit;

import java.util.Locale;
import java.util.Scanner;

public class PhysicalAttribute {
	private int width;
	private int height;
	private int length;
	private DimensionUnit dimensionUnit;
	private int weight;
	private WeightUnit weightUnit;

	private final Scanner scan = new Scanner(System.in);
	private final String[] systemRequirement = new String[10];
	private final DimensionUnit[] dimensionUnits = {DimensionUnit.CM, DimensionUnit.MM, DimensionUnit.M};
	private final WeightUnit[] weightUnits = {WeightUnit.KG, WeightUnit.LT, WeightUnit.G, WeightUnit.POUND};
	private int reqIndex = 0;

	public PhysicalAttribute() {
		this.width = 0;
		this.height = 0;
		this.length = 0;
		this.dimensionUnit = DimensionUnit.MM;
		this.weight = 0;
		this.weightUnit = WeightUnit.G;
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

	public String getWeight() {
		return weight + "" + this.weightUnit.toString().toLowerCase(Locale.ROOT);
	}

	public DimensionUnit getDimensionUnit(int index) {
		return dimensionUnits[index - 1];
	}

	public String getDimension() {
		return this.width + "(w) x " + this.height + "(h) x " + this.length + "(l)" + this.dimensionUnit.toString().toLowerCase(Locale.ROOT);
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
			if (i < reqIndex - 1) req.append(" * ").append(systemRequirement[i]).append(", ");
			else req.append(" * ").append(systemRequirement[i]);
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

	public void setSystemRequirements() {
		if (systemRequirement.length == reqIndex) {
			System.out.print("""
			Requirements store is full
			Enter 1 for remove item.
			Enter any for exit.
			: """);

			int in = Math.abs(scan.nextInt());

			if (in == 1) {
				this.removeSystemRequirements();
			} else return;
		}

		int haveAddFeatures = systemRequirement.length - reqIndex;
		System.out.printf(
		"""
		Number of requirements %d
		You could add %d items
		Enter the number of requirements:\s""",
		reqIndex, haveAddFeatures);
		int numberOfFeatures = Math.abs(scan.nextInt());
		scan.nextLine();

		if (
			numberOfFeatures > systemRequirement.length ||
			numberOfFeatures > haveAddFeatures
		) {
			numberOfFeatures = 0;
			System.out.print("""
			Number is out of range!
			* Enter 1 for retry
			* Enter any for exit
			: """);

			int in = Math.abs(scan.nextInt());
			if (in == 1) this.setSystemRequirements();
		}

		for (int i = 0; i < numberOfFeatures; i++) {
			System.out.print("Set a requirement(" + (reqIndex + 1) + "): ");
			String req = scan.nextLine();
			systemRequirement[reqIndex++] = req;
		}

	}

	public void removeSystemRequirements() {
		System.out.print("Enter the number of delete: ");
		int deleteCount = Math.abs(scan.nextInt());

		if (deleteCount > reqIndex) {
			deleteCount = 0;
			System.out.println("Number is out of range!\nPlease try again.");
			this.removeSystemRequirements();
		}

		for (int i = 0; i < deleteCount; i++) {
			systemRequirement[--reqIndex] = null;
		}
	}

	public DimensionUnit viewDimensionUnit() {
		return this.dimensionUnit;
	}

	public String viewDimensionUnits() {
		StringBuilder dimensionUnits = new StringBuilder();
		int i = 1;

		for (DimensionUnit unit: this.dimensionUnits) {
			dimensionUnits.append(i++).append(".")
			.append(unit).append('\n');
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