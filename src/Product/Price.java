package Product;

import Product.enums.CurrencyUnit;
import java.util.Scanner;

public class Price {
	private double regular;
	private int discount;
	private CurrencyUnit currencyUnit;
	private final Scanner scan = new Scanner(System.in);

	private final CurrencyUnit[] currencyUnits = {CurrencyUnit.TK, CurrencyUnit.DOLLAR, CurrencyUnit.INR, CurrencyUnit.AUD, CurrencyUnit.EURO};

	public Price() {
		this.regular = 0.0;
		this.discount = 0;
		this.currencyUnit = CurrencyUnit.TK;
	}

	public double getSaveAmount() {
		return this.regular * (this.discount / 100.00);
	}

	public double getCurrent() {
		return this.regular - this.getSaveAmount();
	}

	public double getRegular() {
		return regular;
	}

	public void setRegular() {
		System.out.print("Enter Regular Price: ");
		this.regular = scan.nextDouble();
	}

	public void removeRegularPrice() {
		this.regular = 0.0;
	}

	public String getDiscount() {
		return this.discount + "%";
	}

	public void setDiscount() {
		System.out.print("Enter a discount in integer percentage: ");
		this.discount = scan.nextInt();
	}

	public void removeDiscount() {
		this.discount = 0;
	}

	public CurrencyUnit getCurrency() {
		return this.currencyUnit;
	}

	private CurrencyUnit getCurrencyUnit(int index) {
		if (index > currencyUnits.length) {
			System.out.println("index is out of length!");

			return this.getCurrency();
		}

		return this.currencyUnits[index - 1];
	}

	private void setCurrencyUnit(CurrencyUnit unit) {
		this.currencyUnit = unit;
	}

	public String getCurrencySymbol() {
		String curr = this.currencyUnit.toString();

		return switch (curr) {
			case "EURO" -> "€";
			case "DOLLAR" -> "$";
			case "INR" -> "₹";
			case "AUD" -> "A$";
			default -> "৳";
		};
	}

	private String viewCurrency() {
		StringBuilder units = new StringBuilder();
		int i = 1;

		for (CurrencyUnit unit: currencyUnits) {
			units.append(i++).append(".").append(unit).append('\n');
		}

		return units.toString();
	}

	public void setCurrencyUnitByUser() {
		System.out.println(this.viewCurrency());
		System.out.print("Select a currency unit: ");

		int index = scan.nextInt();
		this.setCurrencyUnit(this.getCurrencyUnit(index));
	}

	public void removeCurrencyUnit() {
		this.setCurrencyUnit(this.getCurrencyUnit(0));
	}

	@Override
	public String toString() {
		return "Price {" +
				 " regularPrice=" + this.getRegular() + this.getCurrencySymbol() + ",\n" +
				 " discount=" + this.getDiscount() + ",\n" +
				 " currentPrice=" + this.getCurrent() + this.getCurrencySymbol() + ",\n" +
				 " saveAmount=" + this.getSaveAmount() + this.getCurrencySymbol() + "\n" +
				 '}';
	}
}