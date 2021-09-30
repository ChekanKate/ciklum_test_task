package com.chekan.ciklum;

import com.chekan.ciklum.entity.Order;
import org.junit.Test;

import static org.junit.Assert.*;

public class OrderEntityTest {

    @Test
    public void testSetId(){
        Order order = new Order();
        order.setId(2);
        assertTrue(order.getId() == 2);
    }

    @Test
    public void testSetUserId(){
        Order order = new Order();
        order.setUserId(2);
        assertTrue(order.getUserId() == 2);
    }

    @Test
    public void testSetStatus(){
        Order order = new Order();
        order.setStatus("delivered");
        assertTrue(order.getStatus().equals("delivered"));
    }

    @Test
    public void testSetCreatedAt(){
        Order order = new Order();
        order.setCreatedAt("2021-09-03 10:32");
        assertTrue(order.getCreatedAt().equals("2021-09-03 10:32"));
    }

}