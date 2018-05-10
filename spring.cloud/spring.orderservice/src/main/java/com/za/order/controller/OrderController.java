package com.za.order.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.za.common.result.HLResult;
import com.za.order.dto.OrderDTO;
import com.za.order.service.IOrderService;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Resource
    private IOrderService orderService;

    @RequestMapping(value = "/findOrderById/{id}")
    public HLResult<OrderDTO> findOrderById(@PathVariable(value = "id") Long id) {
        HLResult<OrderDTO> findById = orderService.findById(id);
        return findById;
    }
}
