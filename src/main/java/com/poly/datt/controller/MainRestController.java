package com.poly.datt.controller;

import com.poly.datt.dto.LikeDTO;
import com.poly.datt.entity.Like;
import com.poly.datt.entity.Post;
import com.poly.datt.entity.User;
import com.poly.datt.service.LikeService;
import com.poly.datt.service.PostService;
import com.poly.datt.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainRestController {
    @Autowired
    private LikeService likeService;
    @Autowired
    private PostService postService;
    @Autowired
    private UserService userService;
    @PostMapping("like")
    public Boolean like(@RequestBody LikeDTO likeDTO){
        User user = userService.getOne(likeDTO.getIdUser());
        Post post = postService.getOne(likeDTO.getIdPost());
        Like like = likeService.check(post,user);
        if(like!=null){
            return false;
        }else {
            Like likeNew = Like.builder().user(user).post(post).build();
            likeService.save(likeNew);
        }
        return true;
    }
}
