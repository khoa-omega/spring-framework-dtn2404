package com.vti.blog_app.entity;

import com.vti.blog_app.converter.UserRoleConverter;
import com.vti.blog_app.generator.UserIdGenerator;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.JdbcType;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.type.descriptor.jdbc.CharJdbcType;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "user")
public class User {
    @Id
    @Column(name = "id")
    // Cách 1: GenerationType.IDENTITY
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    // Cách 2: SEQUENCE
    // @SequenceGenerator(
    //         name = "user_id_generator",
    //         sequenceName = "user_id_sequence",
    //         initialValue = 10,
    //         allocationSize = 1
    // )
    // @GeneratedValue(generator = "user_id_generator")
    // Cách 3: GenerationType.UUID
    // @GeneratedValue(strategy = GenerationType.UUID)
    // @JdbcType(value = CharJdbcType.class)
    // private UUID id;
    // Cách 4: @GeneratedValue(strategy = GenerationType.AUTO)
    // Cách 5: Custom
    // @GenericGenerator(
    //         name = "user_id_generator",
    //         type = UserIdGenerator.class
    // )
    // @GeneratedValue(generator = "user_id_generator")
    // private String id;

    @Column(name = "name", length = 50, nullable = false)
    private String name;

    @Column(name = "username", length = 50, unique = true, nullable = false)
    private String username;

    @Column(name = "email", length = 50, unique = true, nullable = false)
    private String email;

    @Column(name = "password", length = 100, nullable = false)
    private String password;

    @Column(name = "role", nullable = false)
    // Cách 1: EnumType.ORDINAL
    // @Enumerated(value = EnumType.ORDINAL)
    // Cách 2: EnumType.STRING
    // @Enumerated(value = EnumType.STRING)
    // Cách 3: @Convert
    @Convert(converter = UserRoleConverter.class)
    private Role role;

    @Column(name = "created_at", nullable = false, updatable = false)
    @CreationTimestamp
    private LocalDateTime createdAt;

    @Column(name = "updated_at", nullable = false)
    @UpdateTimestamp
    private LocalDateTime updatedAt;

    public enum Role {
        ADMIN, EMPLOYEE, MANAGER
    }
}
