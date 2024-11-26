package com.vti.blog_app.service;

import com.vti.blog_app.dto.UserDto;
import com.vti.blog_app.form.UserCreateForm;

public interface UserService {
    UserDto create(UserCreateForm form);
}
