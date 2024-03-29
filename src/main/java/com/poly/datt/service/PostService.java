package com.poly.datt.service;

import com.poly.datt.entity.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public interface PostService {
    Page<Post> findPaginated(Pageable of);
}
