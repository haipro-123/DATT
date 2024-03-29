package com.poly.datt.repository;

import com.poly.datt.entity.Like;
import com.poly.datt.entity.Post;
import com.poly.datt.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface LikeRepository extends JpaRepository<Like, UUID> {
    Like findByUserAndPost(User user, Post post);
}
