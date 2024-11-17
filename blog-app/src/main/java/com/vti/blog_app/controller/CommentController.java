package com.vti.blog_app.controller;

import com.vti.blog_app.dto.CommentDto;
import com.vti.blog_app.form.CommentCreateForm;
import com.vti.blog_app.form.CommentUpdateForm;
import com.vti.blog_app.service.CommentService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
public class CommentController {
    private CommentService commentService;

    @GetMapping("/api/v1/comments")
    public Page<CommentDto> findAll(Pageable pageable) {
        return commentService.findAll(pageable);
    }

    @GetMapping("/api/v1/comments/{id}")
    public CommentDto findById(@PathVariable("id") Long id) {
        return commentService.findById(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/api/v1/comments")
    public CommentDto create(@RequestBody CommentCreateForm form) {
        return commentService.create(form);
    }

    @PutMapping("/api/v1/comments/{id}")
    public CommentDto update(
            @RequestBody CommentUpdateForm form,
            @PathVariable("id") Long id
    ) {
        return commentService.update(form, id);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/api/v1/comments/{id}")
    public void deleteById(@PathVariable("id") Long id) {
        commentService.deleteById(id);
    }
}
