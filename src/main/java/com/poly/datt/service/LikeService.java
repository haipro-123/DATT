package com.poly.datt.service;

import com.poly.datt.entity.Like;
import com.poly.datt.entity.Post;
import com.poly.datt.entity.User;

public interface LikeService {
    Like check(Post post, User user);

    void save(Like likeNew);
}
