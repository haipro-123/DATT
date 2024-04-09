package com.poly.datt.service.impl;

import com.poly.datt.entity.Profile;
import com.poly.datt.repository.ProfileRepository;
import com.poly.datt.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProfileServiceImpl implements ProfileService{
    @Autowired
    private ProfileRepository profileRepository;

    @Override
    public void update(Profile profile) {
        profileRepository.save(profile);
    }
}
