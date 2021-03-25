package Product;

public class Display {
	private final Product product = new Product();
	private final Price price = new Price();
	private final Specification specification = new Specification();
	
	
	public String frontend() {
		return "* name: " + product.getName() +"\t* model: " + product.getModel() +
				 "\t* ";
	}
}
