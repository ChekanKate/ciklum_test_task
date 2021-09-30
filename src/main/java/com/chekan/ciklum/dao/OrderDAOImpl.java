package com.chekan.ciklum.dao;

import com.chekan.ciklum.DbConnection;
import com.chekan.ciklum.GeneratorId;
import com.chekan.ciklum.entity.Order;
import com.chekan.ciklum.entity.OrderItems;
import com.chekan.ciklum.entity.Product;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class OrderDAOImpl implements OrderDAO{
    private static Connection connection;
    private static final Lock CONNECTION_LOCK = new ReentrantLock();

    private static final String GET_ORDER_BY_ID = "SELECT orders.id, SUM(products.price*order_items.quantity), " +
            "products.name, SUM(order_items.quantity), orders.created_at FROM orders LEFT JOIN order_items ON " +
            "orders.id = order_items.order_id LEFT JOIN products ON product_id=products.id WHERE orders.id = ? " +
            "GROUP BY orders.id, orders.created_at, products.name;";
    private static final String GET_ORDERS = "SELECT orders.id, SUM(products.price*order_items.quantity), " +
            "products.name, SUM(order_items.quantity), orders.created_at FROM orders LEFT JOIN order_items ON " +
            "orders.id = order_items.order_id LEFT JOIN products ON product_id=products.id GROUP BY orders.id, orders.created_at, products.name;";
    private static final String CREATE_ORDER = "INSERT INTO orders(user_id, status, created_at) VALUES (?,?,?)";
    private static final String CREATE_ORDER_ITEMS = "INSERT INTO order_items (order_id, product_id, quantity) VALUES (?,?,?)";
    private static final String UPDATE_ORDER_ITEMS = "UPDATE order_items SET quantity = ? WHERE order_id = ? AND product_id = ?";
    private static final String UPDATE_ORDER = "UPDATE orders SET status = ? WHERE id = ?";

    @Override
    public void getOrderById(int id) {
        PreparedStatement statement = null;
        ResultSet rs = null;
        try{
            connection = DbConnection.getConnection();
            CONNECTION_LOCK.lock();
            statement = connection.prepareStatement(GET_ORDER_BY_ID);
            statement.setInt(1, id);
            rs = statement.executeQuery();
            System.out.println(" Order ID  Products total Price  Product Name  Products Quantity in orderEntry " +
                    " Order Created Date ");
            System.out.println("------------------------------------------------------------------------------------" +
                    "---------------------");
            while (rs.next()) {
                System.out.printf(" %-8s  %-20s  %-12s  %-31s  %-18s  %n",
                        rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5));
            }
        }catch (SQLException e) {
            System.out.println("Get order by id method :" + e.getMessage());
        } finally {
            close(rs);
            close(statement);
            CONNECTION_LOCK.unlock();
        }
    }

    @Override
    public void getOrders() {
        PreparedStatement statement = null;
        ResultSet rs = null;
        try{
            connection = DbConnection.getConnection();
            CONNECTION_LOCK.lock();
            statement = connection.prepareStatement(GET_ORDERS);
            rs = statement.executeQuery();
            System.out.println(" Order ID  Products total Price  Product Name  Products Quantity in orderEntry " +
                    " Order Created Date ");
            System.out.println("------------------------------------------------------------------------------------" +
                    "---------------------");
            while (rs.next()) {
                System.out.printf(" %-8s  %-20s  %-12s  %-31s  %-18s  %n",
                        rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5));
            }
        }catch (SQLException e) {
            System.out.println("Get orders method :" + e.getMessage());
        } finally {
            close(rs);
            close(statement);
            CONNECTION_LOCK.unlock();
        }
    }

    public void createOrder(Order order, List<Integer> productsIds) {
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            connection = DbConnection.getConnection();
            GeneratorId generatorId = new GeneratorId(100);
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm");
            Date date = new Date(System.currentTimeMillis());
            String currentDate = formatter.format(date);
            statement = connection.prepareStatement(CREATE_ORDER, Statement.RETURN_GENERATED_KEYS);
            statement.setInt(1, generatorId.random());
            statement.setString(2, "packing");
            statement.setString(3, currentDate);
            statement.executeUpdate();
            resultSet= statement.getGeneratedKeys();
            if (resultSet.next()) {
                order.setId(resultSet.getInt(1));
            }
            createOrderItems(connection, order.getId(), productsIds);
        } catch (SQLException e) {
            System.out.println("Create order method :" + e.getMessage());
        }finally {
                close(statement);
                close(resultSet);
            }
    }

    public void createOrderItems(Connection connection, int orderId, List<Integer> ids) {
        PreparedStatement statement = null;
        for (int productId : ids) {
            try {
            statement = connection.prepareStatement(CREATE_ORDER_ITEMS);
            statement.setInt(1, orderId);
            statement.setInt(2, productId);
            statement.setInt(3, 1);
            statement.executeUpdate();
            } catch (SQLException e) {
                System.out.println("Create order items method :" + e.getMessage());
            }finally {
                close(statement);
            }
        }
    }

    @Override
    public void updateOrder(int orderId, String status) {
        PreparedStatement statement = null;
        try{
            connection = DbConnection.getConnection();
            CONNECTION_LOCK.lock();
            statement = connection.prepareStatement(UPDATE_ORDER);
            statement.setString(1, status);
            statement.setInt(2, orderId);
            statement.executeUpdate();
        }catch (SQLException e) {
            System.out.println("Update order method :" + e.getMessage());
        }finally {
            close(statement);
            CONNECTION_LOCK.unlock();
        }
    }

    @Override
    public void updateOrderItems(OrderItems orderItems, int orderId, int productId, String status) {
        PreparedStatement statement = null;
        try {
            connection = DbConnection.getConnection();
            CONNECTION_LOCK.lock();
            statement = connection.prepareStatement(UPDATE_ORDER_ITEMS);
            statement.setInt(1, orderItems.getQuantity());
            statement.setInt(2, orderId);
            statement.setInt(3, productId);
            statement.executeUpdate();
            updateOrder(orderId, status);
        }catch (SQLException e) {
            System.out.println("Update order items method :" + e.getMessage());
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