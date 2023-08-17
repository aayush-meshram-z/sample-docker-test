package com.abc.demo.ott.service;

import com.abc.demo.ott.entity.UserEntity;
import com.abc.demo.ott.helper.CurrentDateHelper;
import com.abc.demo.ott.repository.UserRepositoryInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepositoryInterface uri;

    public UserEntity createUser(UserEntity user)    {
        user.setUserCreatedAt(CurrentDateHelper.now());
        return uri.save(user);
    }

    public void deleteUser(int userID)    {
        uri.delete(uri.findById(userID).get());
    }

}
