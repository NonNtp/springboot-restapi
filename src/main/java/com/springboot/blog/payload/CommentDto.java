package com.springboot.blog.payload;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
public class CommentDto {

    private long id ;

    @NotBlank
    @Size(min = 2 , message = "Comment name should have at least 2 character")
    private String name ;

    @NotBlank(message = "Email has not empty")
    @Email
    private String email ;

    @NotBlank
    @Size(min = 10 , message = "Comment body should have at least 10 character")
    private String body ;

}
