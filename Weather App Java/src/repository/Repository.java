package repository;

import domain.Weather;
import org.sqlite.SQLiteDataSource;
import java.sql.*;
import java.util.ArrayList;

public class Repository {
    private static final String JDBC_URL = "jdbc:sqlite:data/test_db.db";

    private static Connection conn = null;

    public static Connection getConnection() {
        if (conn == null)
            openConnection();
        return conn;
    }

    private static void openConnection()
    {
        try
        {
            SQLiteDataSource ds = new SQLiteDataSource();
            ds.setUrl(JDBC_URL);
            if (conn == null || conn.isClosed())
                conn = ds.getConnection();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void closeConnection()
    {
        try
        {
            conn.close();
            conn = null;
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }
    private ArrayList<Weather> MemElements = new ArrayList<>();

    public ArrayList<Weather> getAllWeathers() {
        ArrayList<Weather> Vremea = new ArrayList<>();
        try {
            openConnection();
            String selectString = "SELECT * FROM vremea;";
            try (PreparedStatement ps = conn.prepareStatement(selectString)) {
                ResultSet resultSet = ps.executeQuery();
                while (resultSet.next()) {
                    int starting_hours = resultSet.getInt("Starting_hour");
                    int ending_hours = resultSet.getInt("Ending_hour");
                    int temperature= resultSet.getInt("Temperature");
                    int precipitation_probability = resultSet.getInt("Precipitation");
                    String description = resultSet.getString("description");


                    Weather vremeaaa = new Weather(starting_hours,ending_hours,precipitation_probability,precipitation_probability,description);
                    Vremea.add(vremeaaa);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            closeConnection();

        }
        return Vremea;
    }

    public void updateObiect(int starting_hours,int ending_hours, int temperature,  int precipitation, String  description ) {
        try {
            openConnection();
            String updateString = "UPDATE vremea SET Starting_hours = ? WHERE Ending_hours = ? AND Temperature = ? AND Precipitation = ?";
            try (PreparedStatement preparedStatement = conn.prepareStatement(updateString)) {
                preparedStatement.setInt(1, starting_hours);
                preparedStatement.setInt(2, ending_hours);
                preparedStatement.setInt(3, temperature);
                preparedStatement.setInt(4, precipitation); // Format LocalTime to String
                preparedStatement.setString(5, description);
                int affectedRows = preparedStatement.executeUpdate();
                if (affectedRows == 0)
                    System.out.println("Object not found");
            } catch (SQLException e) {
                throw new RuntimeException(e);
            } finally {
                closeConnection();
            }
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }


}
