package com.za.user.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.za.common.result.HLResult;
import com.za.order.dto.OrderDTO;
import com.za.order.service.IOrderService;
import com.za.user.dto.UserDTO;
import com.za.user.service.IUserService;

@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    private IUserService  userService;

    @Resource
    private IOrderService orderService;

    @RequestMapping("/findByUserId/{id}")
    public HLResult<UserDTO> findByUserId(@PathVariable(value = "id") Long id) {
        return userService.findById(id);
    }

    @RequestMapping("/findOrderByUserId/{id}")
    public HLResult<OrderDTO> findOrderByUserId(@PathVariable(value = "id") Long id) {
        return orderService.findById(id);
    }

}
