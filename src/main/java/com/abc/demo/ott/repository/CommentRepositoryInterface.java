package com.abc.demo.ott.repository;

import com.abc.demo.ott.entity.CommentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepositoryInterface extends JpaRepository<CommentEntity, Integer> {

    CommentEntity findByVideoIDAndUserID(int videoID, int userID);

}
