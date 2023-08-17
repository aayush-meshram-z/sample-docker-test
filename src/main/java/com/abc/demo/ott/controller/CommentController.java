package com.abc.demo.ott.controller;

import com.abc.demo.ott.entity.CommentEntity;
import com.abc.demo.ott.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class CommentController {

    @Autowired
    CommentService commentService;

    @PostMapping("api/videos/{videoID}/{userID}/comment")
    public ResponseEntity<String> createComment(@PathVariable("videoID") int videoID,
                                        @PathVariable("userID") int userID,
                                                @RequestBody CommentEntity comment) {

        comment.setUserID(userID);
        comment.setVideoID(videoID);

        commentService.createComment(comment);
        return new ResponseEntity<>("Comment created successfully", HttpStatus.CREATED);
    }

    @PutMapping("api/videos/{videoID}/{userID}/comment")
    public ResponseEntity<String> updateComment(@PathVariable("videoID") int videoID,
                                                @PathVariable("userID") int userID,
                                                @RequestBody CommentEntity comment) {
        commentService.editComment(comment,userID, videoID);
        return new ResponseEntity<>("Comment updated successfully", HttpStatus.CREATED);
    }


    @DeleteMapping("api/videos/{videoID}/{userID}/comment/delete")
    public ResponseEntity<String> deleteComment(@PathVariable("videoID") int videoID,
                                                @PathVariable("userID") int userID) {
        commentService.deleteComment(userID, videoID);
        return new ResponseEntity<>("Comment deleted successfully", HttpStatus.OK);
    }
}
