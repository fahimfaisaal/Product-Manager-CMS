package Product;

import Product.enums.CurrencyUnit;
import java.util.Locale;

public class Price {
	private double regular;
	private int discount;
	private CurrencyUnit currencyUnit;

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

	public String getDiscount() {
		return this.discount + "%";
	}

	public CurrencyUnit getCurrency() {
		return this.currencyUnit;
	}

	public CurrencyUnit getCurrencyUnit(int index) {
		return this.currencyUnits[index - 1];
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

	public void setRegular(double regular) {
		this.regular = regular;
	}

	public void setDiscount(int discount) {
		this.discount = discount;
	}

	public void setCurrencyUnit(CurrencyUnit unit) {
		this.currencyUnit = unit;
	}

	public String viewCurrency() {
		StringBuilder units = new StringBuilder();
		int i = 1;

		for (CurrencyUnit unit: currencyUnits) {
			units.append(i).append(".").append(unit).append('\n');
		}

		return units.toString();
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