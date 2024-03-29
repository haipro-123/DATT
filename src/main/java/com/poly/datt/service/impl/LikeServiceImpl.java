package com.poly.datt.service.impl;

import com.poly.datt.entity.Like;
import com.poly.datt.entity.Post;
import com.poly.datt.entity.User;
import com.poly.datt.repository.LikeRepository;
import com.poly.datt.repository.PostRepository;
import com.poly.datt.repository.UserRepository;
import com.poly.datt.service.LikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LikeServiceImpl implements LikeService {
    @Autowired
    private LikeRepository likeRepository;
    @Autowired
    private PostRepository postRepository;
    @Autowired
    private UserRepository userRepository;
    @Override
    public Like check(Post post, User user) {
        return likeRepository.findByUserAndPost(user,post);
    }

    @Override
    public void save(Like likeNew) {
        likeRepository.save(likeNew);
    }
}
