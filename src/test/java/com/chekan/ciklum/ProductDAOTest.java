package com.chekan.ciklum;

import com.chekan.ciklum.dao.ProductDAOImpl;
import com.chekan.ciklum.entity.Product;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.mockito.Matchers;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.*;

public class ProductDAOTest {

    @Test
    public void getAllProductsTest(){
        ProductDAOImpl productDAO = Mockito.mock(ProductDAOImpl.class);
        Mockito.doThrow(new IllegalStateException("Error occurred!!"))
                .when(productDAO)
                .getAllProducts();
        Assertions.assertThrows(IllegalStateException.class, ()->productDAO.getAllProducts());
    }

    @Test
    public void deleteProductByIdTest(){
        ProductDAOImpl productDAO = Mockito.mock(ProductDAOImpl.class);
        Mockito.doNothing().when(productDAO).deleteProductById(Matchers.anyInt());
        productDAO.deleteProductById(1);
        Mockito.verify(productDAO, Mockito.times(1)).deleteProductById(1);
    }

    @Test
    public void deleteAllProductsTest(){
        ProductDAOImpl productDAO = Mockito.mock(ProductDAOImpl.class);
        Mockito.doThrow(new IllegalStateException("Error occurred!!"))
                .when(productDAO)
                .deleteAllProducts();
        Assertions.assertThrows(IllegalStateException.class, ()->productDAO.deleteAllProducts());
    }

    @Test
    public void createProductTest(){
        ProductDAOImpl productDAO = Mockito.mock(ProductDAOImpl.class);
        Product product = Mockito.mock(Product.class);
        Mockito.doNothing().when(productDAO).createProduct(product);
        productDAO.createProduct(product);
        Mockito.verify(productDAO, Mockito.times(1)).createProduct(product);
    }

    @Test
    public void listOfOrderedProductsTest(){
        ProductDAOImpl productDAO = Mockito.mock(ProductDAOImpl.class);
        Mockito.doThrow(new IllegalStateException("Error occurred!!"))
                .when(productDAO)
                .listOfOrderedProducts();
        Assertions.assertThrows(IllegalStateException.class, ()->productDAO.listOfOrderedProducts());
    }

}
