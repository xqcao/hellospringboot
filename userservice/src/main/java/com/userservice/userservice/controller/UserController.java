package com.userservice.userservice.controller;

import java.util.List;

import com.userservice.userservice.VO.UserReponseTemplateVO;
import com.userservice.userservice.entity.User;
import com.userservice.userservice.service.UserService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/users")
@Slf4j
public class UserController {
    @Autowired
    private UserService userService;

    Logger log = LoggerFactory.getLogger(UserController.class);
    @GetMapping("/ping")
    public String ping(){
        return "pong";
    }


    @PostMapping("/save")
    public User saveUser(@RequestBody User user){
        log.info("inside save user from UserController");
        return userService.save(user);
    }

    @GetMapping("/find/{id}")
    public User findUser(@PathVariable("id") Long id){
        log.info("inside find user by id from UserController");

        return userService.findId(id);
    }
    @GetMapping("/all")
    public List<User> getAll(){
        log.info("inside find all users from UserController");
        return userService.getAll();
    }

    @GetMapping("/details/{id}")
    public UserReponseTemplateVO getUserWithDepartment(@PathVariable("id") Long userId){
        return userService.getUserWithDepartment(userId);

    }
}
