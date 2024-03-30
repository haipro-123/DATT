package com.poly.datt.service;

import com.poly.datt.dto.PostDTO;
import com.poly.datt.entity.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

public interface PostService {
    Page<Post> findPaginated(Pageable of);
    Post savePost(Post post);
}
