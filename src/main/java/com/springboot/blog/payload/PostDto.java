package com.springboot.blog.payload;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.Set;

@Data
public class PostDto {

    private Long id ;

    @NotBlank
    @Size(min = 2 , message = "Post title should have at least 2 character")
    private String title ;

    @NotBlank
    @Size(min = 10 , message = "Post description should have at least 2 character")
    private String description ;

    @NotBlank
    @Size(min = 5 , message = "Post content should have at least 2 character")
    private String content ;

    private Set<CommentDto> comments ;
}
