package cardealership;

import java.sql.SQLException;

/**
 * The cardealership program implements an applet with GUI and database to sell cars. It's easy to
 * extend choices by adding new car class and association class and changing some settings.
 *
 * @author Yufeng
 * @since 2016-12-23
 */
public class Seller {

    /**
     * The runner of this program.
     *
     * @param args                      Unused.
     * @throws SQLException             An exception that provides information on a database access error
     *                                  or other errors.
     * @throws ClassNotFoundException   Thrown when an application tries to load in a class through its string
     *                                  name.
     */
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        String windowName = "Car Dealership";
        Viewer.getInstance(windowName);
    }
}
