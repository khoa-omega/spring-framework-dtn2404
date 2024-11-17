package com.vti.blog_app.service;

import com.vti.blog_app.dto.CommentDto;
import com.vti.blog_app.form.CommentCreateForm;
import com.vti.blog_app.form.CommentUpdateForm;
import com.vti.blog_app.mapper.CommentMapper;
import com.vti.blog_app.repository.CommentRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CommentServiceImpl implements CommentService {
    private CommentRepository commentRepository;

    @Override
    public Page<CommentDto> findAll(Pageable pageable) {
        return commentRepository.findAll(pageable)
                .map(CommentMapper::map);
    }

    @Override
    public CommentDto findById(Long id) {
        return commentRepository.findById(id)
                .map(CommentMapper::map)
                .orElse(null);
    }

    @Override
    public CommentDto create(CommentCreateForm form) {
        var comment = CommentMapper.map(form);
        var savedComment = commentRepository.save(comment);
        return CommentMapper.map(savedComment);
    }

    @Override
    public CommentDto update(CommentUpdateForm form, Long id) {
        var optional = commentRepository.findById(id);
        if (optional.isEmpty()) {
            return null;
        }
        var comment = optional.get();
        CommentMapper.map(form, comment);
        var savedComment = commentRepository.save(comment);
        return CommentMapper.map(savedComment);
    }

    @Override
    public void deleteById(Long id) {
        commentRepository.deleteById(id);
    }
}
