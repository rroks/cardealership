package db;

import cardealership.DealMaker;

import javax.swing.*;
import java.io.File;
import java.sql.*;

/**
 * This is the class implements the operations to a SQLite database.
 *
 * @author Yufeng
 * @since 2016-12-23
 */
public class DatabaseOperations {
    /**
     * @param forname   This is a String indicates the library for accessing and creating
     *                  SQLite database files in Java.
     * @param dbname    This is a String indicates the relative path and the file name of
     *                  the database.
     */
    private static final String forname = "org.sqlite.JDBC";
    private static final String dbname = "jdbc:sqlite:car.db";

    /**
     * This is the functionality to write a new data into database in a specified format.
     *
     * @param deal This is a DealMaker parameter.
     * @throws SQLException             An exception that provides information on a database access error
     *                                  or other errors.
     * @throws ClassNotFoundException   Thrown when an application tries to load in a class through its string
     *                                  name.
     */
    public static void recordDB(DealMaker deal) throws ClassNotFoundException, SQLException {
        Connection c = null;
        Statement stmt = null;
        String sql = "";
        Class.forName(forname);
        c = DriverManager.getConnection(dbname);
        c.setAutoCommit(false);
        stmt = c.createStatement();
        sql = "INSERT INTO CARS VALUES ('" + deal.getName() +"', '" + deal.getModelName() + "', " +
                                        deal.getMpg() + ", '" + deal.getFuel() + "', '" + deal.getGearBox() +
                                        "', " + deal.getAssociations() + deal.price() + ");";
        stmt.executeUpdate(sql);
        stmt.close();
        c.commit();
        c.close();
    }
    /**
     * This is a functionality to find data in database. It will return all data with the same
     * "NAME" attribution.
     *
     */
    public static String readDB(String name) throws ClassNotFoundException, SQLException {
        String str = "";
        Connection c = null;
        Statement stmt = null;
        Class.forName(forname);
        c = DriverManager.getConnection(dbname);
        c.setAutoCommit(false);
        stmt = c.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM CARS;");
        while (rs.next()){
            if (name.equals(rs.getString("NAME"))) {
                str += "Customer Name: " + rs.getString("NAME") + "\n";
                str += "Model: " + rs.getString("MODEL") + "\n";
                str += "MPG: " + rs.getString("MPG") + "\n";
                str += "Fueltype: " + rs.getString("FUELTYPE") + "\n";
                str += "Gearbox: " + rs.getString("GEARBOX") + "\n";
                str += "Air Conditioning: " + rs.getString("AIRCONDITIONING") + "\n";
                str += "Parking Sensor: " + rs.getString("PARKINGSENSOR") + "\n";
                str += "Digital Radio: " + rs.getString("DIGITALRADIO") + "\n";
                str += "Alloy Wheels: " + rs.getString("ALLOYWHEELS") + "\n";
                str += "Price: " + rs.getInt("PRICE") + "\n";
            }
        }
        rs.close();
        stmt.close();
        c.close();
        return str;
    }

    /**
     * This is a functionality to find all data and return a DefaultListModel with all "NAME".
     * @return Returns a DefaultListModel instance.
     */
    public static DefaultListModel showAllCstmr() {
        DefaultListModel listModel = new DefaultListModel();
        Connection c = null;
        Statement stmt = null;
        try {
            Class.forName(forname);
            c = DriverManager.getConnection(dbname);
            c.setAutoCommit(false);
            stmt = c.createStatement();

            ResultSet rs = stmt.executeQuery("SELECT * FROM CARS;");
            while (rs.next()){
                listModel.addElement(rs.getString("NAME"));
            }
            rs.close();
            stmt.close();
            c.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return listModel;
    }

    /**
     * This is the functionality to create a database if it is not exist.
     */
    public static void creatDB() {
        if (!new File("car.db").exists()){
            Connection c = null;
            Statement stmt = null;
            try {
                Class.forName(forname);
                c = DriverManager.getConnection(dbname);
                c.setAutoCommit(false);
                stmt = c.createStatement();
                String sql = "CREATE TABLE CARS(NAME TEXT, MODEL TEXT, MPG INTEGER, FUELTYPE TEXT," +
                        " GEARBOX TEXT, AIRCONDITIONING TEXT, PARKINGSENSOR TEXT, DIGITALRADIO TEXT," +
                        " ALLOYWHEELS TEXT, PRICE INTEGER);";
                stmt.execute(sql);
            sql = "INSERT INTO CARS VALUES('qqq', 'www', 10, 'eee', 'aaa', 'sss', 'ddd', 'zzz', 'xxx', 10000);";
            stmt.executeUpdate(sql);
                stmt.close();
                c.commit();
                c.close();
            } catch (ClassNotFoundException | SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
