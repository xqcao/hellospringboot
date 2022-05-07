package com.userservice.userservice.repository;

import com.userservice.userservice.entity.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long>{

    User findByUserId(Long id);
    
}
