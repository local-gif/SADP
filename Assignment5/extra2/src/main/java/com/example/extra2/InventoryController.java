package com.example.extra2;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class InventoryController {

    private List<Inventory> inventory = new ArrayList<>();

    public InventoryController() {
        inventory.add(new Inventory(1, "Laptop", 10, 55000));
        inventory.add(new Inventory(2, "Keyboard", 25, 1200));
        inventory.add(new Inventory(3, "Mouse", 30, 700));
    }

    // Display all products
    @GetMapping("/inventory")
    public List<Inventory> getAllProducts() {
        return inventory;
    }

    // Display product by ID
    @GetMapping("/inventory/{id}")
    public Inventory getProduct(@PathVariable int id) {

        for (Inventory item : inventory) {
            if (item.getId() == id) {
                return item;
            }
        }

        return null;
    }

    // Add a new product
    @PostMapping("/inventory")
    public String addProduct(@RequestBody Inventory item) {
        inventory.add(item);
        return "Product added successfully";
    }

    // Delete a product
    @DeleteMapping("/inventory/{id}")
    public String deleteProduct(@PathVariable int id) {

        for (Inventory item : inventory) {
            if (item.getId() == id) {
                inventory.remove(item);
                return "Product deleted successfully";
            }
        }

        return "Product not found";
    }
}