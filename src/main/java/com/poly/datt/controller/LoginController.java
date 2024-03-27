package com.poly.datt.controller;

import com.poly.datt.dto.UserDTO;
import com.poly.datt.dto.UserRequest;
import com.poly.datt.entity.User;
import com.poly.datt.service.UserService;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class LoginController {
    private final UserService userService;
    private final HttpSession session;

    @GetMapping("/loginPage")
    public String loginPage() {
        return "login/login";
    }

    @PostMapping("/login")
    public String login(@Valid @ModelAttribute UserDTO userDTO,
                        BindingResult result,
                        Model model) {
        if (result.hasErrors()) {
            model.addAttribute("error", "Vui lòng nhập đầy đủ thông tin");
            return "client/login/login";
        }
        User user =  userService.loginUser(userDTO);
        String email = userDTO.getEmail();
        String password = userDTO.getPassword();
        if (email.trim().isEmpty() || password.trim().isEmpty()) {
            model.addAttribute("error", "Vui lòng nhập đầy đủ thông tin");
            return "login/login";
        }
        if (user != null) {
            session.setAttribute("user", user);
            return "redirect:/home";
        } else {
            model.addAttribute("error", "Sai tài khoản hoặc mật khẩu");
            return "login/login";
        }
    }

    @GetMapping("/registerPage")
    public String registerPage(Model model) {
        model.addAttribute("user", new User());
        return "login/register";
    }

    @PostMapping("/register")
    public String register(Model model,
                           @Valid @ModelAttribute("user") UserRequest userRequest,
                           BindingResult result) {
        if (result.hasErrors()) {
            model.addAttribute("customer", new User());
            return "login/login";
        }else {
            User customer = userService.cretaeUser(userRequest);
            return "redirect:/loginPage";
        }
    }

    @GetMapping("/logout")
    public String logout() {
        session.removeAttribute("customer");
        return "redirect:/home";
    }
}
