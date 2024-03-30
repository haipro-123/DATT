package com.poly.datt.dto;

import com.poly.datt.entity.User;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class PostDTO {
    private String title;
    private String content;
    private User user;
}
