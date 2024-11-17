package com.vti.blog_app.mapper;

import com.vti.blog_app.dto.PostDto;
import com.vti.blog_app.entity.Post;
import com.vti.blog_app.form.PostCreateForm;
import com.vti.blog_app.form.PostUpdateForm;

public class PostMapper {
    public static PostDto map(Post post) {
        var dto = new PostDto();
        dto.setId(post.getId());
        dto.setTitle(post.getTitle());
        dto.setDescription(post.getDescription());
        dto.setContent(post.getContent());
        dto.setCreatedAt(post.getCreatedAt());
        dto.setUpdatedAt(post.getUpdatedAt());
        return dto;
    }

    public static Post map(PostCreateForm form) {
        var post = new Post();
        post.setTitle(form.getTitle());
        post.setDescription(form.getDescription());
        post.setContent(form.getContent());
        return post;
    }

    public static void map(PostUpdateForm form, Post post) {
        post.setTitle(form.getTitle());
        post.setDescription(form.getDescription());
        post.setContent(form.getContent());
    }
}
