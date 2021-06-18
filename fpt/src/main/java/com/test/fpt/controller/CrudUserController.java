package com.test.fpt.controller;

import com.test.fpt.model.dto.request.UserFilter;
import com.test.fpt.model.dto.request.userDTO;
import com.test.fpt.model.dto.response.responseDTO;
import com.test.fpt.model.entity.User;
import com.test.fpt.service.userService.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

//@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(path = "${url}/users", method = RequestMethod.GET)
public class CrudUserController {

    @Autowired
    @Qualifier("UserService")
    UserService userService;

    @PostMapping(value = "/createUser", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> createUser(@Valid @RequestBody User newUser) {
        if(newUser.getRole() == null) newUser.setRole("USER");
        if(newUser.getEnabled() == null) newUser.setEnabled(true);
        userService.createUser(newUser);
        return new ResponseEntity<>("created",HttpStatus.CREATED);
    }

    @GetMapping("/getAllUser")
    public ResponseEntity<List<User>> getUsers() {
        return new ResponseEntity<>(userService.getAllUser(),HttpStatus.OK);
    }

    @GetMapping("/deleteUser/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Long id) {
        if(!userService.deleteUserById(id)) return new ResponseEntity<>("fail deleted",HttpStatus.INTERNAL_SERVER_ERROR);
        return new ResponseEntity<>("deleted",HttpStatus.OK);
    }

    @PutMapping(value = "/updateUser/{id}")
    public ResponseEntity<String>  updateUserById(@PathVariable Long id,@RequestBody UserFilter filter){
            User user = userService.findUserById(id).get();
            if(user != null){
                filter.setId(user.getId());
                userService.updateUser(user,filter);
                return new ResponseEntity<>("updated",HttpStatus.OK);
            }
            return new ResponseEntity<>("fail updated",HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @PostMapping(value = "/findUser", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<User>> findUserBy(@RequestBody UserFilter filter) {
        return new ResponseEntity<>(userService.filterUsers(filter),HttpStatus.OK);
    }

}
