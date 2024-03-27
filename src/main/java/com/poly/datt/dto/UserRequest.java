package com.poly.datt.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserRequest {
    private String name;

    private String username;

    private String password;

    private String address;

    private String email;
}
