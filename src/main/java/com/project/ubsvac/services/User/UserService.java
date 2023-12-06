package com.project.ubsvac.services.User;

import java.util.List;

import com.project.ubsvac.models.UserModel;

public interface UserService {

    UserModel createNewUser(UserModel user);

    List<UserModel> getAllUsers();

    UserModel getUserById(Long id);

    boolean deleteUser(Long id);

    UserModel updateUser(Long id, UserModel user);

}
