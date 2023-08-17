package com.abc.demo.ott;

import com.abc.demo.ott.entity.VideoEntity;
import com.abc.demo.ott.repository.VideoRepositoryInterface;
import com.abc.demo.ott.service.VideoService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static reactor.core.publisher.Mono.when;


@SpringBootTest
public class VideoServiceTest {

    @Autowired
    VideoService videoService;

    @MockBean
    VideoRepositoryInterface videoRepository;

    @Test
    public void addVideoTest()  {
        VideoEntity video = new VideoEntity("new video", "description","url", 1);
        Mockito.when(videoRepository.save(video)).thenReturn(video);
        assertEquals(video, videoService.addVideo(video));
    }

}
