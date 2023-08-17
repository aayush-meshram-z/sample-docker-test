package com.abc.demo.ott.repository;

import com.abc.demo.ott.entity.VideoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VideoRepositoryInterface extends JpaRepository<VideoEntity, Integer> {

//    List<VideoEntity> findByVideoGenreID(int genreID);

}
