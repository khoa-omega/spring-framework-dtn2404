package com.vti.blog_app.validation;

import com.vti.blog_app.repository.PostRepository;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class PostIdExistsValidator implements ConstraintValidator<PostIdExists, Long> {
    private PostRepository postRepository;

    @Override
    public boolean isValid(Long id, ConstraintValidatorContext context) {
        return postRepository.existsById(id);
    }
}
