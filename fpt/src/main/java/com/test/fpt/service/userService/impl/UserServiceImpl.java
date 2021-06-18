package com.test.fpt.service.userService.impl;

import com.test.fpt.model.dto.request.UserFilter;
import com.test.fpt.model.entity.User;
import com.test.fpt.repository.UserRepository;
import com.test.fpt.service.userService.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service(value = "UserService")
@Slf4j
public class UserServiceImpl implements UserService {
    @Autowired
    @Qualifier("userRepo")
    UserRepository userRepo;

    @Override
    public Optional<User> findUserById(Long id) {
        return userRepo.findById(id);
    }

    @Override
    public User createUser(User newUser) {
        try {
            userRepo.save(newUser);
        } catch (Exception e) {
            log.info(e.toString());
        }
        return newUser;
    }

    @Override
    public List<User> getAllUser() {
        List<User> listUser = new ArrayList<>();
        try {
            listUser = userRepo.findAll();
        } catch (Exception e) {
            log.info(e.toString());
        }
        return listUser;
    }

    @Override
    public Boolean deleteUserById(Long userId) {
        Boolean isDone = false;
        try {
            userRepo.deleteById(userId);
            isDone = true;
        } catch (Exception e) {
            log.info(e.toString());
        }
        return isDone;
    }

    @Override
    public List<User> filterUsers(UserFilter filter) {
        List<User> listUser = new ArrayList<>();
        try {
            listUser = userRepo.findUsersByFilter(filter.getId(), filter.getUserName(), filter.getFullName(), filter.getAge(), filter.getEmail(),filter.getRole(),filter.getEnabled());
        } catch (Exception e) {
            log.info(e.toString());
        }
        return listUser;
    }

    @Override
    public void updateUser(User updatedUser, UserFilter filter) {
        try {
            if (filter.getId() != null) updatedUser.setId(filter.getId());
            else {
                log.info("dont have user id");
                return;
            }
            if (filter.getUserName() != null) updatedUser.setUserName(filter.getUserName());
            if (filter.getFullName() != null) updatedUser.setFullName(filter.getFullName());
            if (filter.getPassword() != null) updatedUser.setPassword(filter.getPassword());
            if (filter.getAge() != null) updatedUser.setAge(filter.getAge());
            if (filter.getEmail() != null) updatedUser.setEmail(filter.getEmail());
            if (filter.getRole() != null) updatedUser.setRole(filter.getRole());
            if (filter.getEnabled() != null) updatedUser.setEnabled(filter.getEnabled());
            userRepo.save(updatedUser);
        } catch (Exception e) {
            log.info(e.toString());
        }
    }

    @Override
    public Optional<User> FindUserByUserName(String userName) {
        return Optional.empty();
    }

}
