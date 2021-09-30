package com.chekan.ciklum.service;

import com.chekan.ciklum.entity.Product;

public interface ProductService {
    public void getAllProducts();
    public void deleteProductById(int id);
    public void deleteAllProducts();
    public void createProduct(Product product);
    public void listOfOrderedProducts();
}
