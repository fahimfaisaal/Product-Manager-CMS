package Product;

import Product.enums.Status;
import java.util.*;

public class Product {
	private String name;
	private String model;
	private final String id;
	private String brand;
	private String summary;
	private String description;
	private Status status;

	private final Scanner scan = new Scanner(System.in);
	private final FAQ[] faqs = new FAQ[10];
	private int faqIndex = 0;
	private final Status[] statuses = {Status.UPCOMING, Status.IN_STOCK, Status.OUT_OF_STOCK};

	public Product() {
		this.name = "null";
		this.model = "null";
		this.id = UUID.randomUUID().toString();
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

	public String getModel() {
		return this.model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getId() {
		return id;
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

	private String viewStatuses() {
		StringBuilder statusesString = new StringBuilder();
		int i = 1;

		for (Status status: this.statuses) {
			statusesString.append(i++).append(".")
					 .append(status).append('\n');
		}

		return statusesString.toString();
	}

	public void setStatusByUser() {
		System.out.println(this.viewStatuses());
		System.out.print("Select a status: ");

		int index = scan.nextInt();

		this.setStatus(this.getStatus(index));
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

	public void getFaqs() {
		System.out.println(Arrays.toString(this.faqs));
	}

	public String viewFAQs() {
		StringBuilder faqs = new StringBuilder();

		for (int i = 0; i < 10 && this.faqs[i] != null; i++) {
			faqs.append("Q: ").append(this.faqs[i].getQuestion()).append('\n')
					 .append("A: ").append(this.faqs[i].getAnswer()).append('\n');
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

	public void setFaqsFromUser() {
		if (faqIndex < 10) {
			System.out.printf("Number of FAQ is %d\nYou could add %d FAQ\n", faqIndex, 10 - faqIndex);
			System.out.print("Enter the number of FAQ set: ");

			int numberOfFaqs = scan.nextInt();
			scan.nextLine();

			this.setFaqs(numberOfFaqs);
		} else {
			System.out.print("The FAQ store is full :(\n* Enter 1 for remove.\n* Enter any for exit.\n: ");
			int in = scan.nextInt();

			if (in == 1) {
				this.removeFAQ();
				this.setFaqsFromUser();
			}
		}
	}

	public void removeFAQ() {
		faqs[--faqIndex] = null;
	}
}