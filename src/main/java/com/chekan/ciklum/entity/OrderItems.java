package com.chekan.ciklum.entity;

import java.util.Objects;

public class OrderItems {

    private int orderId;
    private int productId;
    private int quantity;

    public OrderItems() {
    }

    public OrderItems(int orderId, int productId, int quantity) {
        this.orderId = orderId;
        this.productId = productId;
        this.quantity = quantity;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof OrderItems)) return false;
        OrderItems that = (OrderItems) o;
        return orderId == that.orderId && productId == that.productId && quantity == that.quantity;
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderId, productId, quantity);
    }

    @Override
    public String toString() {
        return "OrderItems{" +
                "order_id=" + orderId +
                ", product_id=" + productId +
                ", quantity=" + quantity +
                '}';
    }
}
