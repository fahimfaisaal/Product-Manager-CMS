package Product;

import java.util.Locale;

public class Price {
	private double regularPrice;
	private int discount;
	private final Currency currency;
	private final double saveAmount;

	public Price(double regularPrice, int discount, Currency currency) {
		this.regularPrice = regularPrice;
		this.discount = discount;
		this.saveAmount = this.regularPrice * (this.discount / 100.00);
		this.currency = currency;
	}

	public Price(double regularPrice, int discount) {
		this.regularPrice = regularPrice;
		this.discount = discount;
		this.saveAmount = this.regularPrice * (this.discount / 100.00);
		this.currency = Currency.TK;
	}

	public Price(double regularPrice) {
		this.regularPrice = regularPrice;
		this.discount = 0;
		this.saveAmount = this.regularPrice * (this.discount / 100.00);
		this.currency = Currency.TK;
	}

	public String currentPrice() {
		return (this.regularPrice - saveAmount) + "" + this.getCurrencySymbol();
	}

	public String getSaveAmount() {
		return this.saveAmount + "" + this.getCurrencySymbol();
	}

	public String getRegularPrice() {
		return regularPrice + "" + this.getCurrencySymbol();
	}

	public String getCurrency() {
		return this.currency.toString().toLowerCase(Locale.ROOT);
	}

	public String getCurrencySymbol() {
		String curr = this.currency.toString();

		return switch (curr) {
			case "EURO" -> "€";
			case "DOLLAR" -> "$";
			case "INR" -> "₹";
			case "AUD" -> "A$";
			default -> "৳";
		};

	}

	public void setRegularPrice(double regularPrice) {
		this.regularPrice = regularPrice;
	}

	public String getDiscount() {
		return discount + "%";
	}

	public void setDiscount(int discount) {
		this.discount = discount;
	}

	@Override
	public String toString() {
		return "Price {" +
				 "regularPrice=" + this.getRegularPrice() +
				 ", discount=" + this.getDiscount() +
				 ", currentPrice=" + this.currentPrice() +
				 ", saveAmount=" + this.getSaveAmount() +
				 '}';
	}
}