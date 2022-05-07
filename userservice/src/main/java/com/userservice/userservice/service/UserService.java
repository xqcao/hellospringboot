package com.userservice.userservice.service;

import java.util.List;

import com.userservice.userservice.VO.Department;
import com.userservice.userservice.VO.UserReponseTemplateVO;
import com.userservice.userservice.entity.User;
import com.userservice.userservice.repository.UserRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RestTemplate restTemplate;



    Logger log = LoggerFactory.getLogger(UserService.class);

    public User save(User user) {
        log.info("inside save user from userService");
        return userRepository.save(user);
    }

    public User findId(Long id) {
        log.info("inside find one user by id from userService");
        return userRepository.findByUserId(id);
    }

    public List<User> getAll() {
        log.info("inside list all users from userService");
        return userRepository.findAll();
    }

    public UserReponseTemplateVO getUserWithDepartment(Long userId) {
        UserReponseTemplateVO vo = new UserReponseTemplateVO();
        User user = userRepository.findByUserId(userId);
        
        Department dep = restTemplate.getForObject("http://localhost:9001/departments/find/"+user.getDepartmentId(), Department.class);
        vo.setDepartment(dep);
        vo.setUser(user);
        
        return vo;
    }
    
}
