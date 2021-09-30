package com.chekan.ciklum.service;

import com.chekan.ciklum.dao.ProductDAO;
import com.chekan.ciklum.dao.ProductDAOImpl;
import com.chekan.ciklum.entity.Product;

public class ProductServiceImpl implements ProductService{

    private ProductDAO productDAO = new ProductDAOImpl();

    @Override
    public void getAllProducts() {
        productDAO.getAllProducts();
    }

    @Override
    public void deleteProductById(int id) {
        productDAO.deleteProductById(id);
    }

    @Override
    public void deleteAllProducts() {
        productDAO.deleteAllProducts();
    }

    @Override
    public void createProduct(Product product) {
        productDAO.createProduct(product);
    }

    @Override
    public void listOfOrderedProducts() {
        productDAO.listOfOrderedProducts();
    }
}
