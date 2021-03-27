package Product;

import java.util.Scanner;

public class Display {
	private final Product product = new Product();
	private final Price price = new Price();
	private final Specification specification = new Specification();
	private final Scanner scan = new Scanner(System.in);

	public void frontend() {
		String currencySymbol = price.getCurrencySymbol(),
				capacity = specification.getKeyFeatures().getCapacity(),
				readSpeed = specification.getKeyFeatures().getReadSpeed(),
				connectivity = specification.getKeyFeatures().getConnectivity(),
				dimension = specification.getPhysicalAttributes().getDimension(),
				weight = specification.getPhysicalAttributes().getWeight(),
				systemRequirements = specification.getPhysicalAttributes().viewSystemRequirement();

		System.out.printf("""
		-------------------------------------------------------------------------------
		 		Name: %s | Model: %s | Brand: %s | Status: %s
		-------------------------------------------------------------------------------
		  		Regular price: %.2f%s | Price: %.2f%s | Discount: %s | Save money: %.2f%s
		-------------------------------------------------------------------------------
				Summary -> %s
		-------------------------------------------------------------------------------
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
		--------------------------------------------------------------------------------
				FAQs -> %s
		--------------------------------------------------------------------------------
				Description -> %s
				
		%n""",
		product.getName(), product.getModel(), product.getBrand(), product.getCurrentStatus(),
		price.getRegular(), currencySymbol, price.getCurrent(), currencySymbol,
		price.getDiscount(), price.getSaveAmount(), currencySymbol,
		product.getSummary(), capacity, readSpeed, connectivity, dimension, weight, systemRequirements,
		specification.getWarranty(), product.viewFAQs(), product.getDescription()
		);

		System.out.println("\t___Write '--help' for help___");
		System.out.print("Drop your command: ");

		String fullCommand = scan.nextLine();
		String firstCommand = fullCommand.split("\s")[0];
		String secondCommand = fullCommand.split("\s")[1];

		new Commands().add(secondCommand);
	}
}
