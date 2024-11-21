package com.vti.blog_app.service;

import com.vti.blog_app.dto.PostDto;
import com.vti.blog_app.form.PostCreateForm;
import com.vti.blog_app.form.PostFilterForm;
import com.vti.blog_app.form.PostUpdateForm;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class PostServiceImplV2 implements PostService {
    @Override
    public Page<PostDto> findAll(PostFilterForm form, Pageable pageable) {
        return null;
    }

    @Override
    public PostDto findById(Long id) {
        return null;
    }

    @Override
    public PostDto create(PostCreateForm form) {
        return null;
    }

    @Override
    public PostDto update(PostUpdateForm form, Long id) {
        return null;
    }

    @Override
    public void deleteById(Long id) {

    }
}
