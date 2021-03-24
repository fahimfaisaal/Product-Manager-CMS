package Product;

import Product.enums.Warranty;

public class Specification {
	private final KeyFeatures keyFeatures = new KeyFeatures();
	private final PhysicalAttribute physicalAttribute = new PhysicalAttribute();
	private Warranty warranty;

	private final Warranty[] warranties = {Warranty.NO_WARRANTY, Warranty.YEAR_WARRANTY, Warranty.YEARS_WARRANTY, Warranty.LIFETIME_WARRANTY};

	public Specification() {
		this.warranty = Warranty.NO_WARRANTY;
	}

	public Warranty getWarranty() {
		return this.warranty;
	}

	public Warranty getWarranty(int index) {
		return this.warranties[index - 1];
	}

	public void setWarranty(Warranty warranty) {
		this.warranty = warranty;
	}

	public String viewWarranties() {
		StringBuilder warrantyString = new StringBuilder();
		int i = 1;

		for (Warranty warranty: this.warranties) {
			warrantyString.append(i++).append(".").append(warranty).append('\n');
		}

		return warrantyString.toString();
	}
}