package main.java.de.arkadi.creational.singelton;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

// lazy loading 
public class DbSingleton {

    /**
     * The Java volatile keyword is used to mark a Java variable as "being stored in main memory".
     * More precisely that means, that every read of a volatile variable will be read from the computer's main memory,
     * and not from the CPU cache, and that every write to a volatile variable will be written to main memory, #
     * and not just to the CPU cache.
     *
     * Working towards thread safety
     */
    private static volatile DbSingleton instance = null;

    private Connection conn = null;

    // TIP no derby lib here
    private DbSingleton() {
//		try {
//			DriverManager.registerDriver(new org.apache.derby.jdbc.EmbeddedDriver());
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
    }

    public static DbSingleton getInstance() {
        if (instance == null) {
            synchronized (DbSingleton.class) { //  die DbSingleton Klasse verwaltet diesen Bereich mit exclusive locks
                if (instance == null) {
                    instance = new DbSingleton();
                }
            }
        }

        return instance;
    }

    public Connection getConnection() {
        if (conn == null) {
            synchronized (DbSingleton.class) {
                if (conn == null) {
                    try {
                        String dbUrl = "jdbc:derby:memory:codejava/webdb;create=true";

                        conn = DriverManager.getConnection(dbUrl);
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

        return conn;
    }

}
