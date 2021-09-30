package com.chekan.ciklum.dao;

import com.chekan.ciklum.entity.Order;
import com.chekan.ciklum.entity.OrderItems;


import java.sql.Connection;
import java.util.List;

public interface OrderDAO {
    public void getOrderById(int id);
    public void getOrders();
    public void createOrder(Order order, List<Integer> productsIds);
    public void createOrderItems(Connection connection, int orderId, List<Integer> ids);
    public void updateOrder(int orderId, String status);
    public void updateOrderItems(OrderItems orderItems, int orderId, int productId, String status);
}
