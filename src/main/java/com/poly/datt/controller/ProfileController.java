package com.poly.datt.controller;

import com.poly.datt.dto.ProfileDto;
import com.poly.datt.dto.UserDTO;
import com.poly.datt.entity.Profile;
import com.poly.datt.entity.User;
import com.poly.datt.repository.ProfileRepository;
import com.poly.datt.service.ProfileService;
import com.poly.datt.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;

import java.util.UUID;

@Controller
public class ProfileController {
    @Autowired
    private UserService userService;

    @Autowired
    private ProfileService profileService;
    @Autowired
    private ProfileRepository profileRepository;
    @GetMapping("/profile/hien-thi")
    public String hienthi(){
        return "/profile/listProfile";
    }
    @PostMapping("/profile/{id}")
    public String getprofile(@SessionAttribute("userdto") UserDTO userDto,
                             @PathVariable String id ,
                             Model model,
                             @ModelAttribute("profile") ProfileDto profileDto){
        Profile profileupdate = profileRepository.findProfileById(String.valueOf(id));
        profileupdate.setAdress(profileDto.getAdress());
        profileupdate.setDateofBirth(profileDto.getDateofBirth());
        profileupdate.setGender(profileDto.getGender());
        profileupdate.setFirstName(profileDto.getFirstName());
        profileupdate.setLastName(profileDto.getLastName());
        profileService.update(profileupdate);
        return "redirect:/profile";
    }
}
