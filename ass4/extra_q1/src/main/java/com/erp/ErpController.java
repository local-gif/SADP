    package com.erp;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/erp")
public class ErpController {

    private final List<Product> products = new ArrayList<>();
    private final List<Sale> sales = new ArrayList<>();

    // =========================
    // PRODUCT APIs
    // =========================

    @PostMapping("/products")
    public Product addProduct(@RequestBody Product product) {

        products.add(product);

        return product;
    }


    @GetMapping("/products")
    public List<Product> getProducts() {

        return products;
    }


    @GetMapping("/products/{id}")
    public Product getProduct(@PathVariable int id) {

        return products.stream()
                .filter(p -> p.getId() == id)
                .findFirst()
                .orElse(null);
    }


    @PutMapping("/products/{id}")
    public Product updateProduct(
            @PathVariable int id,
            @RequestBody Product updatedProduct) {

        for (Product product : products) {

            if (product.getId() == id) {

                product.setName(updatedProduct.getName());
                product.setQuantity(updatedProduct.getQuantity());
                product.setPrice(updatedProduct.getPrice());

                return product;
            }
        }

        return null;
    }


    @DeleteMapping("/products/{id}")
    public String deleteProduct(@PathVariable int id) {

        boolean removed =
                products.removeIf(
                        product -> product.getId() == id
                );

        return removed
                ? "Product deleted successfully"
                : "Product not found";
    }


    // =========================
    // SALES APIs
    // =========================

    @PostMapping("/sales")
    public Sale addSale(@RequestBody Sale sale) {

        Product product =
                products.stream()
                        .filter(p -> p.getId() == sale.getProductId())
                        .findFirst()
                        .orElse(null);

        if (product == null) {
            throw new RuntimeException("Product not found");
        }

        if (sale.getQuantity() <= 0) {
            throw new RuntimeException(
                    "Sale quantity must be greater than 0"
            );
        }

        if (product.getQuantity() < sale.getQuantity()) {
            throw new RuntimeException(
                    "Insufficient stock"
            );
        }

        double amount =
                product.getPrice() * sale.getQuantity();

        sale.setAmount(amount);

        product.setQuantity(
                product.getQuantity() - sale.getQuantity()
        );

        sales.add(sale);

        return sale;
    }


    @GetMapping("/sales")
    public List<Sale> getSales() {

        return sales;
    }


    @GetMapping("/sales/{id}")
    public Sale getSale(@PathVariable int id) {

        return sales.stream()
                .filter(s -> s.getId() == id)
                .findFirst()
                .orElse(null);
    }


    // =========================
    // DASHBOARD
    // =========================

    @GetMapping("/dashboard")
    public Dashboard dashboard() {

        int totalProducts = products.size();

        int totalStock =
                products.stream()
                        .mapToInt(Product::getQuantity)
                        .sum();

        double totalSales =
                sales.stream()
                        .mapToDouble(Sale::getAmount)
                        .sum();

        return new Dashboard(
                totalProducts,
                totalStock,
                sales.size(),
                totalSales
        );
    }


    // =========================
    // DASHBOARD CLASS
    // =========================

    public static class Dashboard {

        private int totalProducts;
        private int totalStock;
        private int totalSales;
        private double totalRevenue;

        public Dashboard(
                int totalProducts,
                int totalStock,
                int totalSales,
                double totalRevenue) {

            this.totalProducts = totalProducts;
            this.totalStock = totalStock;
            this.totalSales = totalSales;
            this.totalRevenue = totalRevenue;
        }

        public int getTotalProducts() {
            return totalProducts;
        }

        public int getTotalStock() {
            return totalStock;
        }

        public int getTotalSales() {
            return totalSales;
        }

        public double getTotalRevenue() {
            return totalRevenue;
        }
    }
}
