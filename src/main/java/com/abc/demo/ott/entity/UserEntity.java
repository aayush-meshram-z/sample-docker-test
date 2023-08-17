package com.abc.demo.ott.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;


@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "User", uniqueConstraints = @UniqueConstraint(columnNames = "userEmail"))
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int userID;

    private String userName;

    private String userPassword;

    //@Email(message = "entered email is not valid.", regexp = "[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,3}", flags = Pattern.Flag.CASE_INSENSITIVE)
    private String userEmail;

    private String userCreatedAt;

    private String userUpdatedAt;

    @OneToMany(targetEntity = VideoEntity.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "uploaded_by", referencedColumnName = "userID")
    private List<VideoEntity> videoUploadList;

    public UserEntity(String userName, String userEmail, String userPassword)   {
        this.userName = userName;
        this.userEmail = userEmail;
        this.userPassword = userPassword;
    }

}
