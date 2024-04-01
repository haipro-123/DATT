package com.poly.datt.service;

import com.poly.datt.entity.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.UUID;

public interface PostService {
    Page<Post> findPaginated(Pageable of);
    Post savePost(Post post);

    Post getOne(UUID idPost);
}
