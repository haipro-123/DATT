package com.poly.datt.service;

import com.poly.datt.dto.UserDTO;
import com.poly.datt.dto.UserRequest;
import com.poly.datt.entity.User;

import java.util.UUID;

public interface UserService {
    User loginUser(UserDTO userDTO);
    User cretaeUser(UserRequest userRequest);

    User getOne(UUID idUser);
}