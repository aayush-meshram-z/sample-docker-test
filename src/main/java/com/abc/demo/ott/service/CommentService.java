package com.abc.demo.ott.service;

import com.abc.demo.ott.entity.CommentEntity;
import com.abc.demo.ott.entity.VideoEntity;
import com.abc.demo.ott.repository.CommentRepositoryInterface;
import com.abc.demo.ott.repository.UserRepositoryInterface;
import com.abc.demo.ott.repository.VideoRepositoryInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class CommentService {

    @Autowired
    CommentRepositoryInterface commentRepositoryInterface;

    @Autowired
    UserRepositoryInterface userRepositoryInterface;

    @Autowired
    VideoRepositoryInterface videoRepositoryInterface;

    @Autowired
    KafkaTemplate<String, String> kt;

    public CommentEntity createComment(CommentEntity comment) {

        String message = userRepositoryInterface.findById(comment.getUserID()).get().getUserName()
                + "commented on your video \""+ videoRepositoryInterface.findById(comment.getVideoID()).get().getVideoTitle()
                +"\"";
        kt.send("user_comments", message);

        return commentRepositoryInterface.save(comment);
    }

    public CommentEntity editComment(CommentEntity comment, int userID, int videoID)   {
        CommentEntity current = commentRepositoryInterface.findByVideoIDAndUserID(videoID, userID);
        current.setCommentValue((comment.getCommentValue() != null)? comment.getCommentValue(): current.getCommentValue());
        return commentRepositoryInterface.save(current);
    }

    public void deleteComment(int userID, int videoID) {
        CommentEntity comment = commentRepositoryInterface.findByVideoIDAndUserID(videoID, userID);
        commentRepositoryInterface.delete(comment);
    }
}
