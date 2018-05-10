package com.za.order.dto;

import lombok.Data;

@Data
public class OrderDTO {

    private Long   id;
    private String name;
    private String price;
    private String date;

    @Override
    public String toString() {
        return "OrderDTO [name=" + name + ", price=" + price + ", date=" + date + "]";
    }

}
