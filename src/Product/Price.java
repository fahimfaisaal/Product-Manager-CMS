package Product;

import java.util.Locale;

public class Price {
	private double regularPrice;
	private int discount;
	private final Currency currency;

	public Price(double regularPrice, int discount, Currency currency) {
		this.regularPrice = regularPrice;
		this.discount = discount;
		this.currency = currency;
	}

	public Price(double regularPrice, int discount) {
		this.regularPrice = regularPrice;
		this.discount = discount;
		this.currency = Currency.TK;
	}

	public Price(double regularPrice) {
		this.regularPrice = regularPrice;
		this.discount = 0;
		this.currency = Currency.TK;
	}

	private double saveAmount(double price, int disc) {
		return price * (disc / 100.00);
	}

	public String currentPrice() {
		return (this.regularPrice - this.saveAmount(this.regularPrice, this.discount)) + "" + this.getCurrencySymbol();
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
		return this.discount + "%";
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
				 ", saveAmount=" + this.saveAmount(this.regularPrice, this.discount) +
				 '}';
	}
}