package com.example.cars;

import java.util.*;
import java.util.stream.Collectors;

public class Cars {
    private String name, brand;
    private double price;
    private boolean isSport;

    public Cars(String name, String brand, double price, boolean isSport) {
        setName(name);
        setBrand(brand);
        setPrice(price);
        setSport(isSport);
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
        LinkedList<String> validCarBrand =getBrands();
        if(validCarBrand.contains(brand))
        this.brand = brand;
        else throw new IllegalArgumentException("Invalid car brand, must be in the list of "+validCarBrand);
    }

    public static LinkedList<String> getBrands() {
        LinkedList<String> brands = new LinkedList<>();
        Collections.addAll(brands,"Toyota","Honda","BMW","Benz","Jeep");
        brands.stream()
                .filter(brand -> !brand.contains("Jeep"))
                .collect(Collectors.toList());
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
        return isSport;
    }

    public void setSport(boolean sport) {
        isSport = sport;
    }
}
