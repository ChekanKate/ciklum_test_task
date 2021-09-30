package com.chekan.ciklum;

import com.chekan.ciklum.entity.OrderItems;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class OrdItemsEntityTest {

    @Test
    public void testSetOrderId(){
        OrderItems orderItems = new OrderItems();
        orderItems.setOrderId(2);
        assertTrue(orderItems.getOrderId() == 2);
    }

    @Test
    public void testSetProductId(){
        OrderItems orderItems = new OrderItems();
        orderItems.setProductId(5);
        assertTrue(orderItems.getProductId() == 5);
    }

    @Test
    public void testSetQuantity(){
        OrderItems orderItems = new OrderItems();
        orderItems.setQuantity(3);
        assertTrue(orderItems.getQuantity() == 3);
    }

}
