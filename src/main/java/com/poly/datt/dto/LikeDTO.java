package com.poly.datt.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Data
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class LikeDTO {
    private UUID idPost;
    private UUID idUser;
}
