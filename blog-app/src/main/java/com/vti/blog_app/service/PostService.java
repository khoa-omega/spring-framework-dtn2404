package com.vti.blog_app.service;

import com.vti.blog_app.dto.PostDto;
import com.vti.blog_app.form.PostCreateForm;
import com.vti.blog_app.form.PostFilterForm;
import com.vti.blog_app.form.PostUpdateForm;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface PostService {
    Page<PostDto> findAll(PostFilterForm form, Pageable pageable);

    PostDto findById(Long id);

    PostDto create(PostCreateForm form);

    PostDto update(PostUpdateForm form, Long id);

    void deleteById(Long id);
}
