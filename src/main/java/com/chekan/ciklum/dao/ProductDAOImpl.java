package com.chekan.ciklum.dao;

import com.chekan.ciklum.DbConnection;
import com.chekan.ciklum.entity.Product;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ProductDAOImpl implements ProductDAO{

    private static Connection connection;
    private static final Lock CONNECTION_LOCK = new ReentrantLock();

    private static final String GET_ALL_PRODUCTS = "SELECT name, price, status FROM products";
    private static final String DELETE_PRODUCT_BY_ID = "DELETE FROM products WHERE id = ?";
    private static final String DELETE_ALL_PRODUCTS = "DELETE FROM products";
    private static final String CREATE_PRODUCT = "INSERT INTO products(name, price, status, created_at) values (?,?,?,?)";
    private static final String LIST_OF_ORDERED_PRODUCTS = "select name, sum(quantity) from products, order_items " +
            "where products.id =order_items.product_id and quantity > 0 group by name order by sum(quantity) desc;";

    @Override
    public void createProduct(Product product) {
        PreparedStatement statement = null;
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        Date date = new Date(System.currentTimeMillis());
        String currentDate = formatter.format(date);
        try{
            connection = DbConnection.getConnection();
            CONNECTION_LOCK.lock();
            statement = connection.prepareStatement(CREATE_PRODUCT);
            statement.setString(1, product.getName());
            statement.setInt(2, product.getPrice());
            statement.setString(3, product.getStatus().name());
            statement.setString(4, currentDate);
            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Create product method :" + e.getMessage());
        }finally {
            close(statement);
            CONNECTION_LOCK.unlock();
        }
    }

    @Override
    public void listOfOrderedProducts() {
        Statement statement = null;
        ResultSet rs = null;
        try {
            connection = DbConnection.getConnection();
            CONNECTION_LOCK.lock();
            statement = connection.createStatement();
            rs = statement.executeQuery(LIST_OF_ORDERED_PRODUCTS);
            System.out.println("      name        quantity ");
            System.out.println("-----------------------------------");
            while (rs.next()) {
                System.out.printf(" %-15s  %-13s  %n",
                        rs.getString(1),
                        rs.getString(2));
            }
        }catch (Exception e) {
            System.out.println("Get all products method :" + e.getMessage());
        } finally {
            close(rs);
            close(statement);
            CONNECTION_LOCK.unlock();
        }
    }

    @Override
    public void getAllProducts() {
        Statement statement = null;
        ResultSet rs = null;
            try {
                connection = DbConnection.getConnection();
                CONNECTION_LOCK.lock();
                statement = connection.createStatement();
                rs = statement.executeQuery(GET_ALL_PRODUCTS);
                System.out.println(" Product Name  Product Price  Product Status ");
                System.out.println("-------------------------------------------------");
                while (rs.next()) {
                    System.out.printf(" %-12s  %-13s  %-14s %n",
                            rs.getString(1),
                            rs.getString(2),
                            rs.getString(3));
                }
            } catch (Exception e) {
                System.out.println("Get all products method :" + e.getMessage());
            } finally {
                close(rs);
                close(statement);
                CONNECTION_LOCK.unlock();
            }
    }

    @Override
    public void deleteProductById(int id) {
        PreparedStatement statement = null;
        try{
            connection = DbConnection.getConnection();
            CONNECTION_LOCK.lock();
            statement = connection.prepareStatement(DELETE_PRODUCT_BY_ID);
            statement.setInt(1, id);
            statement.executeUpdate();
            System.out.println("Product with id " + id + " was deleted");
        } catch (SQLException e) {
            System.out.println("Delete product by id method : " + e.getMessage());
        }finally {
            close(statement);
            CONNECTION_LOCK.unlock();
        }
    }

    @Override
    public void deleteAllProducts() {
        PreparedStatement statement = null;
        try{
            connection = DbConnection.getConnection();
            CONNECTION_LOCK.lock();
            statement = connection.prepareStatement(DELETE_ALL_PRODUCTS);
            statement.executeUpdate(DELETE_ALL_PRODUCTS);
            System.out.println("All products were deleted.");
        } catch (SQLException e) {
            System.out.println("Delete all products method : " + e.getMessage());
        }finally {
            close(statement);
            CONNECTION_LOCK.unlock();
        }
    }

    private static void close(Statement st) {
        if (st != null) {
            try {
                st.close();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static void close(ResultSet rs) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
