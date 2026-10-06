package com.inventory;

public class Item {
    private int id;
    private String name;
    private String category;
    private int stock;
    private double unitPrice;

    public Item() { }

    public Item(int id, String name, String category, int stock, double unitPrice) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.stock = stock;
        this.unitPrice = unitPrice;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }
    public int getStock() { return stock; }
    public void setStock(int stock) { this.stock = stock; }
    public double getUnitPrice() { return unitPrice; }
    public void setUnitPrice(double unitPrice) { this.unitPrice = unitPrice; }
}
