import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;
/**
 * @author 841372
 *@version 1.0
 *This is DB Handler class
 */
public class DBHandler {

	// Write the required business logic as expected in the question description
	public Connection establishConnection() {
		Connection conn = null;
		try {
			FileInputStream f = new FileInputStream("src/db.properties");
			Properties p = new Properties();
			p.load(f);

			Class.forName(p.getProperty("db.classname"));
			conn = DriverManager.getConnection(p.getProperty("db.url"), p.getProperty("db.username"),
					p.getProperty("db.password"));
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		return conn;
	}
}
