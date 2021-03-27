package Product;

import Product.enums.Status;

import java.util.*;

public class Product {
	private String name = null;
	private String model = null;
	private final String id = UUID.randomUUID().toString();
	private String brand = null;
	private String summary = null;
	private String description = null;
	private Status status = Status.OUT_OF_STOCK;

	private final Scanner scan = new Scanner(System.in);
	private final FAQ[] faqs = new FAQ[10];
	private int faqIndex = 0;
	private final Status[] statuses = {Status.UPCOMING, Status.IN_STOCK, Status.OUT_OF_STOCK};

	public String getName() {
		return name;
	}

	public void setName() {
		System.out.print("Enter the product name: ");
		this.name = scan.nextLine();
	}

	public void removeName() {
		this.name = null;
	}

	public String getModel() {
		return this.model;
	}

	public void setModel() {
		System.out.printf("Enter the %s model: ", this.name);
		this.model = scan.nextLine();
	}

	public void removeModel() {
		this.model = null;
	}

	public String getId() {
		return id;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand() {
		System.out.printf("Enter the %s brand: ", this.name);
		this.brand = scan.nextLine();
	}

	public void removeBrand() {
		this.brand = null;
	}

	public Status getCurrentStatus() {
		return status;
	}

	private Status getStatus(int index) {
		if (index > statuses.length) {
			System.out.println("Index is out of length!");
			return this.status;
		}

		return statuses[index - 1];
	}

	private void setStatus(Status status) {
			this.status = status;
	}

	public void setStatusByUser() {
		System.out.println(this.viewStatuses());
		System.out.print("Select a status: ");

		int index = scan.nextInt();
		scan.nextLine();

		this.setStatus(this.getStatus(index));
	}

	private String viewStatuses() {
		StringBuilder statusesString = new StringBuilder();
		int i = 1;

		for (Status status: this.statuses) {
			statusesString.append(i++).append(".")
					 .append(status.toString().toLowerCase(Locale.ROOT)).append('\n');
		}

		return statusesString.toString();
	}

	public void removeStatus() {
		this.status = Status.OUT_OF_STOCK;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary() {
		System.out.printf("Enter a summary about %s: ", this.name);
		this.summary = scan.nextLine();
	}

	public void removeSummary() {
		this.summary = null;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription() {
		System.out.printf("Enter a description about %s: ", this.name);
		this.description = scan.nextLine();
	}

	public void removeDescription() {
		this.description = null;
	}

	public String getFAQs() {
		StringBuilder faqs = new StringBuilder();

		for (int i = 0; i < 10 && this.faqs[i] != null; i++) {
			faqs.append("Q: ").append(this.faqs[i].getQuestion()).append("\n\t\t\t\t")
					 .append("A: ").append(this.faqs[i].getAnswer()).append("\n\t\t\t\t");
		}

		return faqs.toString();
	}

	private void setFaq(String question, String answer) {
		FAQ faq = new FAQ();

		faq.setQuestion(question);
		faq.setAnswer(answer);

		faqs[faqIndex++] = faq;
	}

	private void setFaqs(int numberOfFaqs) {
		for (int i = 0; i < numberOfFaqs && faqIndex < 10; i++) {
			System.out.print("Enter Question(" + (faqIndex + 1) + "): ");

			String qus = scan.nextLine();

			System.out.print("Enter Answer(" + (faqIndex + 1) + "): ");
			String ans = scan.nextLine();

			this.setFaq(qus, ans);
		}
	}

	public void setFaqsByUser() {
		if (faqs.length == faqIndex) {
			System.out.print("""
   		FAQ's store is full :(
   		* Enter 1 for remove FAQ
   		* Enter any for exit
			:\s""");

			int in = Math.abs(scan.nextInt());
			scan.nextLine();

			if (in == 1) {
				this.removeFAQs();
			} else return;
		}

		System.out.printf("""
		Number of FAQ is %d
		You could add %d FAQ
		Enter the number of FAQ set:\s""",
		faqIndex, 10 - faqIndex);

		int numberOfFaqs = Math.abs(scan.nextInt());
		scan.nextLine();

		if (numberOfFaqs > 10 || numberOfFaqs > 10 - faqIndex) {
			numberOfFaqs = 0;

			System.out.print("""
			Number is out of range!
			* Enter 1 for retry.
			* Enter any for exit.
			:\s""");
			int in = Math.abs(scan.nextInt());
			scan.nextLine();

			if (in == 1) this.setFaqsByUser();
		}

		this.setFaqs(numberOfFaqs);
	}

	public void removeFAQs() {
		System.out.print("Enter the number of delete: ");

		int deleteCount = Math.abs(scan.nextInt());
		scan.nextLine();

		if (deleteCount > faqIndex) {
			System.out.println("Number is out of range!\nPlease try again.");
			this.removeFAQs();
		}

		for (int i = 0; i < deleteCount; i++) {
			faqs[--faqIndex] = null;
		}
	}

	@Override
	public String toString() {
		return "Product {" +
		"name=" + name + ",\n" +
		" model=" + model + ",\n" +
		" id=" + id + ",\n" +
		" brand=" + brand + ",\n" +
		" summary=" + summary + ",\n" +
		" description=" + description + ",\n" +
		" status=" + status + ",\n" +
		" scan=" + scan + ",\n" +
		" faqs->\n" + this.getFAQs() + "," +
		" faqIndex=" + faqIndex + ",\n" +
		" statuses->\n" + this.viewStatuses() + "," + +
		'}';
	}
}