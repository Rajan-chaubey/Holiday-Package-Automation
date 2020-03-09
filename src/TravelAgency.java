import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author 841372
 * @version 1.0 This is Travel Agency class
 */
public class TravelAgency {

	// write the required business logic methods as expected in the question
	// description
	/**
	 * 
	 * @param filePath
	 * @return List of package This method will parse the data and calculating
	 *         the cost for all the packages.
	 */
	public List<Package> generatePackageCost(String filePath) {
		List<Package> packageList = new ArrayList<Package>();
		File file = null;
		FileReader fileReader = null;
		BufferedReader bufferedReader = null;
		try {
			file = new File(filePath);
			fileReader = new FileReader(file);
			bufferedReader = new BufferedReader(fileReader);
			String s = null;
			String splits[];
			while ((s = bufferedReader.readLine()) != null) {
				splits = s.split(",");
				try {
					if (validate(splits[0])) {
						Package packages = new Package();
						packages.setPackageId(splits[0]);
						packages.setSourcePlace(splits[1]);
						packages.setDestinationPlace(splits[2]);
						packages.setBasicFare(Double.parseDouble(splits[3]));
						packages.setNoOfDays(Integer.parseInt(splits[4]));
						packages.calculatePackageCost();
						packageList.add(packages);

					}

				} catch (InvalidPackageIdException e) {
					e.getMessage();
				}

			}
			bufferedReader.close();
			fileReader.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
		return packageList;
	}

	/**
	 * 
	 * @param packageId
	 * @return boolean
	 * @throws InvalidPackageIdException
	 * 
	 */
	public boolean validate(String packageId) throws InvalidPackageIdException {

		// Fill you code Here

		if (packageId.matches("[0-9]{3}[/][A-Za-z]{3}")) {
			return true;
		} else {
			throw new InvalidPackageIdException();
		}

	}

	/**
	 * 
	 * @return list of package.
	 */
	public List<Package> findPackagesWithMinimumNumberOfDays() {

		// Fill you code Here

		List<Package> minimumNumberOfDays = new ArrayList<Package>();
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try (Connection conn = new DBHandler().establishConnection();) {

			preparedStatement = conn.prepareStatement(
					"select * from package_details where no_of_days = (select min(no_of_days) from package_details)");
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Package package1 = new Package();
				package1.setPackageId(resultSet.getString(1));
				package1.setSourcePlace(resultSet.getString(2));
				package1.setDestinationPlace(resultSet.getString(3));
				package1.setNoOfDays(resultSet.getInt(4));
				package1.setPackageCost(resultSet.getDouble(5));
				minimumNumberOfDays.add(package1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return minimumNumberOfDays;

	}

}
