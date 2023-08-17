package com.abc.demo.ott.repository;

import com.abc.demo.ott.entity.GenreEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GenreRepositoryInterface extends JpaRepository<GenreEntity, Integer> {
    GenreEntity findByGenreName(String s);
}
