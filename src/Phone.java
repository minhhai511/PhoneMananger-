/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author SƠNPC
 */
public class Phone {
    private String model, CPU, RAM, primaryCam, screenSize, color, brand;
    private double price;

    public Phone() {
    }

    public Phone(String model, String CPU, String RAM, String primaryCam, String screenSize, String color, String brand, double price) {
        this.model = model;
        this.CPU = CPU;
        this.RAM = RAM;
        this.primaryCam = primaryCam;
        this.screenSize = screenSize;
        this.color = color;
        this.brand = brand;
        this.price = price;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getCPU() {
        return CPU;
    }

    public void setCPU(String CPU) {
        this.CPU = CPU;
    }

    public String getRAM() {
        return RAM;
    }

    public void setRAM(String RAM) {
        this.RAM = RAM;
    }

    public String getPrimaryCam() {
        return primaryCam;
    }

    public void setPrimaryCam(String primaryCam) {
        this.primaryCam = primaryCam;
    }

    public String getScreenSize() {
        return screenSize;
    }

    public void setScreenSize(String screenSize) {
        this.screenSize = screenSize;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return String.format("%-20s%-20s%-20s%-20s%-20s%-20s%-20s%-20s",
                model, CPU, RAM, primaryCam, screenSize, color,brand, price);
    }
    

}
