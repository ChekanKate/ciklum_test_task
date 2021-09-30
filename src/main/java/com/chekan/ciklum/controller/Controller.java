package com.chekan.ciklum.controller;

import com.chekan.ciklum.entity.Order;
import com.chekan.ciklum.entity.OrderItems;
import com.chekan.ciklum.entity.Product;
import com.chekan.ciklum.entity.ProductsStatus;
import com.chekan.ciklum.service.OrderService;
import com.chekan.ciklum.service.OrderServiceImpl;
import com.chekan.ciklum.service.ProductService;
import com.chekan.ciklum.service.ProductServiceImpl;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Controller {

    ProductService productService = new ProductServiceImpl();
    OrderService orderService = new OrderServiceImpl();

    public void startMethod(){
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Select an option and enter the desired number : ");
        System.out.println("1) Create");
        System.out.println("2) Update order");
        System.out.println("3) Views");
        System.out.println("4) Remove");
        System.out.println("0) Finish program");
        try {
            String in = reader.readLine();
            switch (in){
                case "1" : createReader(); break;
                case "2" : updateMethod(reader); break;
                case "3" : viewsReader(); break;
                case "4" : removeReader(); break;
                case "0" : System.out.println("The program is finished"); break;
                default : System.out.println("Wrong number.");
            }
        } catch (IOException e) {
            System.out.println("Start method : " + e.getMessage());
        }
    }

    public void createReader(){
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Select an option and enter the desired number : ");
        System.out.println("11) Create product ");
        System.out.println("12) Create order ");
        System.out.println("0) Go back to the main page ");
        try {
            String in = reader.readLine();
            switch (in){
                case "11" : createProduct(reader); break;
                case "12" : createOrder(reader); break;
                case "0" : startMethod(); break;
                default : System.out.println("Wrong number.");
            }
        } catch (IOException e) {
            System.out.println("Create reader method : " + e.getMessage());
        }
    }


    public void viewsReader(){
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Select an option and enter the desired number : ");
        System.out.println("31) Show view for all products ");
        System.out.println("32) Show list all products, which have been ordered at least once, with total ordered quantity sorted descending by the quantity ");
        System.out.println("33) Show view for order by id ");
        System.out.println("34) Show view for all orders ");
        System.out.println("0) Go back to the main page ");
        try {
            String in = reader.readLine();
            switch (in){
                case "31" : showViewForAllProducts(reader); break;
                case "32" : showListOfOrderedProducts(reader); break;
                case "33" : showOrderById(reader); break;
                case "34" : showAllOrders(reader); break;
                case "0" : startMethod(); break;
                default : System.out.println("Wrong number.");
            }
        } catch (IOException e) {
            System.out.println("Create reader method : " + e.getMessage());
        }
    }

    public void removeReader(){
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Select an option and enter the desired number : ");
        System.out.println("41) Delete product by id ");
        System.out.println("42) Delete all products ");
        System.out.println("0) Go back to the main page ");
        try {
            String in = reader.readLine();
            switch (in){
                case "41" : deleteProductById(reader); break;
                case "42" : deleteAllProducts(reader); break;
                case "0" : startMethod(); break;
                default : System.out.println("Wrong number.");
            }
        } catch (IOException e) {
            System.out.println("Create reader method : " + e.getMessage());
        }
    }

    public void updateMethod(BufferedReader reader){
        OrderItems orderItems = new OrderItems();
        System.out.println("Enter order's id : ");
        try {
            int id = Integer.parseInt(reader.readLine());
            System.out.println("Enter order's status : ");
            String status = reader.readLine();
            System.out.println("Enter product's id :");
            int productId = Integer.parseInt(reader.readLine());
            System.out.println("Enter quantity for this product :");
            int quantity = Integer.parseInt(reader.readLine());
            orderItems.setQuantity(quantity);
            orderService.updateOrderItems(orderItems, id, productId, status);
        } catch (IOException e) {
            System.out.println("Update order method : " + e.getMessage());
        }
        System.out.println("Order was updated");
        System.out.println("0) Go back to the main page ");
        try {
            String in = reader.readLine();
            switch (in){
                case "0" : startMethod(); break;
                default : System.out.println("Wrong number.");
            }
        } catch (IOException e) {
            System.out.println("Update order method : " + e.getMessage());
        }
    }

    public void showViewForAllProducts(BufferedReader reader){
        productService.getAllProducts();
        System.out.println("0) Go back to the main page ");
        try {
            String in = reader.readLine();
            switch (in){
                case "0" : startMethod(); break;
                default : System.out.println("Wrong number.");
            }
        } catch (IOException e) {
            System.out.println("Show view for all products method : " + e.getMessage());
        }
    }

    public void showListOfOrderedProducts(BufferedReader reader){
        productService.listOfOrderedProducts();
        System.out.println("0) Go back to the main page ");
        try {
            String in = reader.readLine();
            switch (in){
                case "0" : startMethod(); break;
                default : System.out.println("Wrong number.");
            }
        } catch (IOException e) {
            System.out.println("Show list of ordered products method : " + e.getMessage());
        }
    }

    public void showAllOrders(BufferedReader reader){
        orderService.getOrders();
        System.out.println("0) Go back to the main page ");
        try {
            String in = reader.readLine();
            switch (in){
                case "0" : startMethod(); break;
                default : System.out.println("Wrong number.");
            }
        } catch (IOException e) {
            System.out.println("Show all orders method : " + e.getMessage());
        }
    }

    public void showOrderById(BufferedReader reader){
        int id = 0;
        System.out.println("Enter order's ID :");
        try {
            id = Integer.parseInt(reader.readLine());
        } catch (IOException e) {
            System.out.println("Show order by id method : " + e.getMessage());
        }
        orderService.getOrderById(id);
        System.out.println("0) Go back to the main page ");
        try {
            String in = reader.readLine();
            switch (in){
                case "0" : startMethod(); break;
                default : System.out.println("Wrong number.");
            }
        } catch (IOException e) {
            System.out.println("Show order by id method : " + e.getMessage());
        }
    }

    public void deleteProductById(BufferedReader reader){
        int id = 0;
        System.out.println("Enter product's ID :");
        try {
            id = Integer.parseInt(reader.readLine());
        } catch (IOException e) {
            System.out.println("Delete product by id method : " + e.getMessage());
        }
        productService.deleteProductById(id);
        System.out.println("0) Go back to the main page ");
        try {
            String in = reader.readLine();
            switch (in){
                case "0" : startMethod(); break;
                default : System.out.println("Wrong number.");
            }
        } catch (IOException e) {
            System.out.println("Delete product by id method : " + e.getMessage());
        }
    }

    public void deleteAllProducts(BufferedReader reader){
        System.out.println("Enter password :");
        String password = null;
        try {
            password = reader.readLine();
        } catch (IOException e) {
            System.out.println("Delete all products method : " + e.getMessage());
        }
        if (password.equals("0000")){
            productService.deleteAllProducts();
        }else{
            System.out.println("Wrong password. Try again : ");
            if (password.equals("0000")){
                productService.deleteAllProducts();
            }else {
                System.out.println("Wrong password.");
            }
        }
        System.out.println("0) Go back to the main page ");
        try {
            String in = reader.readLine();
            switch (in){
                case "0" : startMethod(); break;
                default : System.out.println("Wrong number.");
            }
        } catch (IOException e) {
            System.out.println("Delete products method : " + e.getMessage());
        }
    }

    public void createProduct(BufferedReader reader){
        Product product = new Product();
        try {
            System.out.println("Enter product's name:");
            String name = reader.readLine();
            product.setName(name);
            System.out.println("Enter product's price:");
            int price = Integer.parseInt(reader.readLine());
            product.setPrice(price);
            System.out.println("Enter product's status:");
            System.out.println("1) out_of_stock");
            System.out.println("2) in_stock");
            System.out.println("3) running_low");
            String input = reader.readLine();
            switch (input) {
                case "1":
                    ProductsStatus status = ProductsStatus.out_of_stock;
                    product.setStatus(status);
                    break;
                case "2":
                    status = ProductsStatus.in_stock;
                    product.setStatus(status);
                    break;
                case "3":
                    status = ProductsStatus.running_low;
                    product.setStatus(status);
                    break;
                default : System.out.println("Wrong number!");

            }
            productService.createProduct(product);
        } catch (IOException e) {
            System.out.println("Create product method : " + e.getMessage());
        }
        System.out.println("Product was created.");
        System.out.println("0) Go back to the main page ");
        try {
            String in = reader.readLine();
            switch (in){
                case "0" : startMethod(); break;
                default : System.out.println("Wrong number.");
            }
        } catch (IOException e) {
            System.out.println("Create product method : " + e.getMessage());
        }
    }

    public void createOrder(BufferedReader reader){
        Order order = new Order();
        try {
            System.out.println("Введите products id's через пробел:");
            List<Integer> array;
            array = Arrays.stream(reader.readLine()
                    .strip()
                    .split(" ")).map(Integer::parseInt).collect(Collectors.toList());
            orderService.createOrder(order, array);
        } catch (IOException throwables) {
            System.out.println("Create order method : " + throwables.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Create order method : " + e.getMessage());
        }
        System.out.println("Order was created.");
        System.out.println("0) Go back to the main page ");
        try {
            String in = reader.readLine();
            switch (in){
                case "0" : startMethod(); break;
                default : System.out.println("Wrong number.");
            }
        } catch (IOException e) {
            System.out.println("Create order by id method : " + e.getMessage());
        }
    }
    }
