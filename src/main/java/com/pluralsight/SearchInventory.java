package com.pluralsight;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

// Starter for Search Inventory (Workbook 3a, Section 3-2 Using an ArrayList, Exercise 1).
// main is done: it asks getInventory() for the list and prints every product.
// Your job is getInventory(): fill the list with at least 5 products.
public class SearchInventory {
    public static void main(String[] args) throws IOException {
        ArrayList<Product> inventory = getInventory();
        Scanner inventoryScanner = new Scanner(System.in);

        boolean condition = true;
        while (condition){

            System.out.println("--------------------------");
            System.out.println("1 - List all products");
            System.out.println("2 - Look up product by ID");
            System.out.println("3 - Find product by price range");
            System.out.println("4 - Add a product");
            System.out.println("5 - Quit");
            System.out.println("--------------------------");

            switch (inventoryScanner.nextInt()){
                case 1 ->{
                    for (Product product : inventory) {
                        System.out.println(product);
                    }
                }
                case 2 -> {
                    System.out.println("Enter product ID");
                    int searchId = inventoryScanner.nextInt();
                    inventoryScanner.nextLine();
                    for (Product product : inventory) {
                        if (product.getId() == searchId) {
                            System.out.println(product);
                        }
                    }
                }
                case 3 -> {
                    System.out.println("Enter minimum price");
                    double minPrice = inventoryScanner.nextInt();
                    System.out.println("Enter maximum price");
                    double maxPrice = inventoryScanner.nextInt();
                    for (Product product : inventory) {
                        if (product.getPrice() <= maxPrice && product.getPrice() >= minPrice) {
                            System.out.println(product);
                        }
                    }
                }
                case 4 ->{
                    System.out.println("Enter ID");
                    int id = inventoryScanner.nextInt();
                    inventoryScanner.nextLine();
                    System.out.println("Enter name");
                    String name = inventoryScanner.nextLine();
                    System.out.println("Enter Price");
                    double price = inventoryScanner.nextDouble();
                    inventory.add(new Product(id, name, price));

                }
                case 5 ->{
                    condition = false;
                }
            }
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
