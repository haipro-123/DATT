package com.poly.datt.controller;

import com.poly.datt.dto.PostDTO;
import com.poly.datt.entity.Post;
import com.poly.datt.entity.User;
import com.poly.datt.service.PostService;
import com.poly.datt.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class PostRestController {
    @Autowired
    private PostService postService;
    @Autowired
    private UserService userService;
    @PostMapping("/save")
    public Boolean savePost(@RequestBody PostDTO postDTO) {
        User user = userService.getOne(UUID.fromString(postDTO.getIdUser()));
        postService.savePost(Post.builder().title(postDTO.getTitle()).content(postDTO.getContent()).user(user).build());
        return true;
    }
}
