package org.example;

public class Wines {
    private int id;
    private String type;
    private String name;
    private double price;

    public Wines(int id, String type, String name, double price) {
        this.id = id;
        this.type = type;
        this.name = name;
        this.price = price;
    }

    public static Wines[] testData(){
        return new Wines[]{
                new Wines(1, "white", "Dom Perignon Vintage Moet & Chandon 2008", 225.94),
                new Wines(2, "red", "Pignoli Radikon Radikon 2009", 133.0),
                new Wines(3, "red", "Pinot Nero Elena Walch Elena Walch", 43.0),
        };
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}