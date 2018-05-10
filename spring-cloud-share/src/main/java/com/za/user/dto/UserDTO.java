
package com.za.user.dto;

import lombok.Data;

@Data
public class UserDTO {

    private Long   id;
    private String name;
    private String date;

    @Override
    public String toString() {
        return "UserDTO [id=" + id + ", name=" + name + ", date=" + date + "]";
    }

}
