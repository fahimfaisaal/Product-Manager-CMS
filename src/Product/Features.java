package Product;

import java.util.Scanner;

public class Features {
	private final Scanner scan = new Scanner(System.in);
	private final String[] features = new String[20];
	private int featuresIndex = 0;

	public String getFeatures() {
		StringBuilder features = new StringBuilder();

		for (int i = 0; i < featuresIndex; i++) {
			features.append("* ").append(this.features[i]).append('\n');
		}

		return features.toString();
	}

	private void setFeature(String feature) {
		features[featuresIndex++] = feature;
	}

	private void removeFeature() {
		features[--featuresIndex] = null;
	}

	public void setFeatures() {
		if (features.length == featuresIndex) {
			System.out.print("""
   		Features store is full :(
   		* Enter 1 for remove feature
   		* Enter any for exit
			:\s""");

			int in = Math.abs(scan.nextInt());

			if (in == 1) {
				this.removeFeatures();
			} else return;
		}

		int haveAddFeatures = features.length - featuresIndex;

		System.out.printf("""
		Number of feature is %d
		You could add %d
		Enter the number of features:\s""",
		featuresIndex, haveAddFeatures);

		int numberOfFeatures = Math.abs(scan.nextInt());
		scan.nextLine();

		if (numberOfFeatures > 20 || numberOfFeatures > haveAddFeatures) {
			numberOfFeatures = 0;
			System.out.println("""
			Number is out of range!
			* Enter 1 for retry
			* Enter any for exit:""");

			int in = Math.abs(scan.nextInt());
			if (in == 1) this.setFeatures();
		}

		for (int i = 0; i < numberOfFeatures; i++) {
			System.out.print("Set a feature(" + (featuresIndex + 1) + "): ");
			String feature = scan.nextLine();

			this.setFeature(feature);
		}
	}

	public void removeFeatures() {
		System.out.printf("""
		Number of feature is %d
		Enter the number of deletes:\s""",
		featuresIndex);
		int numberOfDelete = Math.abs(scan.nextInt());

		if (numberOfDelete > featuresIndex) {
			numberOfDelete = 0;

			System.out.println("""
			Number is out of range!
			* Enter 1 for retry
			* Enter any for exit
			:\s""");

			int in = Math.abs(scan.nextInt());
			if (in == 1) this.removeFeatures();
		}

		for (int i = 0; i < numberOfDelete; i++) {
			this.removeFeature();
		}
	}

	@Override
	public String toString() {
		return "Features {" +
		"features ->\n" + this.getFeatures() +
		" featuresIndex=" + featuresIndex + '\n' +
		'}';
	}
}
