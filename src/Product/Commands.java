package Product;

import java.util.*;

public class Commands {

	public void add(String command) {
		switch (command.toLowerCase(Locale.ROOT)) {
			case "name" -> new Product().setName();
			case "model" -> new Product().setModel();
			case "brand" -> new Product().setBrand();
			case "status" -> new Product().setStatusByUser();
			case "summary" -> new Product().setSummary();
			case "faqs" -> new Product().setFaqsByUser();
			case "description" -> new Product().setDescription();
			case "price" -> new Price().setRegular();
			case "discount" -> new Price().setDiscount();
			case "currency" -> new Price().setCurrencyUnitByUser();
			case "capacity" -> new KeyFeatures().setCapacity();
			case "capacity-unit" -> new KeyFeatures().setCapacityUnitByUser();
			case "read-speed" -> new KeyFeatures().setReadSpeed();
			case "connectivity" -> new KeyFeatures().setConnectivity();
			case "width" -> new PhysicalAttribute().setWidth();
			case "height" -> new PhysicalAttribute().setHeight();
			case "length" -> new PhysicalAttribute().setLength();
			case "dimension-unit" -> new PhysicalAttribute().setDimensionUnitByUser();
			case "weight" -> new PhysicalAttribute().setWeight();
			case "weight-unit" -> new PhysicalAttribute().setWeightUnitByUser();
			case "requirement" -> new PhysicalAttribute().setSystemRequirementsByUser();
			case "warranty" -> new Specification().setWarrantyByUser();
			case "feature" -> new Features().setFeatureByUser();
			default -> System.out.printf("%s command is not found!\n", command);
		}
	}
}
