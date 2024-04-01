package com.poly.datt.controller;

import com.poly.datt.entity.Post;
import com.poly.datt.entity.User;
import com.poly.datt.service.PostService;
import com.poly.datt.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.UUID;

@Controller
@RequiredArgsConstructor
public class PostController {
    private final UserService userService;
    private final PostService postService;
    private final HttpSession session;
    private final HttpServletRequest request;

    @GetMapping("/post")
    public String postPage(Model model) {
        return "pages/post";
    }

    @PostMapping("/save-post")
    public String post(@Valid @ModelAttribute("post") Post post,
                       BindingResult result,
                       RedirectAttributes redirectAttributes) {
        if (result.hasErrors()) {
            return "pages/post";
        }
        User user = post.getUser();
        if (user == null) {
            return "redirect:/login";
        }
        UUID userId = user.getId();

        postService.savePost(post);
        redirectAttributes.addFlashAttribute("successMessage", "Bài đăng đã được lưu thành công!");
        return "redirect:/home";
    }
}
