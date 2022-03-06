package com.example.cars;

import java.sql.*;

public class DBUtility {
    //REQ
    private static String user = "Jiaqi200477892";
    private static String password = "UeRfRiM5fr";
      //connection string hostname / dbname
    private static String connectURL = "jdbc:mysql://172.31.22.43:3306/Jiaqi200477892";
    public static int insertIntoDB(Cars car) throws SQLException {
        int carId = -1;
        ResultSet resultSet = null;
        String sql = "INSERT INTO cars (carName,brand,price,isSport) VALUES (?,?,?,?);";
        try (
                Connection conn = DriverManager.getConnection(connectURL, user, password);
                PreparedStatement ps = conn.prepareStatement(sql, new String[]{"carId"})
                ) {
        //Configure
            ps.setString(1, car.getName());
            ps.setString(2, car.getBrand());
            ps.setDouble(3, car.getPrice());
            ps.setBoolean(4, car.isSport());
            //run the command into DB.
            ps.executeUpdate();
            //get the id
            resultSet = ps.getGeneratedKeys();
            while (resultSet.next()) {
                carId = resultSet.getInt(1);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        //close the resultset
        finally {
            if (resultSet != null)
                resultSet.close();
        }
        return carId;
    }
}
