package com.example.cars;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class CarsTableViewController implements Initializable {

    @FXML
    private TableColumn<Cars, String> brandColumn;

    @FXML
    private TableColumn<Cars, String> carNameColumn;

    @FXML
    private TableColumn<Cars, Integer> carSalesNumberColumn;

    @FXML
    private Label highestSalesLabel;

    @FXML
    private TableColumn<Cars, Integer> idColumn;

    @FXML
    private TableColumn<Cars, Boolean> isSportColumn;

    @FXML
    private TableColumn<Cars, Double> priceColumn;

    @FXML
    private TableView<Cars> tableView;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
//        ArrayList<Cars> cars = DBUtility.getCarsFromDB();
//        System.out.println("");
        idColumn.setCellValueFactory(new PropertyValueFactory<>("carId"));
        carNameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        brandColumn.setCellValueFactory(new PropertyValueFactory<>("brand"));
        priceColumn.setCellValueFactory(new PropertyValueFactory<>("price"));
        isSportColumn.setCellValueFactory(new PropertyValueFactory<>("sport"));
        carSalesNumberColumn.setCellValueFactory(new PropertyValueFactory<>("carSalesNumber"));
        tableView.getItems().addAll(DBUtility.getCarsFromDB());
    }
}