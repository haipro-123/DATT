package com.poly.datt.service.impl;

import com.poly.datt.entity.Post;
import com.poly.datt.repository.PostRepository;
import com.poly.datt.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class PostServiceImpl implements PostService {
    @Autowired
    private PostRepository postRepository;
    @Override
    public Page<Post> findPaginated(Pageable pageable) {
        int pageSize = pageable.getPageSize();
        int currentPage = pageable.getPageNumber();
        int startItem = currentPage * pageSize;
        List<Post> list;
        List<Post> listAll = postRepository.findAll();
        if (listAll.size() < startItem) {
            list = Collections.emptyList();
        } else {
            int toIndex = Math.min(startItem + pageSize, listAll.size());
            list = listAll.subList(startItem, toIndex);
        }

        Page<Post> listPage
                = new PageImpl<Post>(list, PageRequest.of(currentPage, pageSize), listAll.size());
        return listPage;
    }

    @Override
    public Post savePost(Post post) {
        return postRepository.save(post);
    }
}
