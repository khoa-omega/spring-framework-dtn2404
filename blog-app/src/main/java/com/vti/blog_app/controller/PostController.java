package com.vti.blog_app.controller;

import com.vti.blog_app.dto.PostDto;
import com.vti.blog_app.form.PostCreateForm;
import com.vti.blog_app.form.PostFilterForm;
import com.vti.blog_app.form.PostUpdateForm;
import com.vti.blog_app.service.PostService;
import com.vti.blog_app.validation.PostIdExists;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@AllArgsConstructor
@CrossOrigin("*")
// @CrossOrigin("https://www.google.com")
public class PostController {
    private PostService postService;

    @GetMapping("/api/v1/posts")
    public Page<PostDto> findAll(PostFilterForm form, Pageable pageable) {
        return postService.findAll(form, pageable);
    }

    @GetMapping("/api/v1/posts/{id}")
    public PostDto findById(
            @PathVariable("id") @PostIdExists Long id
    ) {
        return postService.findById(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/api/v1/posts")
    public PostDto create(@RequestBody @Valid PostCreateForm form) {
        return postService.create(form);
    }

    @PutMapping("/api/v1/posts/{id}")
    public PostDto update(
            @RequestBody @Valid PostUpdateForm form,
            @PathVariable("id") @PostIdExists Long id
    ) {
        return postService.update(form, id);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/api/v1/posts/{id}")
    public void deleteById(
            @PathVariable("id") @PostIdExists Long id
    ) {
        postService.deleteById(id);
    }
}
