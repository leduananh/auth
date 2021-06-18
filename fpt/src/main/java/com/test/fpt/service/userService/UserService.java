package com.test.fpt.service.userService;

import com.test.fpt.model.dto.request.UserFilter;
import com.test.fpt.model.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    Optional<User> findUserById(Long id);

    User createUser(User newUser);

    List<User> getAllUser();

    Boolean deleteUserById(Long userId);

    List<User> filterUsers(UserFilter filter);

    void updateUser(User updatedUser,UserFilter filter);

    Optional<User> FindUserByUserName(String userName);
}
