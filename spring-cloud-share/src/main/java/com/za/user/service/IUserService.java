package com.za.user.service;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.za.common.result.HLResult;
import com.za.user.dto.UserDTO;

@RequestMapping("/user")
public interface IUserService {

    @RequestMapping("/findById/{id}")
    public HLResult<UserDTO> findById(@PathVariable("id") Long id);

}
