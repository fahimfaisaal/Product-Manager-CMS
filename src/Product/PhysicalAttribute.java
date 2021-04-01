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
	private final DimensionUnit[] dimensionUnits = {DimensionUnit.MM, DimensionUnit.CM,DimensionUnit.M};
	private final WeightUnit[] weightUnits = {WeightUnit.G, WeightUnit.KG, WeightUnit.LT,  WeightUnit.POUND};
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

	public void setWidth() {
		System.out.print("Enter the Products width: ");

		this.width = Math.abs(scan.nextInt());
		scan.nextLine();
	}

	public void removeWidth() {
		this.width = 0;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight() {
		System.out.print("Enter the Products height: ");

		this.height = Math.abs(scan.nextInt());
		scan.nextLine();
	}

	public void removeHeight() {
		this.height = 0;
	}

	public int getLength() {
		return length;
	}

	public void setLength() {
		System.out.print("Enter the Products length: ");

		this.length = Math.abs(scan.nextInt());
		scan.nextLine();
	}

	public void removeLength() {
		this.length = 0;
	}

	public String getDimension() {
		return this.width + "(w) x " + this.height + "(h) x " + this.length + "(l)" + this.dimensionUnit.toString().toLowerCase(Locale.ROOT);
	}

	private DimensionUnit getDimensionUnit(int index) {
		if (index > dimensionUnits.length) {
			return this.viewDimensionUnit();
		}

		return dimensionUnits[index - 1];
	}

	private void setDimensionUnit(DimensionUnit unit) {
		this.dimensionUnit = unit;
	}

	public void setDimensionUnitByUser() {
		System.out.println(this.viewDimensionUnits());
		System.out.print("Select an Unit: ");

		int in = Math.abs(scan.nextInt());
		scan.nextLine();

		this.setDimensionUnit(this.getDimensionUnit(in));
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

	public void removeDimensionUnit() {
		this.setDimensionUnit(this.getDimensionUnit(0));
	}

	public String getWeight() {
		return weight + "" + this.weightUnit.toString().toLowerCase(Locale.ROOT);
	}

	public void setWeight() {
		System.out.print("Enter the Products weight: ");

		this.weight = Math.abs(scan.nextInt());
		scan.nextLine();
	}

	public void removeWeight() {
		this.weight = 0;
	}

	private WeightUnit getWeightUnit(int index) {
		return weightUnits[index - 1];
	}

	public void setWeightUnit(WeightUnit weightUnit) {
		this.weightUnit = weightUnit;
	}

	public void setWeightUnitByUser() {
		System.out.println(this.viewWeightUnits());
		System.out.println("Select an unit: ");

		int in = Math.abs(scan.nextInt());
		scan.nextLine();

		this.setWeightUnit(this.getWeightUnit(in));
	}

	private String viewWeightUnits() {
		StringBuilder weightUnits = new StringBuilder();
		int i = 1;

		for (WeightUnit unit: this.weightUnits) {
			weightUnits.append(i++).append(".").append(unit).append('\n');
		}

		return weightUnits.toString();
	}

	public void removeWeightUnit() {
		this.setWeightUnit(this.getWeightUnit(1));
	}

	public String viewSystemRequirement() {
		StringBuilder req = new StringBuilder();

		for (int i = 0; i < reqIndex; i++) {
			if (i < reqIndex - 1) req.append(" * ").append(systemRequirement[i]).append(", ");
			else req.append(" * ").append(systemRequirement[i]);
		}

		return req.toString();
	}

	public void setSystemRequirementsByUser() {
		if (systemRequirement.length == reqIndex) {
			System.out.print("""
			Requirements store is full
			Enter 1 for remove item.
			Enter any for exit.
			: """);

			int in = Math.abs(scan.nextInt());
			scan.nextLine();

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
			scan.nextLine();

			if (in == 1) this.setSystemRequirementsByUser();
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