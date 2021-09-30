package com.chekan.ciklum;

import com.chekan.ciklum.entity.Product;
import com.chekan.ciklum.entity.ProductsStatus;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class ProductEntityTest {

    @Test
    public void testSetId(){
        Product product = new Product();
        product.setId(2);
        assertTrue(product.getId() == 2);
    }

    @Test
    public void testSetName(){
        Product product = new Product();
        product.setName("abc");
        assertTrue(product.getName().equals("abc"));
    }

    @Test
    public void testSetPrice(){
        Product product = new Product();
        product.setPrice(100);
        assertTrue(product.getPrice() == 100);
    }

    @Test
    public void testSetStatus(){
        Product product = new Product();
        product.setStatus(ProductsStatus.in_stock);
        assertTrue(product.getStatus() == ProductsStatus.in_stock);
    }

}
