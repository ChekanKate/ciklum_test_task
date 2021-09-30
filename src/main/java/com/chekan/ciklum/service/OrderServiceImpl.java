package com.chekan.ciklum.service;

import com.chekan.ciklum.dao.OrderDAO;
import com.chekan.ciklum.dao.OrderDAOImpl;
import com.chekan.ciklum.entity.Order;
import com.chekan.ciklum.entity.OrderItems;

import java.util.List;

public class OrderServiceImpl implements OrderService{

    private OrderDAO orderDAO = new OrderDAOImpl();

    @Override
    public void getOrderById(int id) {
        orderDAO.getOrderById(id);
    }

    @Override
    public void getOrders() {
        orderDAO.getOrders();
    }

    @Override
    public void createOrder(Order order, List<Integer> productsIds) {
        orderDAO.createOrder(order, productsIds);
    }

    @Override
    public void updateOrderItems(OrderItems orderItems, int orderId, int productId, String status) {
        orderDAO.updateOrderItems(orderItems, orderId, productId, status);
    }
}
