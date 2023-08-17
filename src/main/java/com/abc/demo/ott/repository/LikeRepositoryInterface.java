package com.abc.demo.ott.repository;

import com.abc.demo.ott.entity.LikeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LikeRepositoryInterface extends JpaRepository<LikeEntity, Integer> {

    LikeEntity findByVideoIDAndUserID(int videoID, int userID);
}
