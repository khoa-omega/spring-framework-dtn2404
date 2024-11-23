package com.vti.blog_app.form;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

@Getter
@Setter
public class PostCreateForm {
    @NotBlank(message = "Tiêu đề không được để trống")
    @Length(max = 50, message = "Tiêu đề có tối đa 50 kí tự")
    private String title;

    @NotBlank(message = "Mô tả không được để trống")
    @Length(max = 100, message = "Mô tả có tối đa 100 kí tự")
    private String description;

    @NotBlank(message = "Nội dung không được để trống")
    @Length(max = 150, message = "Nội dung có tối đa 150 kí tự")
    private String content;
}
