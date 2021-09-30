package com.chekan.ciklum;

import com.chekan.ciklum.controller.Controller;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.mockito.Mockito;

import java.io.BufferedReader;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

public class ControllerTest {

    @Test
    public void startMethodTest(){
        Controller controller = Mockito.mock(Controller.class);
        Mockito.doThrow(new IllegalStateException("Error occurred!!"))
                .when(controller)
                .startMethod();
        Assertions.assertThrows(IllegalStateException.class, ()->controller.startMethod());
    }

    @Test
    public void createReaderTest(){
        Controller controller = Mockito.mock(Controller.class);
        Mockito.doThrow(new IllegalStateException("Error occurred!!"))
                .when(controller)
                .createReader();
        Assertions.assertThrows(IllegalStateException.class, ()->controller.createReader());
    }

    @Test
    public void viewsReaderTest(){
        Controller controller = Mockito.mock(Controller.class);
        Mockito.doThrow(new IllegalStateException("Error occurred!!"))
                .when(controller)
                .viewsReader();
        Assertions.assertThrows(IllegalStateException.class, ()->controller.viewsReader());
    }

    @Test
    public void removeReaderTest(){
        Controller controller = Mockito.mock(Controller.class);
        Mockito.doThrow(new IllegalStateException("Error occurred!!"))
                .when(controller)
                .removeReader();
        Assertions.assertThrows(IllegalStateException.class, ()->controller.removeReader());
    }

    @Test
    public void updateMethodTest(){
        Controller controller = Mockito.mock(Controller.class);
        BufferedReader bufferedReader = Mockito.mock(BufferedReader.class);
        Mockito.doNothing().when(controller).updateMethod(bufferedReader);
        controller.updateMethod(bufferedReader);
        Mockito.verify(controller, Mockito.times(1)).updateMethod(bufferedReader);
    }

    @Test
    public void showViewForAllProductsTest(){
        Controller controller = Mockito.mock(Controller.class);
        BufferedReader bufferedReader = Mockito.mock(BufferedReader.class);
        Mockito.doNothing().when(controller).showViewForAllProducts(bufferedReader);
        controller.showViewForAllProducts(bufferedReader);
        Mockito.verify(controller, Mockito.times(1)).showViewForAllProducts(bufferedReader);
    }

    @Test
    public void showListOfOrderedProductsTest(){
        Controller controller = Mockito.mock(Controller.class);
        BufferedReader bufferedReader = Mockito.mock(BufferedReader.class);
        Mockito.doNothing().when(controller).showListOfOrderedProducts(bufferedReader);
        controller.showListOfOrderedProducts(bufferedReader);
        Mockito.verify(controller, Mockito.times(1)).showListOfOrderedProducts(bufferedReader);
    }

    @Test
    public void showAllOrdersTest(){
        Controller controller = Mockito.mock(Controller.class);
        BufferedReader bufferedReader = Mockito.mock(BufferedReader.class);
        Mockito.doNothing().when(controller).showAllOrders(bufferedReader);
        controller.showAllOrders(bufferedReader);
        Mockito.verify(controller, Mockito.times(1)).showAllOrders(bufferedReader);
    }

    @Test
    public void showOrderByIdTest(){
        Controller controller = Mockito.mock(Controller.class);
        BufferedReader bufferedReader = Mockito.mock(BufferedReader.class);
        Mockito.doNothing().when(controller).showOrderById(bufferedReader);
        controller.showOrderById(bufferedReader);
        Mockito.verify(controller, Mockito.times(1)).showOrderById(bufferedReader);
    }

    @Test
    public void deleteProductByIdTest(){
        Controller controller = Mockito.mock(Controller.class);
        BufferedReader bufferedReader = Mockito.mock(BufferedReader.class);
        Mockito.doNothing().when(controller).deleteProductById(bufferedReader);
        controller.deleteProductById(bufferedReader);
        Mockito.verify(controller, Mockito.times(1)).deleteProductById(bufferedReader);
    }

    @Test
    public void deleteAllProductsTest(){
        Controller controller = Mockito.mock(Controller.class);
        BufferedReader bufferedReader = Mockito.mock(BufferedReader.class);
        Mockito.doNothing().when(controller).deleteAllProducts(bufferedReader);
        controller.deleteAllProducts(bufferedReader);
        Mockito.verify(controller, Mockito.times(1)).deleteAllProducts(bufferedReader);
    }

    @Test
    public void createProductTest(){
        Controller controller = Mockito.mock(Controller.class);
        BufferedReader bufferedReader = Mockito.mock(BufferedReader.class);
        Mockito.doNothing().when(controller).createProduct(bufferedReader);
        controller.createProduct(bufferedReader);
        Mockito.verify(controller, Mockito.times(1)).createProduct(bufferedReader);
    }

    @Test
    public void createOrderTest(){
        Controller controller = Mockito.mock(Controller.class);
        BufferedReader bufferedReader = Mockito.mock(BufferedReader.class);
        Mockito.doNothing().when(controller).createOrder(bufferedReader);
        controller.createOrder(bufferedReader);
        Mockito.verify(controller, Mockito.times(1)).createOrder(bufferedReader);
    }
}
