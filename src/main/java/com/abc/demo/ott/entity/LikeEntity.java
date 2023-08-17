package com.abc.demo.ott.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(uniqueConstraints = @UniqueConstraint(columnNames = {"video_like_id", "video_user_id"}))
@NoArgsConstructor
@AllArgsConstructor
public class LikeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int likeID;

    @Column(name = "video_like_id")
    private int videoID;

    @Column(name = "video_user_id")
    private int userID;
}
