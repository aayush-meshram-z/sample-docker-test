package com.abc.demo.ott.service;

import com.abc.demo.ott.entity.LikeEntity;
import com.abc.demo.ott.repository.LikeRepositoryInterface;
import com.abc.demo.ott.repository.UserRepositoryInterface;
import com.abc.demo.ott.repository.VideoRepositoryInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class LikeService {


    @Autowired
    LikeRepositoryInterface likeRepositoryInterface;

    @Autowired
    UserRepositoryInterface userRepositoryInterface;

    @Autowired
    VideoRepositoryInterface videoRepositoryInterface;

    @Autowired
    KafkaTemplate<String, String> kt;

    public LikeEntity createLike(LikeEntity entity)    {
        String message = userRepositoryInterface.findById(entity.getUserID()).get().getUserName()
                + "liked your video \""+ videoRepositoryInterface.findById(entity.getVideoID()).get().getVideoTitle()
                +"\"";
        kt.send("user_likes", message);
        return likeRepositoryInterface.save(entity);
    }

    public void deleteLike(int userID, int videoID)    {
        LikeEntity like = likeRepositoryInterface.findByVideoIDAndUserID(videoID, userID);
        String message = userRepositoryInterface.findById(userID).get().getUserName()
                + "liked your video \""+ videoRepositoryInterface.findById(videoID).get().getVideoTitle()
                +"\"";
        kt.send("user_likes", message);
        likeRepositoryInterface.delete(like);
    }

}
