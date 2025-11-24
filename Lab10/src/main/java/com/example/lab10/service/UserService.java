package com.example.lab10.service;

import com.example.lab10.model.User;
import com.example.lab10.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public void AddUser (User user){
        userRepository.save(user);
    }


    public boolean updateUser(Integer Id, User user) {
        User oldUser = userRepository.getById(Id);
        if (oldUser == null) {
            return false;
        }

        oldUser.setName(user.getName());
        oldUser.setEmail(user.getEmail());
        oldUser.setPassword(user.getPassword());
        oldUser.setAge(user.getAge());
        oldUser.setRole(user.getRole());

        userRepository.save(oldUser);
        return true;
    }

    public boolean deleteUser(Integer Id) {
        User user = userRepository.getById(Id);
        if (user == null) {
            return false;
        }
        userRepository.delete(user);
        return true;
    }

}
