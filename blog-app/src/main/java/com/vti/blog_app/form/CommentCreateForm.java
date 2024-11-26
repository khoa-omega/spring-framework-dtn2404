package com.vti.blog_app.form;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

@Getter
@Setter
public class CommentCreateForm {
    @NotBlank(message = "Tên không được để trống")
    @Length(max = 50, message = "Tên có tối đa 50 kí tự")
    private String name;

    @Email(message = "Email không đúng định dạng")
    @NotBlank(message = "Email không được để trống")
    @Length(max = 75, message = "Email có tối đa 75 kí tự")
    private String email;

    @NotBlank(message = "Body không được để trống")
    @Length(max = 100, message = "Body có tối đa 100 kí tự")
    private String body;
}
