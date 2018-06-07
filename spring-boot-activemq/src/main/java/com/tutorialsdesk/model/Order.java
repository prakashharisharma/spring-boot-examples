package com.tutorialsdesk.model;

import java.io.Serializable;
import java.time.LocalDateTime;

public class Order implements Serializable {

    private static final long serialVersionUID = 5627830715271719049L;

    private int orderNo;
    private String orderDetail;
    private LocalDateTime timestamp;

    public Order() {
    }

    public Order(int onrderNo, String orderDetail, LocalDateTime timestamp) {
        this.orderNo = onrderNo;
        this.orderDetail = orderDetail;
        this.timestamp = timestamp;
    }

    public int getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(int onrderNo) {
        this.orderNo = onrderNo;
    }

    public String getOrderDetail() {
        return orderDetail;
    }

    public void setOrderDetail(String orderDetail) {
        this.orderDetail = orderDetail;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "Order{" +
                "onrderNo=" + orderNo +
                ", orderDetail='" + orderDetail + '\'' +
                ", timestamp=" + timestamp +
                '}';
    }
}
