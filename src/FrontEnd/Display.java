package FrontEnd;

import Product.Product;

import java.util.Locale;
import java.util.Scanner;

public class Display {
	private static final Product product = new Product();;
	private static final Scanner scan = new Scanner(System.in);

	public void frontend() {
		String currencySymbol = product.getPrice().getCurrencySymbol(),
				capacity = product.getSpecification().getKeyFeatures().getCapacity(),
				readSpeed = product.getSpecification().getKeyFeatures().getReadSpeed(),
				connectivity = product.getSpecification().getKeyFeatures().getConnectivity(),
				dimension = product.getSpecification().getPhysicalAttributes().getDimension(),
				weight = product.getSpecification().getPhysicalAttributes().getWeight(),
				systemRequirements = product.getSpecification().getPhysicalAttributes().viewSystemRequirement();

		System.out.printf("""
		-----------------------------------------------------------------------------------------
		 		Name: %s | Model: %s | Brand: %s | Status: %s
		-----------------------------------------------------------------------------------------
		  		Regular price: %.2f%s | Price: %.2f%s | Discount: %s | Save money: %.2f%s
		-----------------------------------------------------------------------------------------
				Summary -> %s
		-----------------------------------------------------------------------------------------
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
		-----------------------------------------------------------------------------------------
				Features -> %s
		-----------------------------------------------------------------------------------------
				Description -> %s
		-----------------------------------------------------------------------------------------
				FAQs -> %s 
		_________________________________________________________________________________________
				
		%n""",
		product.getName(), product.getModel(), product.getBrand(),
		product.getCurrentStatus(), product.getPrice().getRegular(), currencySymbol, product.getPrice().getCurrent(),
		currencySymbol, product.getPrice().getDiscount(), product.getPrice().getSaveAmount(), currencySymbol, product.getSummary(),
		capacity, readSpeed, connectivity, dimension, weight, systemRequirements,
		product.getSpecification().getWarranty(), product.getFeatures().getFeatures(), product.getDescription(),
		product.getFAQs()
		);
	}

	public void start() {
		String fullCommand = "";

		while (!fullCommand.equals("close .")) {
			System.out.println("\t___Type 'help .' for help___");
			System.out.print("Drop your command: ");

			fullCommand = scan.nextLine().toLowerCase(Locale.ROOT);

			if (fullCommand.equals("")) {
				fullCommand = "empty .";
			}

			fullCommand += " empty";

			String[] fullCommands = fullCommand.split("\s");

			String firstCommand = fullCommands[0];
			String secondCommand = fullCommands[1];

			switch (firstCommand) {
				case "add" -> add(firstCommand, secondCommand);
				case "remove" -> remove(firstCommand, secondCommand);
				case "help" -> help();
				case "show" -> frontend();
				case "close" -> {
					System.out.println("Closing.....");
					fullCommand = "close .";
				}
				default -> System.out.printf("'%s' command is invalid!\n", firstCommand);
			}
		}
	}

	private static void add(String firstCommand, String secondCommand) {
		switch (secondCommand) {
			case "name" -> product.setName();
			case "model" -> product.setModel();
			case "brand" -> product.setBrand();
			case "status" -> product.setStatusByUser();
			case "summary" -> product.setSummary();
			case "faqs" -> product.setFaqsByUser();
			case "description" -> product.setDescription();
			case "price" -> product.getPrice().setRegular();
			case "discount" -> product.getPrice().setDiscount();
			case "currency" -> product.getPrice().setCurrencyUnitByUser();
			case "capacity" -> product.getSpecification().getKeyFeatures().setCapacity();
			case "capacity-unit" -> product.getSpecification().getKeyFeatures().setCapacityUnitByUser();
			case "read-speed" -> product.getSpecification().getKeyFeatures().setReadSpeed();
			case "connectivity" -> product.getSpecification().getKeyFeatures().setConnectivity();
			case "width" -> product.getSpecification().getPhysicalAttributes().setWidth();
			case "height" -> product.getSpecification().getPhysicalAttributes().setHeight();
			case "length" -> product.getSpecification().getPhysicalAttributes().setLength();
			case "dimension-unit" -> product.getSpecification().getPhysicalAttributes().setDimensionUnitByUser();
			case "weight" -> product.getSpecification().getPhysicalAttributes().setWeight();
			case "weight-unit" -> product.getSpecification().getPhysicalAttributes().setWeightUnitByUser();
			case "requirement" -> product.getSpecification().getPhysicalAttributes().setSystemRequirementsByUser();
			case "warranty" -> product.getSpecification().setWarrantyByUser();
			case "feature" -> product.getFeatures().setFeatureByUser();
			default -> System.out.printf("'%s' command is Invalid!\n", firstCommand + " " + secondCommand);
		}
	}

	private static void remove(String firstCommand, String secondCommand) {
		switch (secondCommand) {
			case "name" -> product.removeName();
			case "model" -> product.removeModel();
			case "brand" -> product.removeBrand();
			case "status" -> product.removeStatus();
			case "summary" -> product.removeSummary();
			case "faqs" -> product.removeFAQs();
			case "description" -> product.removeDescription();
			case "price" -> product.getPrice().removeRegularPrice();
			case "discount" -> product.getPrice().removeDiscount();
			case "currency" -> product.getPrice().removeCurrencyUnit();
			case "capacity" -> product.getSpecification().getKeyFeatures().removeCapacity();
			case "capacity-unit" -> product.getSpecification().getKeyFeatures().removeCapacityUnit();
			case "read-speed" -> product.getSpecification().getKeyFeatures().removeReadSpeed();
			case "connectivity" -> product.getSpecification().getKeyFeatures().removeConnectivity();
			case "width" -> product.getSpecification().getPhysicalAttributes().removeWidth();
			case "height" -> product.getSpecification().getPhysicalAttributes().removeHeight();
			case "length" -> product.getSpecification().getPhysicalAttributes().removeLength();
			case "dimension-unit" -> product.getSpecification().getPhysicalAttributes().removeDimensionUnit();
			case "weight" -> product.getSpecification().getPhysicalAttributes().removeWeight();
			case "weight-unit" -> product.getSpecification().getPhysicalAttributes().removeWeightUnit();
			case "requirement" -> product.getSpecification().getPhysicalAttributes().removeSystemRequirements();
			case "warranty" -> product.getSpecification().removeWarranty();
			case "feature" -> product.getFeatures().removeFeatures();
			default -> System.out.printf("'%s' command is Invalid!\n", firstCommand + " " + secondCommand);
		}
	}

	private static void help() {
		System.out.println("""
		For add properties value, type -> 'add <property name>'
		For remove properties value, type -> 'remove <property name>'
		For display frontend, type -> 'show .'
		Type 'close .' for exit the program.
		""");
	}
}
