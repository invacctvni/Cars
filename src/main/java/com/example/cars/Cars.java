package com.example.cars;

import java.util.*;
import java.util.stream.Collectors;

public class Cars {
    private String name, brand;
    private double price;
    private boolean sport;
    //add car id
    private int carId;
    //add sales
    private int carSalesNumber;

    public Cars(String name, String brand, double price, boolean isSport) {
        setName(name);
        setBrand(brand);
        setPrice(price);
        setSport(isSport);
        carId = -1;
    }

    public Cars(int carId, String name, String brand, double price, boolean isSport) {
        this(name,brand,price,isSport);
        setCarId(carId);
    }

    public Cars(int carId, String name, String brand, double price, boolean isSport, int carSalesNumber) {
        setName(name);
        setBrand(brand);
        setPrice(price);
        setSport(isSport);
        setCarId(carId);
        setCarSalesNumber(carSalesNumber);
    }

    public int getCarSalesNumber() {
        return carSalesNumber;
    }

    public void setCarSalesNumber(int carSalesNumber) {
        if(carSalesNumber >= 0)
        this.carSalesNumber = carSalesNumber;
        else throw new IllegalArgumentException("Car sales number must be non-negative");
    }

    public int getCarId() {
        return carId;
    }

    public void setCarId(int carId) {
        if (carId >=0)
        this.carId = carId;
        else {
            throw new IllegalArgumentException("car id must be positive");
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        ArrayList<String> validCarBrand =getBrands();
        if(validCarBrand.contains(brand))
        this.brand = brand;
        else throw new IllegalArgumentException("Invalid car brand, must be in the list of "+validCarBrand);
    }

    public static ArrayList<String> getBrands() {
        ArrayList<String> brands = new ArrayList<>();
        Collections.addAll(brands,"Toyota","Honda","BMW","Benz","Jeep");
        brands = (ArrayList<String>) brands.stream()
                .filter(brand -> !brand.contains("Jeep"))
                .collect(Collectors.toList());
        Collections.sort(brands);
    return brands;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        if (price >=0)
        this.price = price;
        else throw new IllegalArgumentException("the price must be non-negative");
    }

    public boolean isSport() {
        return sport;
    }

    public void setSport(boolean sport) {
        this.sport = sport;
    }

    @Override
    public String toString() {
        if (sport)
        return String.format("The car's name is %s, belongs to %s, with a price of %.2f. It is sport-style car",name,brand,price);
        else return String.format("The car's name is %s, belongs to %s, with a price of $%.2f. It is not a sport-style car",name,brand,price);
    }
}
