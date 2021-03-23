package Main;
import Product.PhysicalAttribute;
import Product.enums.DimensionUnit;
import Product.enums.WeightUnit;

public class Main {

    public static void main(String[] args) {
        PhysicalAttribute obj = new PhysicalAttribute(60, 20, 9, DimensionUnit.cm, 10, WeightUnit.g);

        String[] req = {"Windows XP", "Vista, 7, 8, 8.1, 10", "Mac OS X 10.6 or later", "Linux kernel 2.6 or later", "with no device driver needed"};

        obj.setSystemRequirement(req);

        System.out.println(obj.toString());
    }
}
