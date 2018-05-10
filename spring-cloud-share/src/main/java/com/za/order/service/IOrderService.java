package com.za.order.service;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.za.common.result.HLResult;
import com.za.order.dto.OrderDTO;

@RequestMapping("/order")
public interface IOrderService {

    @RequestMapping("/findById/{id}")
    public HLResult<OrderDTO> findById(@PathVariable("id") Long id);

    @RequestMapping(value = "/findByDTO", method = RequestMethod.POST, consumes = { MediaType.APPLICATION_JSON_VALUE })
    public HLResult<OrderDTO> findByDTO(@RequestBody OrderDTO orderDTO);
}
