package repository.base;

import java.sql.*;
import java.sql.SQLException;

import static java.sql.DriverManager.getConnection;

public class DbConnection {
    public static String Url = "jdbc:mysql://localhost:3306/foodtracker";
    public static String Username = "root";
    public static String Password = "";

    private Connection mConnection;

    public static DbConnection OpenNewConnection() {
        DbConnection NewConnection = new DbConnection();
        if (!NewConnection.Open()) {
            return null;
        }

        return NewConnection;
    }

    public ResultSet ExecuteSimpleQuery(String query) throws SQLException {
        Statement statement = mConnection.createStatement();
        return statement.executeQuery(query);
    }

    public PreparedStatement NewPreparedStatement(String query) throws SQLException {
        return mConnection.prepareStatement(query);
    }

    public PreparedStatement NewPreparedStatementForCreate(String query) throws SQLException {
        return mConnection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
    }

    private boolean Open() {
        try {
            mConnection = getConnection(Url, Username, Password);
        } catch (SQLException ex) {
            return false;
        }

        return true;
    }
}
