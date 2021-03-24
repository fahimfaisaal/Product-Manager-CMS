package Product;

import Product.enums.Status;

public class Product {
	private String name;
	private String title;
	private String type;
	private String brand;
	private String summary;
	private String description;
	private Status status;

	private final String[] features = new String[20];
	private final String[] FAQ = new String[5];
	private final Status[] statuses = {Status.UPCOMING, Status.IN_STOCK, Status.OUT_OF_STOCK};

	public Product() {
		this.name = "null";
		this.title = "null";
		this.type = "null";
		this.brand = "null";
		this.summary = "null";
		this.description = "null";
		this.status = Status.UPCOMING;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public Status getCurrentStatus() {
		return status;
	}

	public Status getStatus(int index) {
		return statuses[index - 1];
	}

	public void setStatus(Status status) {
			this.status = status;
	}

	public String viewStatuses() {
		StringBuilder statusesString = new StringBuilder();
		int i = 1;

		for (Status status: this.statuses) {
			statusesString.append(i++).append(".").append(status).append('\n');
		}

		return statusesString.toString();
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
