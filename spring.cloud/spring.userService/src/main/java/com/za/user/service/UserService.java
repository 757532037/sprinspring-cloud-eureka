package com.za.user.service;

import org.joda.time.DateTime;
import org.springframework.stereotype.Service;

import com.za.common.result.HLResult;
import com.za.common.utils.HLDateTimeUtils;
import com.za.user.dto.UserDTO;

@Service
public class UserService implements IUserService {

    public HLResult<UserDTO> findById(Long id) {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(id);
        userDTO.setDate(HLDateTimeUtils.formatDateTimeDefault(new DateTime()));
        userDTO.setName("爱德华");
        return HLResult.success(userDTO);
    }

}
