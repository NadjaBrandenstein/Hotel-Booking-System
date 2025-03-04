package dk.easv.hotelbookingsystem.DAL.DBConnection;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class DBConnection {
    private static final Object PROP_FILE = "Config.settings";
    private SQLServerDataSource ds;

    public DBConnection() throws IOException {
        Properties databaseProperties = new Properties();
        databaseProperties.load(new FileInputStream(String.valueOf(PROP_FILE)));

        String server = databaseProperties.getProperty("server");
        String database = databaseProperties.getProperty("database");
        String user = databaseProperties.getProperty("user");
        String password = databaseProperties.getProperty("password");

        ds = new SQLServerDataSource();
        ds.setServerName(server);
        ds.setDatabaseName(database);
        ds.setUser(user);
        ds.setPassword(password);
        ds.setTrustServerCertificate(true);

    }
    public Connection getConnection() throws SQLException {
        return ds.getConnection();
    }
}
