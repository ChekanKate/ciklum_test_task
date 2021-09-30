package com.chekan.ciklum.service;

import com.chekan.ciklum.entity.Order;
import com.chekan.ciklum.entity.OrderItems;

import java.sql.Connection;
import java.util.List;

public interface OrderService {
    public void getOrderById(int id);
    public void getOrders();
    public void createOrder(Order order, List<Integer> productsIds);
    public void updateOrderItems(OrderItems orderItems, int orderId, int productId, String status);
}
