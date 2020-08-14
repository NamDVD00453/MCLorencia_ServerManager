package main.mclorencia.model;

import main.mclorencia.config.ConfigUtil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionHelper {
    Connection conn;

    public ConnectionHelper() {
        Properties prop = new ConfigUtil().getProperties();

        try {
            this.conn = getMySQLConnection(prop.getProperty("DbHost"),
                    prop.getProperty("DbName"), prop.getProperty("DbUser"),
                    prop.getProperty("DbPassword"));
        } catch (SQLException | ClassNotFoundException throwable) {
            throwable.printStackTrace();
        }
        ;
    }

    static Connection getMySQLConnection(String hostName, String dbName, String userName, String password)
            throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        String connectionURL = "jdbc:mysql://" +
                hostName + ":3306/" +
                dbName +
                "?useUnicode=true" +
                "&useJDBCCompliantTimezoneShift=true" +
                "&useLegacyDatetimeCode=false" +
                "&serverTimezone=UTC";
        return DriverManager.getConnection(connectionURL, userName, password);
    }

    public Connection getConn() {
        return conn;
    }
}
