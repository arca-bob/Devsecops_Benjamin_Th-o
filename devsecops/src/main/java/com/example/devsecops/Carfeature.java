package com.example.devsecops;


public class Carfeature {
        private String brand;
        private int price;
        private boolean rented;
        private String LicencePlate;
        private String rent_begin;
        private String rent_end;

        public Carfeature(){}


    public Carfeature(String brand, int price, String LicencePlate) {
        this.brand = brand;
        this.price = price;
        this.LicencePlate = LicencePlate;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public boolean isRented() {
        return rented;
    }

    public void setRented(boolean rented) {
        this.rented = rented;
    }

    public String getLicencePlate() {
        return LicencePlate;
    }

    public void setLicencePlate(String LicencePlate) {
        this.LicencePlate = LicencePlate;
    }

    public String getRent_begin() {
        return rent_begin;
    }

    public void setRent_begin(String rent_begin) {
        this.rent_begin = rent_begin;
    }

    public String getRent_end() {
        return rent_end;
    }

    public void setRent_end(String rent_end) {
        this.rent_end = rent_end;
    }
}


