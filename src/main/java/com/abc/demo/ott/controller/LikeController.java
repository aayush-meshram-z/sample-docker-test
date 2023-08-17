package com.abc.demo.ott.controller;

import com.abc.demo.ott.entity.LikeEntity;
import com.abc.demo.ott.service.LikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
public class LikeController {

    @Autowired
    LikeService likeService;

    @GetMapping("/api/video/{videoID}/{userID}/like")
    public ResponseEntity<String> createLike(@PathVariable("videoID") int videoID,
                                     @PathVariable("userID") int userID) {
        LikeEntity like = new LikeEntity();
        like.setUserID(userID);
        like.setVideoID(videoID);

        likeService.createLike(like);
        return new ResponseEntity<>("Like created successfully", HttpStatus.CREATED);
    }

    @DeleteMapping("/api/video/{videoID}/{userID}/dislike")
    public ResponseEntity<String> deleteLike(@PathVariable("videoID") int videoID,
                                             @PathVariable("userID") int userID) {

        likeService.deleteLike(userID, videoID);
        return new ResponseEntity<>("Like removed", HttpStatus.OK);
    }


}
