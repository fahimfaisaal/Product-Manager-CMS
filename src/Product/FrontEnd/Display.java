package Product.FrontEnd;

import Product.*;

import java.util.Locale;
import java.util.Scanner;

public class Display {
	private static final Product product = new Product();
	private static final Price price = new Price();
	private static final Specification specification = new Specification();
	private static final Features features = new Features();
	private static final Scanner scan = new Scanner(System.in);

	public void frontend() {
		String currencySymbol = price.getCurrencySymbol(),
				capacity = specification.getKeyFeatures().getCapacity(),
				readSpeed = specification.getKeyFeatures().getReadSpeed(),
				connectivity = specification.getKeyFeatures().getConnectivity(),
				dimension = specification.getPhysicalAttributes().getDimension(),
				weight = specification.getPhysicalAttributes().getWeight(),
				systemRequirements = specification.getPhysicalAttributes().viewSystemRequirement();

		System.out.printf("""
		---------------------------------------------------------------------------------------
		 		Name: %s | Model: %s | Brand: %s | Status: %s
		---------------------------------------------------------------------------------------
		  		Regular price: %.2f%s | Price: %.2f%s | Discount: %s | Save money: %.2f%s
		---------------------------------------------------------------------------------------
				Summary -> %s
		---------------------------------------------------------------------------------------
				Specifications ->
					* Key Features -
						| Capacity: %s
						| Read speed: %s
						| Connectivity: %s
						
					* Physical Attributes -
						| Dimension: %s
						| Weight: %s
						| Requirements: %s
						
					* Warranty - %s
		---------------------------------------------------------------------------------------
				Features -> %s
		---------------------------------------------------------------------------------------
				Description -> %s
		---------------------------------------------------------------------------------------
				FAQs -> %s 
		_______________________________________________________________________________________
				
		%n""",
		product.getName(), product.getModel(), product.getBrand(), product.getCurrentStatus(),
		price.getRegular(), currencySymbol, price.getCurrent(), currencySymbol,
		price.getDiscount(), price.getSaveAmount(), currencySymbol,
		product.getSummary(), capacity, readSpeed, connectivity, dimension, weight, systemRequirements,
		specification.getWarranty(), features.getFeatures(), product.getDescription(),
		 product.getFAQs()
		);
	}

	public void start() {
		String fullCommand = "";

		while (!fullCommand.equals("close .")) {
			System.out.println("\t___Type 'help .' for help___");
			System.out.print("Drop your command: ");

			fullCommand = scan.nextLine();
			String firstCommand = fullCommand.split("\s")[0].toLowerCase(Locale.ROOT);
			String secondCommand = fullCommand.split("\s")[1].toLowerCase(Locale.ROOT);

			switch (firstCommand) {
				case "add" -> add(secondCommand);
				case "remove" -> remove(secondCommand);
				case "help" -> help();
				case "show" -> frontend();
				case "close" -> System.out.println("Closing.....");
				default -> {
					System.out.printf("'%s' command is invalid!\n", firstCommand);
				}
			}
		}
	}

	private static void add(String secondCommand) {
		switch (secondCommand) {
			case "name" -> product.setName();
			case "model" -> product.setModel();
			case "brand" -> product.setBrand();
			case "status" -> product.setStatusByUser();
			case "summary" -> product.setSummary();
			case "faqs" -> product.setFaqsByUser();
			case "description" -> product.setDescription();
			case "price" -> price.setRegular();
			case "discount" -> price.setDiscount();
			case "currency" -> price.setCurrencyUnitByUser();
			case "capacity" -> specification.getKeyFeatures().setCapacity();
			case "capacity-unit" -> specification.getKeyFeatures().setCapacityUnitByUser();
			case "read-speed" -> specification.getKeyFeatures().setReadSpeed();
			case "connectivity" -> specification.getKeyFeatures().setConnectivity();
			case "width" -> specification.getPhysicalAttributes().setWidth();
			case "height" -> specification.getPhysicalAttributes().setHeight();
			case "length" -> specification.getPhysicalAttributes().setLength();
			case "dimension-unit" -> specification.getPhysicalAttributes().setDimensionUnitByUser();
			case "weight" -> specification.getPhysicalAttributes().setWeight();
			case "weight-unit" -> specification.getPhysicalAttributes().setWeightUnitByUser();
			case "requirement" -> specification.getPhysicalAttributes().setSystemRequirementsByUser();
			case "warranty" -> specification.setWarrantyByUser();
			case "feature" -> features.setFeatureByUser();
			default -> System.out.printf("'%s' command is Invalid!\n", secondCommand);
		}
	}

	private static void remove(String secondCommand) {
		switch (secondCommand) {
			case "name" -> product.removeName();
			case "model" -> product.removeModel();
			case "brand" -> product.removeBrand();
			case "status" -> product.removeStatus();
			case "summary" -> product.removeSummary();
			case "faqs" -> product.removeFAQs();
			case "description" -> product.removeDescription();
			case "price" -> price.removeRegularPrice();
			case "discount" -> price.removeDiscount();
			case "currency" -> price.removeCurrencyUnit();
			case "capacity" -> specification.getKeyFeatures().removeCapacity();
			case "capacity-unit" -> specification.getKeyFeatures().removeCapacityUnit();
			case "read-speed" -> specification.getKeyFeatures().removeReadSpeed();
			case "connectivity" -> specification.getKeyFeatures().removeConnectivity();
			case "width" -> specification.getPhysicalAttributes().removeWidth();
			case "height" -> specification.getPhysicalAttributes().removeHeight();
			case "length" -> specification.getPhysicalAttributes().removeLength();
			case "dimension-unit" -> specification.getPhysicalAttributes().removeDimensionUnit();
			case "weight" -> specification.getPhysicalAttributes().removeWeight();
			case "weight-unit" -> specification.getPhysicalAttributes().removeWeightUnit();
			case "requirement" -> specification.getPhysicalAttributes().removeSystemRequirements();
			case "warranty" -> specification.removeWarranty();
			case "feature" -> features.removeFeatures();
			default -> System.out.printf("'%s' command is Invalid!\n", secondCommand);
		}
	}

	private static void help() {
		System.out.println("""
		For add properties value, type -> 'add <property name>'
		For remove properties value, type -> 'remove <property name>'
		display frontend, type -> 'show .'
		type 'close .' for exit.
		""");
	}
}
