package Main;
import Product.PhysicalAttribute;
import Product.Price;

public class Main {

    public static void main(String[] args) {
        PhysicalAttribute obj = new PhysicalAttribute();
        Price price = new Price();

        price.setRegular(1444.345);
        price.setDiscount(25);
        System.out.println(price.getSaveAmount());

        System.out.println(price.toString());
    }
}
