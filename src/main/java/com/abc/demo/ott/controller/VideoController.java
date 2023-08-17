package com.abc.demo.ott.controller;

import com.abc.demo.ott.entity.VideoEntity;
import com.abc.demo.ott.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class VideoController {

    @Autowired
    VideoService videoService;

    @PostMapping("/api/admin/videos")
    public ResponseEntity<String> addVideo(@RequestBody VideoEntity videoEntity)    {
        videoService.addVideo(videoEntity);
        return new ResponseEntity<>("Video Added Successfully", HttpStatus.CREATED);
    }

    @GetMapping("/api/videos/{videoID}")
    public ResponseEntity<VideoEntity> sendVideoDetails(@PathVariable("videoID") int videoID)   {
        return new ResponseEntity<>(videoService.getVideoDetails(videoID), HttpStatus.OK);
    }

    @GetMapping("/api/videos")
    public ResponseEntity<List<VideoEntity>> viewAllVideos()    {
        return new ResponseEntity<>(videoService.getAllVideos(), HttpStatus.OK);
    }

    @GetMapping("/api/genre/{genreID}/videos")
    public ResponseEntity<List<VideoEntity>> viewVideosByGenre(@PathVariable("genreID")int genreID)    {
        return new ResponseEntity<>(videoService.getAllVideoByGenre(genreID), HttpStatus.OK);
    }

    @PutMapping("/api/admin/videos/{videoID}")
    public ResponseEntity<String> updateVideoDetails(@RequestBody VideoEntity videoEntity, @PathVariable("videoID") int videoID)  {
        videoService.updateVideoDetails(videoID, videoEntity);
        return new ResponseEntity<>("Video details updated successfully", HttpStatus.OK);
    }

    @DeleteMapping("/api/admin/videos/{videoID}")
    public ResponseEntity<String> deleteVideo(@PathVariable("videoID")int videoID) {
        videoService.deleteVideo(videoID);
        return new ResponseEntity<>("Video deleted successfully", HttpStatus.OK);
    }
}
