package com.pluralsight;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;

// Starter for Search Inventory (Workbook 3a, Section 3-2 Using an ArrayList, Exercise 1).
// main is done: it asks getInventory() for the list and prints every product.
// Your job is getInventory(): fill the list with at least 5 products.
public class SearchInventory {
    public static void main(String[] args) throws IOException {
        ArrayList<Product> inventory = getInventory();


        for (Product product : inventory) {
            System.out.println(product);
        }

    }

    public static ArrayList<Product> getInventory() throws IOException {
        ArrayList<Product> inventory = new ArrayList<>();
        BufferedReader inventoryReader = new BufferedReader(new FileReader("inventory.csv"));

        inventoryReader.readLine();

        String line;
        String inventoryText;

        while ((line = inventoryReader.readLine()) != null){
            String[] tokens = line.split("\\|");
            int id = Integer.parseInt(tokens[0]);
            String name = tokens[1];
            double price = Double.parseDouble(tokens[2]);
            inventory.add(new Product(id, name, price));

        }

        inventory.sort(Comparator.comparing(Product::getName));

        return inventory;
    }
}
