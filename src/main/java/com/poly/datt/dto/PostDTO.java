package com.poly.datt.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
@Builder
public class PostDTO {
    private String title;
    private String content;
    private String idUser;
}
