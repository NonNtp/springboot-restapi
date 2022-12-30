package com.springboot.blog.controller;

import com.springboot.blog.payload.CommentDto;
import com.springboot.blog.service.CommentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class CommentController {

    private CommentService commentService ;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @PostMapping("/post/{postId}/create-comment")
    public ResponseEntity<CommentDto> createComment(@PathVariable(value="postId") long postId ,
                                                    @Valid @RequestBody CommentDto commentDto) {

        return  new ResponseEntity<>(commentService.createComment(postId , commentDto) , HttpStatus.CREATED) ;

    }

    @GetMapping("/post/{postId}/get-comments")
    public List<CommentDto> getCommentsByPostId(@PathVariable(value="postId") long postId) {
        return  commentService.getCommentsByPostId(postId) ;
    }

    @GetMapping("/post/{postId}/comment/{commentId}/get-comment")
    public ResponseEntity<CommentDto> getCommentById(@PathVariable(value="postId") long postId ,
                                                     @PathVariable(value="commentId") long commentId ) {
        CommentDto commentDto = commentService.getCommentById(postId, commentId);
        return new ResponseEntity<>(commentDto , HttpStatus.OK) ;
    }

    @PutMapping("/post/{postId}/comment/{commentId}/update-comment")
    public ResponseEntity<CommentDto> updateComment(@PathVariable(value="postId") long postId ,
                                                    @PathVariable(value="commentId") long commentId ,
                                                    @Valid @RequestBody CommentDto commentDto) {
        CommentDto updateComment = commentService.updateComment(postId, commentId, commentDto);
        return new ResponseEntity<>(updateComment , HttpStatus.OK) ;
    }

    @DeleteMapping("/post/{postId}/comment/{commentId}/delete-comment")
    public ResponseEntity<String> deleteComment(@PathVariable(value="postId") long postId ,
                                                @PathVariable(value="commentId") long commentId) {
        commentService.deleteComment(postId, commentId);
        return new ResponseEntity<>("Comment has been deleted" , HttpStatus.OK) ;
    }
}
