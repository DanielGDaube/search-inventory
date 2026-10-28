package com.pluralsight;

import java.util.ArrayList;

// Starter for Search Inventory (Workbook 3a, Section 3-2 Using an ArrayList, Exercise 1).
// main is done: it asks getInventory() for the list and prints every product.
// Your job is getInventory(): fill the list with at least 5 products.
public class SearchInventory {
    public static void main(String[] args) {
        ArrayList<Product> inventory = getInventory();

        for (Product product : inventory) {
            System.out.println(product);
        }

    }

    public static ArrayList<Product> getInventory() {
        ArrayList<Product> inventory = new ArrayList<>();

        inventory.add(new Product(1, "Apples", 12.35));
        inventory.add(new Product(2, "Bananas", 12.55));
        inventory.add(new Product(3, "Oranges", 13.40));
        inventory.add(new Product(4, "Blueberries", 8.35));
        inventory.add(new Product(5, "Strawberries", 8.20));

        return inventory;
    }
}
