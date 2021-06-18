package com.test.fpt.repository;

import com.test.fpt.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository(value = "userRepo")
public interface UserRepository extends JpaRepository<User,Long> {

    Optional<User> findAllByAge(Integer age);

    void deleteById(Long userId);

    @Query(value = "select * from _user where (:id is null or id = :id) and (:username is null or user_name like %:username%) and (:fullname is null or full_name like %:fullname%) and (:age is null or age = :age) and (:email is null or email = :email)  and (:role is null or role = :role)  and (:enable is null or enabled = :enable) ", nativeQuery = true)
    List<User> findUsersByFilter(@Param("id") Long id, @Param("username") String userName, @Param("fullname") String fullName, @Param("age") Integer age,@Param("email") String email,@Param("role") String role,@Param("enable") Boolean enable);

    Optional<User> findUsersByUserName(String userName);
}
