package com.example.cars;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

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

    /**
     * Cr a method to return a list of all objects.
     */
    public static ArrayList<Cars> getCarsFromDB() {
        ArrayList<Cars> cars = new ArrayList<>();
        //query the db and create objects and add to the list.
        String sql = " SELECT cars.carID,carName, brand, price,isSport,count(salesId) as carSalesNumber FROM cars\n" +
                " INNER JOIN carSales\n" +
                " ON cars.carId = carSales.carId\n" +
                " group by carID;";
        try (
                Connection conn = DriverManager.getConnection(connectURL, user, password);
                Statement statement = conn.createStatement();
                ResultSet resultSet = statement.executeQuery(sql);
                ) {
            while (resultSet.next()) {
                int carId = resultSet.getInt("carID");
                String name = resultSet.getString("carName");
                String brand = resultSet.getString("brand");
                Double price = resultSet.getDouble("price");
                boolean sport = resultSet.getBoolean("isSport");
                Integer carSalesNumber = resultSet.getInt("carSalesNumber");
                //create new objects
                Cars newCar = new Cars(carId,name,brand,price,sport,carSalesNumber);
                //add to arrayLists.
                cars.add(newCar);
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return cars;
    }


}
