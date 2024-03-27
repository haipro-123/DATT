package com.poly.datt.controller;

import com.poly.datt.entity.Post;
import com.poly.datt.service.PostService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Controller
public class MainController {
    @Autowired
    private PostService postService;
    @GetMapping("view")
    public String view(Model model, @RequestParam("page") Optional<Integer> page){
        int currentPage = page.orElse(1);
        Page<Post> listPost = postService.findPaginated(PageRequest.of(currentPage-1,5));
        model.addAttribute("listPost",listPost);
        int totalPages = listPost.getTotalPages();
        if(totalPages>0){
            List<Integer> pageNumber = IntStream.rangeClosed(1,totalPages).boxed().collect(Collectors.toList());
            model.addAttribute("pageNumbers",pageNumber);
        }
        return "/pages/home";
    }
}
