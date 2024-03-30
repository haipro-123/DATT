package com.poly.datt.service.impl;

import com.poly.datt.dto.UserDTO;
import com.poly.datt.dto.UserRequest;
import com.poly.datt.entity.User;
import com.poly.datt.repository.UserRepository;
import com.poly.datt.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public User loginUser(UserDTO userDTO) {
        return userRepository.loginUser(
                userDTO.getEmail(),
                userDTO.getPassword());
    }

    @Override
    public User cretaeUser(UserRequest userRequest) {
        // Kiểm tra xem email đã tồn tại trong hệ thống chưa
        if (userRepository.existsByEmail(userRequest.getEmail())) {
            throw new RuntimeException("Email already exists");
        }
        User user = User.builder()
                .name(userRequest.getName())
                .username(userRequest.getUsername())
                .password(userRequest.getPassword())
                .address(userRequest.getAddress())
                .email(userRequest.getEmail())
                .build();
        return userRepository.save(user);
    }

    @Override
    public User getOne(UUID idUser) {
        return userRepository.findById(idUser).get();
    }
}
