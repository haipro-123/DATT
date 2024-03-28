package com.poly.datt.controller;

import com.poly.datt.dto.UserDTO;
import com.poly.datt.dto.UserRequest;
import com.poly.datt.entity.User;
import com.poly.datt.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

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
    @ResponseBody
    public ResponseEntity<Map<String, String>> login(@Valid @ModelAttribute UserDTO userDTO,
                                                     BindingResult result,
                                                     HttpServletRequest request) {
        Map<String, String> response = new HashMap<>();
        try {
            if (result.hasErrors()) {
                response.put("error", "Vui lòng nhập đầy đủ thông tin");
                return ResponseEntity.badRequest().body(response);
            }

            String email = userDTO.getEmail();
            String password = userDTO.getPassword();
            if (email.trim().isEmpty() || password.trim().isEmpty()) {
                response.put("error", "Vui lòng nhập đầy đủ thông tin");
                return ResponseEntity.badRequest().body(response);
            }

            User user = userService.loginUser(userDTO);
            if (user != null) {
                response.put("success", "/home");
                return ResponseEntity.ok().body(response);
            } else {
                response.put("error", "Sai tài khoản hoặc mật khẩu");
                return ResponseEntity.badRequest().body(response);
            }
        } catch (Exception e) {
            response.put("error", "Đã xảy ra lỗi không xác định");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
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
            model.addAttribute("user", new User());
            return "login/login";
        }else {
            User customer = userService.cretaeUser(userRequest);
            return "redirect:/loginPage";
        }
    }

    @GetMapping("/logout")
    public String logout() {
        session.removeAttribute("user");
        return "redirect:/home";
    }
}
