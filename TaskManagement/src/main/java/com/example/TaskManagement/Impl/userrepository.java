package com.example.TaskManagement.Impl;

import com.example.TaskManagement.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

@Repository
public interface userrepository extends JpaRepository<User,Integer> {


}
