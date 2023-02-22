package com.errorit.erroritoverflow.app.comment.controller;

import com.errorit.erroritoverflow.app.comment.dto.CommentDto;
import com.errorit.erroritoverflow.app.comment.entity.Comment;
import com.errorit.erroritoverflow.app.comment.mapper.CommentMapper;
import com.errorit.erroritoverflow.app.comment.repository.CommentRepository;
import com.errorit.erroritoverflow.app.comment.service.CommentService;
import com.errorit.erroritoverflow.app.question.dto.QuestionDto;
import com.errorit.erroritoverflow.app.question.entity.Question;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Positive;

@RestController
@RequestMapping("/comments")
@RequiredArgsConstructor
public class CommentController {
    private final CommentService commentService;
    private final CommentMapper mapper;
    private final CommentRepository commentRepository;

    @PostMapping
    public ResponseEntity postComment(@Valid @RequestBody CommentDto.Post requestDto){
        Comment comment = mapper.commentPostDtoToComment(requestDto);
        Comment createComment = commentService.createComment(comment);

        return new ResponseEntity<>(mapper.commentToCommentResponseDto(comment),
                HttpStatus.OK);
    }

    @PatchMapping("/{comment-id}")
    public ResponseEntity patchComment(@PathVariable("comment-id") @Positive long commentId,
                                        @RequestBody CommentDto.Patch requestDto){

        requestDto.setCommentId(commentId);
        Comment comment =
                commentService.updateComment(mapper.commentPatchDtoToComment(requestDto));

        return new ResponseEntity<>(mapper.commentToCommentResponseDto(comment)
                ,HttpStatus.OK);
    }

    @GetMapping("/comment-id")
    public ResponseEntity getComment(@PathVariable("comment-id") @Positive long commentId){
        Comment comment = commentService.findComment(commentId);

        return new ResponseEntity(mapper.commentToCommentResponseDto(comment),
                HttpStatus.OK);
    }

    @DeleteMapping("/{comment-id}")
    public ResponseEntity deleteComment(@PathVariable("comment-id") @Positive long commentId){

        commentService.deleteComment(commentId);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}