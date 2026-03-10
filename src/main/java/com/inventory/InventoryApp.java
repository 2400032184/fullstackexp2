package com.inventory;

import com.inventory.dao.ProductDAO;
import com.inventory.entity.Product;
import com.inventory.util.HibernateUtil;

public class InventoryApp {
    public static void main(String[] args) {
        ProductDAO productDAO = new ProductDAO();

        // Create - Insert multiple products
        System.out.println("=== Adding Products ===");
        Product p1 = new Product("Laptop", "High-performance laptop", 75000, 10);
        Product p2 = new Product("Mouse", "Wireless mouse", 500, 50);
        Product p3 = new Product("Keyboard", "Mechanical keyboard", 3000, 25);
        Product p4 = new Product("Monitor", "4K monitor", 25000, 5);

        productDAO.addProduct(p1);
        productDAO.addProduct(p2);
        productDAO.addProduct(p3);
        productDAO.addProduct(p4);

        // Read - Retrieve a product by ID
        System.out.println("\n=== Retrieving Product ===");
        Product retrievedProduct = productDAO.getProductById(1);
        if (retrievedProduct != null) {
            System.out.println("Retrieved: " + retrievedProduct);
        }

        // Update - Update price and quantity
        System.out.println("\n=== Updating Product ===");
        productDAO.updateProduct(2, 600, 45);
        Product updatedProduct = productDAO.getProductById(2);
        if (updatedProduct != null) {
            System.out.println("Updated: " + updatedProduct);
        }

        // Delete - Remove a discontinued product
        System.out.println("\n=== Deleting Product ===");
        productDAO.deleteProduct(4);

        // Verify deletion
        System.out.println("\n=== Verifying Deletion ===");
        Product deletedProduct = productDAO.getProductById(4);
        if (deletedProduct == null) {
            System.out.println("Product successfully deleted");
        }

        HibernateUtil.shutdown();
    }
}
