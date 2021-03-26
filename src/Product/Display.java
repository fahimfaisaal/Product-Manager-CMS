package Product;

import java.util.Scanner;

public class Display {
	private final Product product = new Product();
	private final Price price = new Price();
	private final Specification specification = new Specification();
	private final Scanner scan = new Scanner(System.in);

	public void frontend() {
		System.out.printf("""
		-------------------------------------------------------------------------------
		 		Name: %s | Model: %s | Brand: %s | Status: %s
		-------------------------------------------------------------------------------
		  		Regular price: %.2f | Price: %.2f | Discount: %s | Save money: %.2f
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
		%n""",
		product.getName(), product.getModel(), product.getBrand(), product.getCurrentStatus(),
		price.getRegular(), price.getCurrent(), price.getDiscount(), price.getSaveAmount(),
		product.getSummary(), specification.getKeyFeatures().getCapacity(),
		specification.getKeyFeatures().getReadSpeed(),
		specification.getKeyFeatures().getConnectivity(),
		specification.getPhysicalAttributes().getDimension(),
		specification.getPhysicalAttributes().getWeight(),
		specification.getPhysicalAttributes().viewSystemRequirement()
		);

		System.out.println("\t___Write '--help' for help___");
		System.out.print("Drop your command: ");

		String fullCommand = scan.nextLine();
		String firstCommand = fullCommand.split("\s")[0];
		String secondCommand = fullCommand.split("\s")[1];

		new Commands().add(secondCommand);
	}
}
