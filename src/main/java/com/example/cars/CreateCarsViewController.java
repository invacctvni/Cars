package com.example.cars;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.text.Text;

import java.io.File;
import java.net.URL;
import java.util.Formatter;
import java.util.ResourceBundle;

public class CreateCarsViewController implements Initializable {

    @FXML
    private ComboBox<String> brandComboBox;

    @FXML
    private Label msgLabel;

    @FXML
    private TextField nameField;

    @FXML
    private Spinner<Integer> priceSpinner;

    @FXML
    private CheckBox sportCheckBox;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        brandComboBox.getItems().addAll(Cars.getBrands());
        SpinnerValueFactory<Integer> spinnerValueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(0,10000000,100,5);
        priceSpinner.setValueFactory(spinnerValueFactory);
        priceSpinner.setEditable(true);
        TextField spinnerTextField = priceSpinner.getEditor();

        //create anoymous inner class.
        spinnerTextField.textProperty().addListener((observableValue, oldValue, newValue) -> {
            try {
                Integer.parseInt(newValue);
            } catch (Exception e) {
//                msgLabel.setText("only whole numbers allowed for car sold");
                spinnerTextField.setText(oldValue);
            }
//                msgLabel.setText(String.format("Old value: %s new Value: %s", oldValue, newValue));
        });
    }

    @FXML
    private void createCar () {
        String name = nameField.getText();
        String brand = brandComboBox.getSelectionModel().getSelectedItem();
        try {
            double price = priceSpinner.getValue();
            boolean isSport = sportCheckBox.isSelected();
            Cars car = new Cars(name, brand, price, isSport);
            msgLabel.setText(car.toString());
            Formatter formatter = new Formatter(new File("newCar.txt"));
            formatter.format("New car: %s\n",car);
            formatter.close();
            DBUtility.insertIntoDB(car);
        }catch (Exception e) {
            msgLabel.setText(e.getMessage());
        }



    }
}
