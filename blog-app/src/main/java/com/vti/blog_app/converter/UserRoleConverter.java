package com.vti.blog_app.converter;

import com.vti.blog_app.entity.User;
import jakarta.persistence.AttributeConverter;

public class UserRoleConverter implements AttributeConverter<User.Role, Character> {
    @Override
    public Character convertToDatabaseColumn(User.Role role) {
        return role.toString().charAt(0);
    }

    @Override
    public User.Role convertToEntityAttribute(Character code) {
        if (code == 'A') {
            return User.Role.ADMIN;
        }
        if (code == 'E') {
            return User.Role.EMPLOYEE;
        }
        return User.Role.MANAGER;
    }
}
