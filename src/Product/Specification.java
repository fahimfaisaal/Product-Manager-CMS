package Product;

import Product.enums.Warranty;

import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;

public class Specification {
	private final KeyFeatures keyFeatures = new KeyFeatures();
	private final PhysicalAttribute physicalAttributes = new PhysicalAttribute();
	private Warranty warranty;

	private final Warranty[] warranties = {Warranty.NO_WARRANTY, Warranty.ONE_YEAR_WARRANTY, Warranty.YEARS_WARRANTY, Warranty.LIFETIME_WARRANTY};
	private final Scanner scan = new Scanner(System.in);

	public KeyFeatures getKeyFeatures() {
		return this.keyFeatures;
	}

	public PhysicalAttribute getPhysicalAttributes() {
		return this.physicalAttributes;
	}

	public Specification() {
		this.warranty = Warranty.NO_WARRANTY;
	}

	public Warranty getWarranty() {
		return this.warranty;
	}

	private Warranty getWarranty(int index) {
		if (index > this.warranties.length) {
			System.out.println("Index is out of length!");
			this.warranty = this.getWarranty();
		}

		return this.warranties[index - 1];
	}

	private void setWarranty(Warranty warranty) {
		this.warranty = warranty;
	}

	private String viewWarranties() {
		StringBuilder warrantyString = new StringBuilder();
		int i = 1;

		for (Warranty warranty: this.warranties) {
			warrantyString.append(i++).append(".")
			.append(warranty.toString().toLowerCase(Locale.ROOT)).append('\n');
		}

		return warrantyString.toString();
	}

	public void setWarrantyByUser() {
		System.out.println(this.viewWarranties());
		System.out.print("Select a warranty: ");

		int index = Math.abs(scan.nextInt());

		this.setWarranty(this.getWarranty(index));
	}

	public void removeWarranty() {
		this.setWarranty(this.getWarranty(0));
	}

	@Override
	public String toString() {
		return "Specification {" +
		"keyFeatures=" + keyFeatures.toString() +
		" physicalAttributes=" + physicalAttributes.toString() + ",\n" +
		", warranty=" + warranty + ",\n" +
		", warranties=" + Arrays.toString(warranties) + "\n" +
		'}';
	}
}