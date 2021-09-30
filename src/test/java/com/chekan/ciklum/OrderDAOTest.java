package com.chekan.ciklum;

import com.chekan.ciklum.dao.OrderDAOImpl;
import com.chekan.ciklum.entity.Order;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.mockito.Matchers;
import org.mockito.Mockito;
import java.util.List;

public class OrderDAOTest {

    @Test
    public void getOrderByIdTest1(){
        OrderDAOImpl orderDAO = Mockito.mock(OrderDAOImpl.class);
        Mockito.doNothing().when(orderDAO).getOrderById(Matchers.anyInt());
        orderDAO.getOrderById(1);
        Mockito.verify(orderDAO, Mockito.times(1)).getOrderById(1);
    }

    @Test
    public void getOrderByIdTest2(){
        OrderDAOImpl orderDAO = Mockito.mock(OrderDAOImpl.class);
        Mockito.doThrow(new IllegalStateException("Error occurred!!"))
                .when(orderDAO)
                .getOrderById(Matchers.anyInt());
        Assertions.assertThrows(IllegalStateException.class, ()->orderDAO.getOrderById(Matchers.anyInt()));
    }

    @Test
    public void getOrdersTest(){
        OrderDAOImpl orderDAO = Mockito.mock(OrderDAOImpl.class);
        Mockito.doThrow(new IllegalStateException("Error occurred!!"))
                .when(orderDAO)
                .getOrders();
        Assertions.assertThrows(IllegalStateException.class, ()->orderDAO.getOrders());
    }

    @Test
    public void createOrderTest(){
        OrderDAOImpl orderDAO = Mockito.mock(OrderDAOImpl.class);
        Order order = Mockito.mock(Order.class);
        List<Integer> list = Mockito.mock(List.class);
        Mockito.doNothing().when(orderDAO).createOrder(order, list);
        orderDAO.createOrder(order, list);
        Mockito.verify(orderDAO, Mockito.times(1)).createOrder(order, list);
    }

    @Test
    public void updateOrderTest1(){
        OrderDAOImpl orderDAO = Mockito.mock(OrderDAOImpl.class);
        Mockito.doNothing().when(orderDAO).updateOrder(Matchers.anyInt(), Matchers.anyString());
        orderDAO.updateOrder(2, "delivered");
        Mockito.verify(orderDAO, Mockito.times(1)).updateOrder(2, "delivered");
    }

    @Test
    public void updateOrderTest2(){
        OrderDAOImpl orderDAO = Mockito.mock(OrderDAOImpl.class);
        Mockito.doThrow(new IllegalStateException("Error occurred!!"))
                .when(orderDAO)
                .updateOrder(Matchers.anyInt(), Matchers.anyString());
        Assertions.assertThrows(IllegalStateException.class, ()->orderDAO.updateOrder(Matchers.anyInt(), Matchers.anyString()));
    }

}
