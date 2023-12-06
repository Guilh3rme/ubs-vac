package com.project.ubsvac.services.User;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.project.ubsvac.entity.UserEntity;
import com.project.ubsvac.models.UserModel;
import com.project.ubsvac.repositories.UserRepository;

@Service
public class UserServerImplementation implements UserService {
    private UserRepository userRepository;

    public UserServerImplementation(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserModel createNewUser(UserModel user) {
        UserEntity userEntity = new UserEntity();
        BeanUtils.copyProperties(user, userEntity);
        userRepository.save(userEntity);
        return user;
    }

    @Override
    public List<UserModel> getAllUsers() {
        List<UserEntity> userEntities = userRepository.findAll();
        List<UserModel> users = userEntities
                .stream()
                .map(userEntity -> new UserModel())
                .collect(Collectors.toList());
        return users;

    }

    @Override
    public UserModel getUserById(Long id) {
        UserEntity userEntity = userRepository.findById(id).get();
        UserModel user = new UserModel();
        BeanUtils.copyProperties(userEntity, user);
        return user;

    }

    @Override
    public boolean deleteUser(Long id) {
        UserEntity user = userRepository.findById(id).get();
        userRepository.delete(user);
        return true;
    }

    @Override
    public UserModel updateUser(Long id, UserModel user) {
        UserEntity userEntity = userRepository.findById(id).get();
        userEntity.setEmail(user.getEmail());
        userEntity.setNome(user.getNome());
        userRepository.save(userEntity);
        return user;
    }
}
