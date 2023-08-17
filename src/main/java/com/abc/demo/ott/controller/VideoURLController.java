package com.abc.demo.ott.controller;

import com.abc.demo.ott.entity.VideoEntity;
import com.abc.demo.ott.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class VideoURLController {

    @Autowired
    VideoService videoService;

    @GetMapping("/api/play/{videoID}")
    public String runVideoURL(@PathVariable("videoID")int videoID, Model m) {
        String URL = videoService.getVideoDetails(videoID).getVideoURL();
        m.addAttribute("videoLink", URL);
        return "videodisplay";
    }

}
