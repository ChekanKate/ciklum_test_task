package com.chekan.ciklum.dao;

import com.chekan.ciklum.entity.Product;

public interface ProductDAO {
    public void getAllProducts();
    public void deleteProductById(int id);
    public void deleteAllProducts();
    public void createProduct(Product product);
    public void listOfOrderedProducts();
}
