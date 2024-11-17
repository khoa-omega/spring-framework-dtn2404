package com.vti.blog_app.service;

import com.vti.blog_app.dto.CommentDto;
import com.vti.blog_app.form.CommentCreateForm;
import com.vti.blog_app.form.CommentUpdateForm;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CommentService {
    Page<CommentDto> findAll(Pageable pageable);

    CommentDto findById(Long id);

    CommentDto create(CommentCreateForm form);

    CommentDto update(CommentUpdateForm form, Long id);

    void deleteById(Long id);
}
