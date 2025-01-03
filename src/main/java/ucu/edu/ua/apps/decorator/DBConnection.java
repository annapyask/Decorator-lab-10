package ucu.edu.ua.apps.decorator;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import lombok.SneakyThrows;

public class DBConnection {
    private Connection connection;

    private static DBConnection dbConnection;

    @SneakyThrows
    private DBConnection() {
        this.connection = DriverManager
        .getConnection("jdbc:sqlite:/Desktop/oop_java/lab9/lab_10/cache.db");
    }

    @SneakyThrows
    public String getDociment(String gcsPath) {
        PreparedStatement statement = connection.prepareStatement("SELECT * FROM documents WHERE gcsPath = ?");
        statement.setString(1, gcsPath);
        ResultSet resultSet = statement.executeQuery();
        return resultSet.getString("parsed");
    }


    public static DBConnection getInstance() {
        if (dbConnection == null) {
            dbConnection = new DBConnection();
        }            
        return dbConnection;
    }

    @SneakyThrows
    public void createDocument(String gcsPath, String parse) {
        PreparedStatement statement = connection.prepareStatement("INSERT INTO documents(gcsPath, parsed) VALUES (?, ?)");
        statement.setString(1, gcsPath);
        statement.setString(2, parse);
        statement.executeUpdate();
        statement.close();
    }
}
