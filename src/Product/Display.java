package Product;

public class Display {
	public String templateString = String.format("""
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
		""",
	new Product().getName(), new Product().getModel(), new Product().getBrand(), new Product().getCurrentStatus(),
	new Price().getRegular(), new Price().getCurrencySymbol(), new Price().getCurrent(),
	new Price().getCurrencySymbol(), new Price().getDiscount(),
	new Price().getSaveAmount(), new Price().getCurrencySymbol(),
	new Product().getSummary(), new Specification().getKeyFeatures().getCapacity(),
	new Specification().getKeyFeatures().getReadSpeed(),
	new Specification().getKeyFeatures().getConnectivity(),
	new Specification().getPhysicalAttributes().getDimension(),
	new Specification().getPhysicalAttributes().getWeight(),
	new Specification().getPhysicalAttributes().viewSystemRequirement()
	);

	public String frontend() {
		return this.templateString;
	}
}
