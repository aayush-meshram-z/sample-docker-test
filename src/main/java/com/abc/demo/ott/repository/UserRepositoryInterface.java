package com.abc.demo.ott.repository;

import com.abc.demo.ott.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepositoryInterface extends JpaRepository<UserEntity, Integer> {
}
