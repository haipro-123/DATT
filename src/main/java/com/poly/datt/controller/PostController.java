package com.poly.datt.controller;

import com.poly.datt.service.PostService;
import com.poly.datt.service.UserService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class PostController {
    private final UserService userService;
    @Autowired
    private PostService postService;
    private final HttpSession session;

    @GetMapping("/post")
    public String postPage() {
        return "pages/post";
    }

    @PostMapping("/post")
    public String post() {
        return "redirect:/home";
    }
}
