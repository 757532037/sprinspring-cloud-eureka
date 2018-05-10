package com.za.order.service;

import org.joda.time.DateTime;
import org.springframework.stereotype.Service;

import com.za.common.result.HLResult;
import com.za.common.utils.HLDateTimeUtils;
import com.za.order.dto.OrderDTO;

@Service
public class OrderService implements IOrderService {

    public HLResult<OrderDTO> findById(Long id) {
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setId(id);
        orderDTO.setDate(HLDateTimeUtils.formatDateTimeDefault(new DateTime()));
        orderDTO.setName("饼干");
        orderDTO.setPrice("99.01");
        return HLResult.success(orderDTO);
    }

    @Override
    public HLResult<OrderDTO> findByDTO(OrderDTO orderDTO) {
        orderDTO.setDate(HLDateTimeUtils.formatDateDefault(new DateTime()));
        orderDTO.setId(orderDTO.getId() * 100);
        orderDTO.setName("CoCo");
        orderDTO.setPrice("1001.00");
        return HLResult.success(orderDTO);
    }
}
