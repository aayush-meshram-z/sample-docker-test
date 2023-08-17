package com.abc.demo.ott.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.apache.catalina.User;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class VideoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int videoID;

    private String videoTitle;

    @Lob
    private String videoDescription;

    private String videoURL;

    //private String[] genreList;

    @ManyToMany(cascade = CascadeType.MERGE)
    //@JoinColumn(referencedColumnName = "videoEntitySet")
    //@ManyToMany
    @JoinTable(
            name = "videoGenreLink",
            joinColumns = {@JoinColumn(name = "videoID")},
            inverseJoinColumns = {@JoinColumn(name = "genreID")}
    )
    private Set<GenreEntity> videoGenreID = new HashSet<>();

    @Column(name = "uploaded_by")
    private int videoUploadedBy;

    private String videoCreatedAt;

    @OneToMany(targetEntity = LikeEntity.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "video_like_id", referencedColumnName = "videoID")
    private List<LikeEntity> likeList;

    @OneToMany(targetEntity = CommentEntity.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "video_comment_id", referencedColumnName = "videoID")
    private List<CommentEntity> commentList;

    public VideoEntity(String videoTitle, String videoDescription, String videoURL, int videoUploadedBy)    {
        this.videoTitle = videoTitle;
        this.videoDescription = videoDescription;
        this.videoURL = videoURL;
        this.videoUploadedBy = videoUploadedBy;
    }

}
