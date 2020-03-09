/**
 * 
 * @author 841372
 * @version 1.0 This Package class
 */
public class Package {
	private String packageId;
	private String sourcePlace;
	private String destinationPlace;
	private double basicFare;
	private int noOfDays;
	private double packageCost;

	public String getPackageId() {
		return packageId;
	}

	public void setPackageId(String packageId) {
		this.packageId = packageId;
	}

	public String getSourcePlace() {
		return sourcePlace;
	}

	public void setSourcePlace(String sourcePlace) {
		this.sourcePlace = sourcePlace;
	}

	public String getDestinationPlace() {
		return destinationPlace;
	}

	public void setDestinationPlace(String destinationPlace) {
		this.destinationPlace = destinationPlace;
	}

	public double getBasicFare() {
		return basicFare;
	}

	public void setBasicFare(double basicFare) {
		this.basicFare = basicFare;
	}

	public int getNoOfDays() {
		return noOfDays;
	}

	public void setNoOfDays(int noOfDays) {
		this.noOfDays = noOfDays;
	}

	public double getPackageCost() {
		return packageCost;
	}

	public void setPackageCost(double packageCost) {
		this.packageCost = packageCost;
	}

	// write the required business logic methods as expected in the question
	// description
	/**
	 * This method is use to calculate PackageCost
	 */
	public void calculatePackageCost() {
		double discount = 0;
		double gst = 12;
		double sum = 0.0;
		// fill your code here
		if (noOfDays <= 5) {
			sum = noOfDays * basicFare;
			gst = (sum * 12) / 100;
			sum = sum + gst;
		}
		if (noOfDays > 5 && noOfDays <= 8) {

			discount = 3;
			sum = noOfDays * basicFare;
			discount = (sum * discount) / 100;
			sum = sum - discount;
			gst = (sum * 12) / 100;
			sum = sum + gst;
		}

		else if (noOfDays > 8 && noOfDays <= 10) {
			discount = 5;
			sum = noOfDays * basicFare;
			discount = (sum * discount) / 100;
			sum = sum - discount;
			gst = (sum * 12) / 100;
			sum = sum + gst;
		}

		else if (noOfDays > 10) {
			discount = 7;
			sum = noOfDays * basicFare;
			discount = (sum * discount) / 100;
			sum = sum - discount;
			gst = (sum * 12) / 100;
			sum = sum + gst;
		}
		setPackageCost(sum);
	}

}
