package com.poly.datt.service;


import com.poly.datt.dto.UserDTO;
import com.poly.datt.dto.UserRequest;
import com.poly.datt.entity.User;

public interface UserService {
    User loginUser(UserDTO userDTO);
    User cretaeUser(UserRequest userRequest);

}
